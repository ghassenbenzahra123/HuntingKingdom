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
import Services.animalService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AnimalDeleteController {

    @FXML
    private Button animaldelete;

    @FXML
    private Button cancel;
    
    private String id;

    @FXML
    void cancel(MouseEvent event) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void deleteAnimal(MouseEvent event) {   
        animalService as = new animalService();
        as.deleteAnimal(id);
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
    
    public void transferData(String id)
    {
        this.id = id;
    }

}
