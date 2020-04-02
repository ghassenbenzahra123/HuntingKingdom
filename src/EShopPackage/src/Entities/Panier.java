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
public class Panier {

    private int id;
    private int idProd;
    private String nomProd;
    private float prix;
    private ImageView photo;
    private String Img;
    private int idU;
    private int quantite;

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public Panier() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Panier(int id, int idProd, String nomProd, float prix, ImageView photo, String Img, int idU, int quantite) {
        this.id = id;
        this.idProd = idProd;
        this.nomProd = nomProd;
        this.prix = prix;
        this.photo = photo;
        this.Img = Img;
        this.idU = idU;
        this.quantite = quantite;

    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public ImageView getPhoto() {
        return photo;
    }

    public void setPhoto(ImageView photo) {
        this.photo = photo;
    }

    public String getImg() {
        return Img;
    }

    public int getQuantite() {

        return quantite;

    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setImg(String Img) {
        this.Img = Img;
    }

    @Override
    public String toString() {
        return "Panier{" + "id=" + id + ", idProd=" + idProd + ", nomProd=" + nomProd + ", prix=" + prix + ", photo=" + photo + ", Img=" + Img + ", idU=" + idU + ", quantite=" + quantite + '}';
    }

  

}
