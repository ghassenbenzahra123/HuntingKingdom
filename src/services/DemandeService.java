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
public class DemandeService {
    
    private Connection connexion;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public DemandeService() {
                connexion=DataSource.getInstance().getCnx();
    }
    
    public void insertDemande(demande D){
        String req="insert into demande (traitement,date_demande,papier1,papier2,papier3,date_livraison,adresse_livraison,auto_id,user_id) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            pst=connexion.prepareStatement(req);
            pst.setInt(1, D.getTraitement());
            pst.setDate(2, D.getDate_demande());
            pst.setString(3, D.getPapier1());
            pst.setString(4, D.getPapier2());
            pst.setString(5, D.getPapier3());
            pst.setDate(6, D.getDate_livraison());
            pst.setString(7, D.getAdresse_livraison());
            pst.setInt(8, D.getAuto_id());
            pst.setInt(9, D.getUser_id());
            pst.executeUpdate();
            //MAILING MANQUANT
        } catch (SQLException ex) {
            Logger.getLogger(DemandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
        public List<demande> getDemandeById(demande D){
        String req="select * from demande where id = '"+D.getId()+"'";
        List<demande> LD=new ArrayList<>();
        try {
            ste=connexion.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next())
            {
             LD.add(new demande(rs.getInt("id"),rs.getInt("traitement"),rs.getDate("date_demande"),rs.getString("papier1"),rs.getString("papier2"),rs.getString("papier3"),rs.getDate("date_livraison"),rs.getString("adresse_livraison"),rs.getInt("auto_id"),rs.getInt("user_id")));  
            }
        } catch (SQLException ex) {
            Logger.getLogger(DemandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return  LD;
    }
        
            public List<demande> getDemandesByUser(demande D){
        String req="select * from demande where user_id = '"+D.getUser_id()+"'";
        List<demande> LD=new ArrayList<>();
        try {
            ste=connexion.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next())
            {
             LD.add(new demande(rs.getInt("id"),rs.getInt("traitement"),rs.getDate("date_demande"),rs.getString("papier1"),rs.getString("papier2"),rs.getString("papier3"),rs.getDate("date_livraison"),rs.getString("adresse_livraison"),rs.getInt("auto_id"),rs.getInt("user_id")));  
            }
        } catch (SQLException ex) {
            Logger.getLogger(DemandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return  LD;
    }    
    
    public List<demande> getAllDemandes(){
        String req="select * from demande";
        List<demande> LD=new ArrayList<>();
        try {
            ste=connexion.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next())
            {
             LD.add(new demande(rs.getInt("id"),rs.getInt("traitement"),rs.getDate("date_demande"),rs.getString("papier1"),rs.getString("papier2"),rs.getString("papier3"),rs.getDate("date_livraison"),rs.getString("adresse_livraison"),rs.getInt("auto_id"),rs.getInt("user_id")));  
            }
        } catch (SQLException ex) {
            Logger.getLogger(DemandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return  LD;
    }
    
        public void deleteDemande(demande D){
        String req="delete from demande where id = '"+D.getId()+"'";
        try {
            pst=connexion.prepareStatement(req);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DemandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
          public void updateDemande(demande D){
        String req="update demande set adresse_livraison = ? where id = ?";
        try {
            pst=connexion.prepareStatement(req);
            pst.setString(1, D.getAdresse_livraison());
            pst.setInt(2, D.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DemandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
              public void validerDemande(demande D){
        String req="update demande set traitement = ? where id = ?";
        try {
            pst=connexion.prepareStatement(req);
            pst.setInt(1, 1);
            pst.setInt(2, D.getId());
            pst.executeUpdate();
            //MAILING MANQUANT
        } catch (SQLException ex) {
            Logger.getLogger(DemandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
