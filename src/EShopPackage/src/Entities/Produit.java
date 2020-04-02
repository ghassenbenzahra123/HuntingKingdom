/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


import javafx.scene.image.ImageView;

/**
 *
 * @author Ghassen
 */
public class Produit {
    private int id;
    private float prix; 
    private String type,description,nom,img;
    private ImageView photo;

    
    
    public Produit() { }

    public Produit(int id, float prix, String type, String description, String nom, String img, ImageView photo) {
        this.id = id;
        this.prix = prix;
        this.type = type;
        this.description = description;
        this.nom = nom;
        this.img = img;
        this.photo = photo;
    }
    




    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ImageView getPhoto() {
        return photo;
    }

    public void setPhoto(ImageView photo) {
        this.photo = photo;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", prix=" + prix + ", type=" + type + ", description=" + description + ", nom=" + nom + ", img=" + img + '}';
    }

 

   
    
    
    
    

    
}
