/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Ghassen
 */
public class Commande {
    private int id ;
    private String date ; 
    private float total ;
    private int idC,idA; 

    public Commande(int id, String date, float total, int idC, int idA) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.idC = idC;
        this.idA = idA;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }
    

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", date=" + date + ", total=" + total + ", idC=" + idC + ", idA=" + idA + '}';
    }

    
    
    
    
}
