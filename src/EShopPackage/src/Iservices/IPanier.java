/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Entities.Panier;
import Entities.Produit;
import javafx.collections.ObservableList;

/**
 *
 * @author Ghassen
 */
public interface IPanier {

    public void AjouterAuPanier(Produit a);

    public void SupprimerDuPanier(int id);

    public void SupprimerById(int id);

    public int LonguerPanier();

    public ObservableList<Panier> getPanierByUser();

    public int ajouterQuantite(int id);

    public int modifierQuantite(int id, String quantite);

}
