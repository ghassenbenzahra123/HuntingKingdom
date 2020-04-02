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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EmpDeleteController {

    @FXML
    private Button empdelete;

    @FXML
    private Button cancel;
    
    private Emplacement e;

    @FXML
    void deleteEmp(MouseEvent event) {
        emplacementService es = new emplacementService();
        es.deleteEmplacement(e.getCode());
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void cancel(MouseEvent event) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
    
    public void transferData(Emplacement e)
    {
        this.e = e;
    }

}
