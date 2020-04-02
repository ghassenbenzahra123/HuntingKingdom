/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Produit;
import Services.PanierService;
import Services.ProduitsService;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Iservices.IProduits;
import Iservices.IPanier;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TablePosition;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Ghassen
 */
public class ProduitsController implements Initializable {

    @FXML
    private TableView<Produit> listeProduit;
    @FXML
    private TableColumn<Produit, String> photo;
    @FXML
    private TableColumn<Produit, String> nom;
    @FXML
    private TableColumn<Produit, String> type;
    @FXML
    private TableColumn<Produit, String> description;
    @FXML
    private TableColumn<Produit, Integer> prix;

    @FXML
    private Button ajouter;
    private IProduits p;
    private IPanier panier;

    static int i;
    @FXML
    private ScrollPane scroll;
    @FXML
    private AnchorPane anchor;
    @FXML
    private TableColumn<Produit, Integer> id;
    @FXML
    private Label produits;

    ProduitsService produitService = new ProduitsService();
    ArrayList arrayList = (ArrayList) produitService.selectAll();
    @FXML
    private Button btn_panier;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setVisible(false);

        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        listeProduit.setItems(observableList);

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        photo.setCellValueFactory(new PropertyValueFactory<>("photo"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));

    }

    @FXML
    private void ajouterAupanier(ActionEvent event) {

        TablePosition pos = (TablePosition) listeProduit.getSelectionModel().getSelectedCells().get(0);
        int index = pos.getRow();
        String selected = listeProduit.getItems().get(index).toString();
        selected = selected.substring(11, selected.indexOf(","));

        int ida = Integer.parseInt(selected);

        panier = new PanierService();
        p = new ProduitsService();

        if (p.existProduit(ida) == 0) {

            Produit a = p.RecupererProduit(ida);
            panier.AjouterAuPanier(a);

            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("CheckedPanier.fxml"));

                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UTILITY);

                stage.setScene(scene);
                // stage.setResizable(false);
                stage.show();

            } catch (IOException e) {
                Logger logger = Logger.getLogger(getClass().getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", e);
            }

        } else {

          //  panier = new PanierService();
panier.ajouterQuantite(ida);
            
            try {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("QuantiteAjoute.fxml"));

                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();

                stage.setTitle("Panier");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();

            } catch (IOException e) {
                Logger logger = Logger.getLogger(getClass().getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", e);
            }
        }
    }

    @FXML
    private void AffichagePanier(MouseEvent event) {
        try {

            Stage stage1 = (Stage) btn_panier.getScene().getWindow();
            stage1.close();

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Panier.fxml"));
            /* 
         * if "fx:controller" is not set in fxml
         * fxmlLoader.setController(NewWindowController);
             */

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.close();

            stage.setTitle("Affichage du Panier ");
            stage.setScene(scene);
            stage.setResizable(false);

            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

}
