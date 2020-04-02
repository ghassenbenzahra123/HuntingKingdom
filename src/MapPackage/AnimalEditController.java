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
import Entities.Animal;
import Services.animalService;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AnimalEditController {

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
    private ChoiceBox<String> regionfield;
    
    private int id;

    @FXML
    void cancel(MouseEvent event) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void editAnimal(MouseEvent event) {
        Animal a = new Animal(id,regionfield.getSelectionModel().getSelectedItem(),etatfield.getText(),Integer.parseInt(qteEstimfield.getText()), saisonfield.getText(),typefield.getText(), desctype.getText());
        animalService as = new animalService();
        as.updateAnimal(a);
        Stage stage = (Stage) animaladd.getScene().getWindow();
        stage.close();
    }
    
    public void transferData(Animal a, List<Emplacement> le)
    {
        this.id = a.getId();
        etatfield.setText(a.getEtat());
        qteEstimfield.setText(Integer.toString(a.getQteEstim()));
        saisonfield.setText(a.getSaison());
        typefield.setText(a.getType());
        desctype.setText(a.getDesc());
        List<String> ls = new ArrayList<String>();
        le.forEach((e)->{
        ls.add(e.getCode());
        });
        ObservableList<String> os = FXCollections.observableList(ls);
        regionfield.setItems(os);
        regionfield.getSelectionModel().select(a.getRegion());
    }

}
