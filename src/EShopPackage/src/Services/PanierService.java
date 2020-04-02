/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Panier;
import Entities.Produit;
import Iservices.IPanier;
import Utilities.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Ghassen
 */
public class PanierService implements IPanier {

    Connection connection = null;

    public PanierService() {
        connection = DataSource.getInstance().getConnection();
    }
    Statement st;
    PreparedStatement pt;
    ResultSet rs;

    @Override
    public void AjouterAuPanier(Produit a) {

        String requete = "INSERT INTO panier(idProd,nomProd,prix,img,idU,quantite) VALUES(?,?,?,?,?,?)";

        try {
            pt = connection.prepareStatement(requete);
            pt.setInt(1, a.getId());
            pt.setString(2, a.getNom());
            pt.setFloat(3, a.getPrix());
            pt.setString(4, a.getImg());

            //***** A Modifier Apres Implementation Session ( getsession); ********////////
            pt.setString(5, "1");
            //*********************************************************************///////////
            pt.setString(6, "1");

            pt.executeUpdate();

            System.out.println("Produit ajouté au Panier ");
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void SupprimerDuPanier(int id) {
        String req = "delete from panier where idProd ='" + id + "'";

        try {
            pt = connection.prepareStatement(req);
            pt.executeUpdate();
            System.out.println("Suppression terminé avec succes ");

        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("not ok");
        }

    }

    /**
     * ***********************TO DO*****************************************
     */
    @Override
    public int LonguerPanier() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * *******************************************************************
     */
    @Override
    public ObservableList<Panier> getPanierByUser() {

        /**
         * ************************* Recuperih Mel Session
         * *********************
         */
        int idU = 1;
        /**
         * *********************************************************************
         */

        ObservableList<Panier> panier = FXCollections.observableArrayList();
        String req = "SELECT * FROM `panier` WHERE `idU`='" + idU + "' ";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);

            while (resultSet.next()) {
                ImageView photo = new ImageView(new Image(this.getClass().getResourceAsStream("" + resultSet.getString(5))));
                Panier p = new Panier(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getFloat(4), photo, resultSet.getString(5), resultSet.getInt(6), resultSet.getInt(7));
                panier.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return panier;
    }

    @Override
    public int ajouterQuantite(int id) {

        String req = "UPDATE `panier` SET `quantite`= `quantite` + 1 WHERE `idProd`='" + id + "' ";
        //UPDATE `DropletNames` SET `Monday` = `Monday` + 1 WHERE `Title = "Travel to Mars"

        try {
            pt = connection.prepareStatement(req);
            pt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 0;
    }

    @Override
    public int modifierQuantite(int id, String quantite) {

        String req = "UPDATE `panier` SET quantite='" + quantite + "' WHERE `idProd`='" + id + "' ";

        try {
            pt = connection.prepareStatement(req);

            pt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 0;
    }

    @Override
    public void SupprimerById(int id) {

        String req = "delete from panier where id ='" + id + "'";
        System.out.println(req);

        try {
            pt = connection.prepareStatement(req);
            pt.executeUpdate();
            System.out.println("Suppression terminé avec succes ");

        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("not ok");
        }
    }

}
