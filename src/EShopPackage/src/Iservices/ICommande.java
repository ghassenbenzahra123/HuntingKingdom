/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Entities.Commande;
import javafx.collections.ObservableList;

/**
 *
 * @author Ghassen
 */
public interface ICommande {
      
    public void AjouterCommande(Commande c);
    public ObservableList<Commande> getall();
    public void AnnulerCommande(int id);
 
     
}
