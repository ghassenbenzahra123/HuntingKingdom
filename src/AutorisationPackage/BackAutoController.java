/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutorisationPackage;

import entities.autorisation;
import entities.demande;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import services.AutorisationService;
import services.DemandeService;

/**
 * FXML Controller class
 *
 * @author user
 */
public class BackAutoController implements Initializable {

    @FXML
    private TableView<autorisation> auto_table;
    @FXML
    private TableColumn<autorisation, String> id;
    @FXML
    private TableColumn<autorisation, String> type;
    @FXML
    private TableColumn<autorisation, String> description;
    @FXML
    private TableColumn<autorisation, String> categorie;
    @FXML
    private TableColumn<autorisation, String> validite;
    @FXML
    private TableColumn<autorisation, String> prix;
    @FXML
    private Slider input_prix;
    @FXML
    private Slider input_validite;
    @FXML
    private ChoiceBox input_categorie;
    @FXML
    private TextField input_type;
    @FXML
    private TextArea input_description;
    @FXML
    private Label auto_id;
    @FXML
    private Button edit_auto;
    @FXML
    private Button add_auto;
    @FXML
    private Pane ChartPane;
    @FXML
    private PieChart auto_pie;
    @FXML
    private TextField search_type;
    @FXML
    private TextField search_categorie;
    AutorisationService AS = new AutorisationService();

    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refresh();
    }    

    @FXML
    private void add_auto(MouseEvent event) {
        autorisation A = new autorisation();
        A.setCategorie((String) input_categorie.getValue());
        A.setDescription((String) input_description.getText());
        A.setPrix((int)input_prix.getValue());
        A.setValidite((int) input_validite.getValue());
        A.setType((String) input_type.getText());
        AS.insertAutorisation(A);
        refresh();

    }

    @FXML
    private void show_graph(MouseEvent event) {
                auto_pie.getData().clear();
                ChartPane.setVisible(true);
                load_chart_data();
    }
    
    // PLUS
    
        
        @FXML
    private void refresh_tables(MouseEvent event) {
        refresh();
    }
       public ObservableList<autorisation> getAutorisationList()
    {
        ObservableList<autorisation> temp = FXCollections.observableArrayList();
        List<autorisation> la = AS.getAllAutorisations();
        la.forEach((e)->temp.add(e));
        return temp;
    }
       
        private void  refresh(){
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        validite.setCellValueFactory(new PropertyValueFactory<>("validite"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        auto_table.setItems(getAutorisationList());
        input_categorie.getItems().clear();
        input_categorie.getItems().addAll("Peche","Chasse");
        input_prix.setValue(0);
        input_validite.setValue(0);
        input_description.setText("");
        input_type.setText("");
        add_auto.setVisible(true);
        edit_auto.setVisible(false);
        ChartPane.setVisible(false);
}
        
         @FXML
         public void delete_auto(ActionEvent Event){
            AutorisationService AS = new AutorisationService();
            AS.deleteAutorisation(auto_table.getSelectionModel().getSelectedItem());
            refresh();
        }
  
  
  @FXML
  public void show_modifier(ActionEvent Event){
        autorisation a = new autorisation();
        a =(auto_table.getSelectionModel().getSelectedItem());
        auto_id.setText(Integer.toString(a.getId()));
        input_categorie.setValue(a.getCategorie());
        input_type.setText(a.getType());
        input_description.setText(a.getDescription());
        input_prix.setValue(a.getPrix());
        input_validite.setValue(a.getValidite());
        add_auto.setVisible(false);
        edit_auto.setVisible(true);
                  
  }
  
  @FXML
  public void modifier_auto(MouseEvent Event){
              autorisation A = new autorisation();
              A.setId(Integer.parseInt(auto_id.getText()));
        A.setCategorie((String) input_categorie.getValue());
        A.setDescription((String) input_description.getText());
        A.setPrix((int)input_prix.getValue());
        A.setValidite((int) input_validite.getValue());
        A.setType((String) input_type.getText());
        AS.updateAutorisation(A);
        refresh();
      
  }
  
  @FXML
  private void SearchByType(KeyEvent Event){
      auto_table.getItems().clear();
      ObservableList<autorisation> temp = FXCollections.observableArrayList();
        List<autorisation> LA = AS.getAutorisationByType(search_type.getText());
        LA.forEach((e)->{
            temp.add(e);
        });
      auto_table.setItems(temp);
      
  }
  
  @FXML
  private void SearchByCat(KeyEvent Event){
      auto_table.getItems().clear();
      ObservableList<autorisation> temp = FXCollections.observableArrayList();
      autorisation A=new autorisation();
      A.setCategorie(search_categorie.getText());
        List<autorisation> LA = AS.getAllAutorisationsByCat(A);
        LA.forEach((e)->{
            temp.add(e);
        });
      auto_table.setItems(temp);
      
  }
  
  @FXML
  private void SearchById(KeyEvent Event){
      auto_table.getItems().clear();
      ObservableList<autorisation> temp = FXCollections.observableArrayList();
      autorisation A=new autorisation();
      A.setId(Integer.parseInt(search_type.getText()));
        List<autorisation> LA = AS.getAutorisationById(A);
        LA.forEach((e)->{
            temp.add(e);
        });
      auto_table.setItems(temp);
      
  }
  
  public void load_chart_data(){

        auto_pie.getData().clear();
        List<autorisation> la = AS.getAllAutorisations();
        double x=0;
        double y=0;
        for (autorisation auto : la){
            if (auto.getCategorie().equals("Peche"))
                x=x+1;
            if (auto.getCategorie().equals("Chasse"))
                y=y+1;
        }
      auto_pie.getData().add(new PieChart.Data("Peche",(x/(x+y))*100));
      auto_pie.getData().add(new PieChart.Data("Chasse",(y/(x+y))*100));
      
  }
     
}
