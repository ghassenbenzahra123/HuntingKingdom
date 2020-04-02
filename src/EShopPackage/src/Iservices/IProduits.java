/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Entities.Produit;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ghassen
 */
public interface IProduits {

    public Produit RecupererProduit(int id);

    public int existProduit(int id);

    public List<Produit> selectAll() throws SQLException;

}
