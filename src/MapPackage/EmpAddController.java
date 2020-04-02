/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapPackage;

/**
 *
 * @author Fares
 */
import Entities.Emplacement;
import Services.emplacementService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EmpAddController {

    @FXML
    private Button empadd;

    @FXML
    private Button cancel;
    
    @FXML
    private TextField codefield;

    @FXML
    private TextField saisonfield;
    
    public void addEmp(MouseEvent event)
    {
        Emplacement e = new Emplacement(codefield.getText(), saisonfield.getText());
        emplacementService es = new emplacementService();
        es.insertEmplacement(e);
        Stage stage = (Stage) empadd.getScene().getWindow();
        stage.close();
    }
    
    public void cancel(MouseEvent event)
    {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

}
