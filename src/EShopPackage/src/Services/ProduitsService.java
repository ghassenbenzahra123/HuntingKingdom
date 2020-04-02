/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Produit;
import Iservices.IProduits;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utilities.DataSource;
import java.sql.PreparedStatement;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

/**
 *
 * @author Ghassen
 */
public class ProduitsService implements IProduits {

    Connection connection = null;
    PreparedStatement pt;
    ResultSet rs;

    public ProduitsService() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public List<Produit> selectAll() {
        List<Produit> produits = new ArrayList<Produit>();
        String req = "select * from Produit";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);

            while (resultSet.next()) {
                ImageView photo = new ImageView(new Image(this.getClass().getResourceAsStream("" + resultSet.getString(4))));
                Produit p = new Produit(resultSet.getInt(1), resultSet.getFloat(2), resultSet.getString(3), resultSet.getString(5), resultSet.getString(6), resultSet.getString(5), photo);
                produits.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProduitsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produits;

    }

    @Override
    public Produit RecupererProduit(int id) {

        String req = "SELECT * FROM `produit` WHERE `id`='" + id + "' ";
        try {
            pt = connection.prepareStatement(req);
            rs = pt.executeQuery();
            Produit a = new Produit();
            while (rs.next()) {
                a.setId(rs.getInt(1));
                a.setNom(rs.getString(6));
                a.setType(rs.getString(3));
                a.setImg(rs.getString(4));
                a.setPrix(rs.getFloat(2));
                a.setDescription(rs.getString(5));

            }

            return a;

        } catch (SQLException ex) {
            Logger.getLogger(ProduitsService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public int existProduit(int id) {
        String req = "SELECT * FROM `panier` WHERE `idProd`='" + id + "' ";
        try {
            pt = connection.prepareStatement(req);
            ResultSet res = pt.executeQuery();
            if (res.absolute(1)) {

                System.out.print("Prod Existe quantite ++ ");
                return 1;
            } else {
                System.out.print(" Prod Existe pas");
                return 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProduitsService.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

  

   

}
