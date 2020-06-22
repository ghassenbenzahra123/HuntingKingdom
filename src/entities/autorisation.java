/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author user
 */
public class autorisation {


    
    private int id;

    private String type;
    
    private int validite;
    
    private String description;
    
    private int prix;
    
    private String categorie;
    
    
    //CONSTRUCTOR

    public autorisation() {
    }

    public autorisation(int id, String type, int validite, String description, int prix, String categorie) {
        this.id = id;
        this.type = type;
        this.validite = validite;
        this.description = description;
        this.prix = prix;
        this.categorie = categorie;
    }

    public autorisation(String type, int validite, String description, int prix, String categorie) {
        this.type = type;
        this.validite = validite;
        this.description = description;
        this.prix = prix;
        this.categorie = categorie;
    }
    
    
    //GETTERS AND SETTERS
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValidite() {
        return validite;
    }

    public void setValidite(int validite) {
        this.validite = validite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    
    //FONCTIONS
    
        @Override
    public String toString() {
        return "autorisation{" + "id=" + id + ", type=" + type + ", validite=" + validite + ", description=" + description + ", prix=" + prix + ", categorie=" + categorie + '}';
    }
    
    

    
    
}
