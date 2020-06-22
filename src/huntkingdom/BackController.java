/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author user
 */
public class BackController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private ImageView auto_scenebtn;
    @FXML
    private ImageView livraison_scenebtn;
    @FXML
    private ImageView cmd_scenebtn;
    @FXML
    private ImageView map_scenebtn;
    @FXML
    private ImageView user_scenebtn;
    @FXML
    private ImageView produit_scenebtn;
    @FXML
    public Pane content_pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Parent child = null;
        try {
            child = FXMLLoader.load(getClass().getResource("Back_Content.fxml"));
        } catch (IOException e) {
        }
        content_pane.getChildren().add(child);
    } 
    
    @FXML
    private void exit(MouseEvent Event){
    Stage stage = (Stage) label.getScene().getWindow();
    // do what you have to do
    stage.close();
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
    }

    @FXML
    private void load_autoscene(MouseEvent event) {
           load_fxml("/AutorisationPackage/BackAuto.fxml");
    }

    @FXML
    private void load_livraisonscene(MouseEvent event) {
    }

    @FXML
    private void load_cmdscene(MouseEvent event) {
           load_fxml("/AutorisationPackage/BackDem.fxml");
    }

    @FXML
    private void load_mapscene(MouseEvent event) {
    }

    @FXML
    private void load_userscene(MouseEvent event) {
    }

    @FXML
    private void load_produitscene(MouseEvent event) {
    }
    
        private void load_fxml(String path){
        try {
            Parent child = FXMLLoader.load(getClass().getResource(path));
            content_pane.getChildren().clear();
            content_pane.getChildren().add(child);
        } catch (IOException e) {
              e.printStackTrace();
        }
    }
}

 
