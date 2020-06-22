package huntkingdom;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class huntkingdomController implements Initializable{

    @FXML
    public AnchorPane main_pane;

    @FXML
    public Pane content_pane;
    

    private void load_fxml(String path){
        try {
            Parent child = FXMLLoader.load(getClass().getResource(path));
            content_pane.getChildren().clear();
            content_pane.getChildren().add(child);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void load_scene_1(ActionEvent event){
        load_fxml("/huntkingdom/Home_Content.fxml");
    }

    public void load_scene_5(ActionEvent event){
        //load_fxml("/MapPackage/BackMap.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Parent child = null;
        try {
            child = FXMLLoader.load(getClass().getResource("Home_Content.fxml"));
        } catch (IOException e) {
        }
        content_pane.getChildren().add(child);
    }
    
    public void load_autoscene(MouseEvent event){
        load_fxml("/AutorisationPackage/FrontAuto.fxml");
    }
    
        @FXML
    private void exit(MouseEvent Event){
    Stage stage = (Stage) content_pane.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
    
}
