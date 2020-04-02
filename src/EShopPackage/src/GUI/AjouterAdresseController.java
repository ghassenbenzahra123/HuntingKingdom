/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Ghassen
 */
public class AjouterAdresseController implements Initializable {

    @FXML
    private AnchorPane apContent;
    @FXML
    private TextField tfSupplyerName;
    @FXML
    private TextArea taSupplyerAddress;
    @FXML
    private TextArea taSupplyerDescription;
    @FXML
    private Button btnSave;
    @FXML
    private TextArea taContactNumbers;
    @FXML
    private Button btnUpdate;
    @FXML
    private Label lblCaption;
    @FXML
    private Button btnClose;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


}
