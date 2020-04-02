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
import Entities.Animal;
import Entities.Emplacement;
import Services.animalService;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AnimalAddController {

    @FXML
    private ChoiceBox<String> regionfield;

    @FXML
    private TextField etatfield;

    @FXML
    private Button animaladd;

    @FXML
    private Button cancel;

    @FXML
    private TextField qteEstimfield;

    @FXML
    private TextField saisonfield;

    @FXML
    private TextField typefield;

    @FXML
    private TextField desctype;

    @FXML
    void addAnimal(MouseEvent event) {
        Animal a = new Animal(0,regionfield.getSelectionModel().getSelectedItem(),etatfield.getText(),Integer.parseInt(qteEstimfield.getText()), saisonfield.getText(),typefield.getText(), desctype.getText());
        animalService as = new animalService();
        as.insertAnimal(a);
        Stage stage = (Stage) animaladd.getScene().getWindow();
        stage.close();
    }

    @FXML
    void cancel(MouseEvent event) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
    
    public void transferEmpList(List<Emplacement> le)
    {
        List<String> ls = new ArrayList<String>();
        le.forEach((e)->{
        ls.add(e.getCode());
        });
        ObservableList<String> os = FXCollections.observableList(ls);
        regionfield.setItems(os);
        regionfield.getSelectionModel().selectFirst();
    }

}

