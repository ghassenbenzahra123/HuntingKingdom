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

public class EmpEditController {

    @FXML
    private TextField codefield;

    @FXML
    private TextField saisonfield;

    @FXML
    private Button empedit;

    @FXML
    private Button cancel;

    @FXML
    public void cancel(MouseEvent event)
    {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
    
    public void transferData(Emplacement e)
    {
        codefield.setText(e.getCode());
    }
    
    @FXML
    public void editEmp(MouseEvent event)
    {
        Emplacement e = new Emplacement(codefield.getText(),saisonfield.getText());
        emplacementService es = new emplacementService();
        es.updateEmplacement(e);
        Stage stage = (Stage) empedit.getScene().getWindow();
        stage.close();
    }

}
