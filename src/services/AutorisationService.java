/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.autorisation;
import entities.demande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import huntkingdom.DataSource;


/**
 *
 * @author user
 */
public class AutorisationService {
    
    private final Connection connexion;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public AutorisationService() {
                connexion=DataSource.getInstance().getCnx();
    }
    
    public void insertAutorisation(autorisation A){
        String req="insert into autorisation (type,validite,description,prix,categorie) VALUES (?,?,?,?,?)";
        try {
            pst=connexion.prepareStatement(req);
            pst.setString(1, A.getType());
            pst.setInt(2, A.getValidite());
            pst.setString(3, A.getDescription());
            pst.setFloat(4,(float) A.getPrix());
            pst.setString(5, A.getCategorie());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AutorisationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
        public List<autorisation> getAutorisationById(autorisation A){
        String req="select * from autorisation where id = '"+A.getId()+"'";
        List<autorisation> LA=new ArrayList<>();
        try {
            ste=connexion.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next())
            {
             LA.add(new autorisation(rs.getInt("id"),rs.getString("type"),rs.getInt("validite"),rs.getString("description"), (int) rs.getFloat("prix"),rs.getString("categorie")));  
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutorisationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return  LA;
    }
    
    public List<autorisation> getAllAutorisations(){
        String req="select * from autorisation";
        List<autorisation> LA=new ArrayList<>();
        try {
            ste=connexion.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next())
            {
             LA.add(new autorisation(rs.getInt("id"),rs.getString("type"),rs.getInt("validite"),rs.getString("description"), (int) rs.getFloat("prix"),rs.getString("categorie")));  
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutorisationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return  LA;
    }
    
        public List<autorisation> getAllAutorisationsByCat(autorisation A){
        String req="select * from autorisation where categorie = '"+A.getCategorie()+"'";
        List<autorisation> LA=new ArrayList<>();
        try {
            ste=connexion.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next())
            {
             LA.add(new autorisation(rs.getInt("id"),rs.getString("type"),rs.getInt("validite"),rs.getString("description"),rs.getInt("prix"),rs.getString("categorie")));  
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutorisationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return  LA;
    }
    
        public void deleteAutorisation(autorisation A){
            System.out.println(A.getId());
        String req="delete from autorisation where id = '"+A.getId()+"'";
        try {
            pst=connexion.prepareStatement(req);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AutorisationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
          public void updateAutorisation(autorisation A){
        String req="update autorisation set type = ?, validite = ?, description = ?, prix = ?, categorie = ? where id = ? ";
        try {
            pst=connexion.prepareStatement(req);
            pst.setString(1, A.getType());
            pst.setInt(2, A.getValidite());
            pst.setString(3, A.getDescription());
            pst.setDouble(4, A.getPrix());
            pst.setString(5, A.getCategorie());
            pst.setInt(6, A.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AutorisationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public List<autorisation> getAutorisationByType(String S) {
                String req="select * from autorisation where type = '"+S+"'";
        List<autorisation> LA=new ArrayList<>();
        try {
            ste=connexion.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next())
            {
             LA.add(new autorisation(rs.getInt("id"),rs.getString("type"),rs.getInt("validite"),rs.getString("description"),rs.getInt("prix"),rs.getString("categorie")));  
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutorisationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return  LA;  
    }
    
    
}
