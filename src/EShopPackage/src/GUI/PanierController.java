/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Iservices.IPanier;

import Entities.Panier;
import Services.PanierService;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.control.cell.ComboBoxTableCell;

/**
 * FXML Controller class
 *
 * @author Ghassen
 */
public class PanierController implements Initializable {

    @FXML
    private Button supprimer;

    @FXML
    private AnchorPane anchor;
    @FXML
    private TableView<Panier> tableview_panier;
    @FXML
    private TableColumn<Panier, String> photo;

    @FXML
    private Button vider;
    @FXML
    private Button ajouter_commande;
    @FXML
    private ImageView affichage_panier;
    @FXML
    private TableColumn<Panier, String> nomProd;
    @FXML
    private TableColumn<Panier, Float> prix;
    @FXML
    private TableColumn<Panier, String> quantite;
    private IPanier panierservice;
    @FXML
    private Label prix_total;
    private double total = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        PanierService panierService = new PanierService();
        tableview_panier.setItems(panierService.getPanierByUser());
        tableview_panier.setEditable(true);
        tableview_panier.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        photo.setCellValueFactory(new PropertyValueFactory<>("photo"));
        nomProd.setCellValueFactory(new PropertyValueFactory<>("nomProd"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));

        ObservableList<Panier> oldselectedRows = tableview_panier.getItems();
        ArrayList<Panier> s = new ArrayList<>(oldselectedRows);
        System.out.print(s);
        for (int i = 0; i < s.size(); i++) {
            total = total + (s.get(i).getPrix() * s.get(i).getQuantite());
        }

        prix_total.setText(Double.toString(total) + "DT");

        quantite.setMinWidth(80);

        quantite.setCellFactory(ComboBoxTableCell.<Panier, String>forTableColumn("1", "2", "3", "4", "5"));

        quantite.setOnEditCommit((TableColumn.CellEditEvent<Panier, String> e)
                -> {
            String newValue = e.getNewValue();
            int index = e.getTablePosition().getRow();

            Panier panier = (Panier) e.getTableView().getItems().get(index);
            int id = panier.getIdProd();
            if (true) {

                int j = Integer.parseInt(newValue);

                panierservice = new PanierService();
                panierservice.modifierQuantite(id, newValue);
                tableview_panier.setItems(panierService.getPanierByUser());

                System.out.println("Quantite Modifié  " + quantite);
                double nbr_total = 0;

                ObservableList<Panier> selectedRows = tableview_panier.getItems();
                ArrayList<Panier> rows = new ArrayList<>(selectedRows);
                for (int i = 0; i < rows.size(); i++) {
                    nbr_total = nbr_total + (rows.get(i).getPrix() * rows.get(i).getQuantite());
                }
                prix_total.setText(Double.toString(nbr_total) + "DT");

            }
        });
    }

    @FXML
    private void Supprimer_Produit(ActionEvent event) {
        panierservice = new PanierService();
        if (tableview_panier.getSelectionModel().getSelectedIndex() == -1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur !");
            alert.setHeaderText(null);
            alert.setContentText("Aucune ligne  sélectionnée ");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de Suppression");
            alert.setHeaderText("Voulez vous supprimer les produits suivantes de votre Panier ? ");
            alert.setContentText("Etes vous certain ? ");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {

                ObservableList<Panier> selectedRows = tableview_panier.getSelectionModel().getSelectedItems();
                ArrayList<Panier> rows = new ArrayList<>(selectedRows);
                rows.forEach((row) -> {
                    panierservice.SupprimerDuPanier(row.getIdProd());

                    tableview_panier.getItems().remove(row);
                });

            } else {

            }

        }
        panierservice = new PanierService();

        double total = 0;
        ObservableList<Panier> selectedRows = tableview_panier.getItems();
        ArrayList<Panier> rows = new ArrayList<>(selectedRows);
        System.out.println(rows);
        for (int i = 0; i < rows.size(); i++) {
            total = total + (rows.get(i).getPrix() * rows.get(i).getQuantite());
        }
        prix_total.setText(Double.toString(total) + "DT");
    }

    @FXML
    private void ViderPanier(ActionEvent event) {
        panierservice = new PanierService();

        double totale = 0;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Vider Panier");
        alert.setHeaderText("Voulez vous videz votre panier? ");
        alert.setContentText("Etes vous certain ? ");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            ObservableList<Panier> selectedRows = tableview_panier.getItems();
            ArrayList<Panier> rows = new ArrayList<>(selectedRows);
            System.out.println(rows);

            rows.forEach((row) -> {

                panierservice.SupprimerById(row.getId());
                tableview_panier.getItems().remove(row);
            });

            prix_total.setText(Double.toString(totale) + "DT");

        }
    }

    @FXML
    private void ajout_cmd(ActionEvent event) {
        
        
        
    }

}
