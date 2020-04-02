/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Commande;
import Iservices.ICommande;
import Utilities.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.ObservableList;

/**
 *
 * @author Ghassen
 */
public class CommandeService implements ICommande{
    Connection connection = null;

    public CommandeService() {
        connection = DataSource.getInstance().getConnection();
    }
    Statement st;
    PreparedStatement pt;
    ResultSet rs;

    @Override
    public void AjouterCommande(Commande c) {
       }

    @Override
    public ObservableList<Commande> getall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void AnnulerCommande(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
    
    
}
