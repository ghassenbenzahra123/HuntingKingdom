/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 *
 * @author user
 */
public class HuntKingdom extends Application{

    //.getResource("Home.fxml")
    @Override
    public void start(Stage stage) throws Exception {
        //Pane mainpane = (Pane) FXMLLoader.load(HuntKingdom.class.getResource("Home.fxml"));
        Pane mainpane = (Pane) FXMLLoader.load(HuntKingdom.class.getResource("Back.fxml"));
        Scene scene = new Scene(mainpane);
        String css = this.getClass().getResource("Style.css").toExternalForm(); 
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    
    public static void main(String[] args){
        launch(args);
        
    }
    
}
