/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author user
 */
public class demande {
    
    //PROPRIETES
    
    private int id;
    
    private int traitement;
    
    private Date date_demande;
    
    private String papier1;
    
    private String papier2;
    
    private String papier3;
    
    private Date date_livraison;
    
    private String adresse_livraison;
   
    private int auto_id;
    
    private int user_id;
    
    //CONSTRUCTORS
    
    
    public demande() {
    }

    public demande(int id, int traitement, Date date_demande, String papier1, String papier2, String papier3, Date date_livraison, String adresse_livraison, int auto_id, int user_id) {
        this.id = id;
        this.traitement = traitement;
        this.date_demande = date_demande;
        this.papier1 = papier1;
        this.papier2 = papier2;
        this.papier3 = papier3;
        this.date_livraison = date_livraison;
        this.adresse_livraison = adresse_livraison;
        this.auto_id = auto_id;
        this.user_id = user_id;
    }

    public demande(int traitement, Date date_demande, String papier1, String papier2, String papier3, Date date_livraison, String adresse_livraison, int auto_id, int user_id) {
        this.traitement = traitement;
        this.date_demande = date_demande;
        this.papier1 = papier1;
        this.papier2 = papier2;
        this.papier3 = papier3;
        this.date_livraison = date_livraison;
        this.adresse_livraison = adresse_livraison;
        this.auto_id = auto_id;
        this.user_id = user_id;
    }
    
   
    
    //GETTERS AND SETTERS
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTraitement() {
        return traitement;
    }

    public void setTraitement(int traitement) {
        this.traitement = traitement;
    }

    public Date getDate_demande() {
        return date_demande;
    }

    public void setDate_demande(Date date_demande) {
        this.date_demande = date_demande;
    }

    public String getPapier1() {
        return papier1;
    }

    public void setPapier1(String papier1) {
        this.papier1 = papier1;
    }

    public String getPapier2() {
        return papier2;
    }

    public void setPapier2(String papier2) {
        this.papier2 = papier2;
    }

    public String getPapier3() {
        return papier3;
    }

    public void setPapier3(String papier3) {
        this.papier3 = papier3;
    }

    public Date getDate_livraison() {
        return date_livraison;
    }

    public void setDate_livraison(Date date_livraison) {
        this.date_livraison = date_livraison;
    }

    public int getAuto_id() {
        return auto_id;
    }

    public void setAuto_id(int auto_id) {
        this.auto_id = auto_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAdresse_livraison() {
        return adresse_livraison;
    }

    public void setAdresse_livraison(String adresse_livraison) {
        this.adresse_livraison = adresse_livraison;
    }
    
    
    
        //FUNCTIONS

    @Override
    public String toString() {
        return "demande{" + "id=" + id + ", traitement=" + traitement + ", date_demande=" + date_demande + ", papier1=" + papier1 + ", papier2=" + papier2 + ", papier3=" + papier3 + ", date_livraison=" + date_livraison + ", auto_id=" + auto_id + ", user_id=" + user_id + '}';
    }
    
    
}
