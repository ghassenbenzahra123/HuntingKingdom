/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutorisationPackage;

import entities.autorisation;
import entities.demande;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javax.mail.MessagingException;
import services.AutorisationService;
import services.DemandeService;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FrontAutoController implements Initializable {

    @FXML
    private ListView<String> autolist;
    @FXML
    private MenuItem demandebyauto;
    @FXML
    private MenuItem getauto;
    @FXML
    private TableView<demande> demtable;
    @FXML
    private TableColumn<demande, String> dem_type;
    @FXML
    private TableColumn<demande, String> dem_validite;
    @FXML
    private TableColumn<demande, Date> dem_date;
    @FXML
    private TableColumn<demande, String> dem_adresse;
    @FXML
    private Button newdemande;
    @FXML
    private ChoiceBox input_type;
    @FXML 
    private TextField input_adresse;
    @FXML 
    private Button adddem;
    @FXML 
    private Pane newdempane;
    @FXML 
    private Pane modifierpane;
    @FXML 
    private Pane autorisationpane;
    @FXML
    private TextField adresse_dem;
    @FXML 
    private Button modif_dem;
    @FXML 
    private Label id_dem;
    @FXML 
    private Label auto_type;
    @FXML 
    private Label auto_categorie;
    @FXML 
    private Label auto_validite;
    @FXML 
    private Label auto_prix;
    @FXML 
    private Label auto_description;
   
    
    DemandeService DS = new DemandeService();
   
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
    private void getauto(ActionEvent event) {
                String selectedItem = autolist.getSelectionModel().getSelectedItem();
                System.out.println(selectedItem);
                autorisation a = new autorisation();
                a=AS.getAutorisationByType(selectedItem).get(0);
                auto_type.setText(a.getType());
                auto_categorie.setText(a.getCategorie());
                auto_validite.setText(Integer.toString(a.getValidite()));
                auto_prix.setText(Integer.toString(a.getPrix()));
                auto_description.setText(a.getDescription());
                autorisationpane.setVisible(true);    
    }



    @FXML
    private void newdemande(MouseEvent event) {
        newdempane.setVisible(true);
        input_type.getItems().clear();
        input_type.getItems().addAll(getAutorisationsType());
    }
       @FXML
    private void newdemandes(ActionEvent event) {
        newdempane.setVisible(true);
        input_type.getItems().clear();
        input_type.getItems().add(getAutorisationType());
    }
     // new demande window   
    
    
    
    
    // FUNCTIONS `
  @FXML
        private void refresh_tables(MouseEvent Event) {
        refresh();
    }
    
    @FXML
        private void refresh() {
        dem_type.setCellValueFactory(new PropertyValueFactory<>("auto_id"));
        dem_validite.setCellValueFactory(new PropertyValueFactory<>("traitement"));
        dem_date.setCellValueFactory(new PropertyValueFactory<>("date_livraison"));
        dem_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse_livraison"));
        demtable.setItems(getDemandeList());
        autolist.setItems(getAutorisationList());
        newdempane.setVisible(false);
        modifierpane.setVisible(false);
        autorisationpane.setVisible(false);
    }
    
    
    public ObservableList<String> getAutorisationList()
    {
        ObservableList<String> temp = FXCollections.observableArrayList();
        List<autorisation> la = AS.getAllAutorisations();
        la.forEach((e)->temp.add(e.getType()));
        return temp;
    }
     public List<String> getAutorisationsType()
    {
        List<String> temp = new ArrayList();
        List<autorisation> la = AS.getAllAutorisations();
        la.forEach((e)->temp.add(e.getType()));
        return temp;
    }
     
         public String getAutorisationType()
    {
        String selectedItem = autolist.getSelectionModel().getSelectedItem();
        return selectedItem;
    }
         
  public ObservableList<demande> getDemandeList()
    {
        //DS.show();
        ObservableList<demande> temp = FXCollections.observableArrayList();
        List<demande> LD = DS.getAllDemandes();
        LD.forEach((e)->{
            temp.add(e);
        });
        return temp;
    }
  
  public void add_demande(MouseEvent Event)
  {
               String mail = "amine.khemiiri@gmail.com";//REPLACE WITH SESSION USER EMAIL 
               String message = "Bonjour l'équipe HuntingKingdom vous informe que votre demande d'autorisation a été envoyé à notre à notre administratio.\nVous recevrez un mail contenant la date de livraison dès que votre demande sera validé . ";
           ///SEND MAIL HERE 
               
        demande D = new demande();
        D.setAdresse_livraison((String) input_adresse.getText());
        D.setAuto_id(AS.getAutorisationByType((String) input_type.getValue()).get(0).getId());
        long millis=System.currentTimeMillis();
        Date date=new Date(millis);
        D.setDate_demande(date);
        D.setUser_id(1);// REPLACE WITH SSESION USER ID
        Date date1=new Date(date.getTime()+14*24*60*60*1000);
        D.setDate_livraison(date1);
        D.setPapier1("-");
        D.setPapier2("-");
        D.setPapier3("-");
        D.setTraitement(0);
        DS.insertDemande(D);
         refresh();
  }
  
    public void delete_demande(ActionEvent Event)
  {
      DS.deleteDemande(demtable.getSelectionModel().getSelectedItem());
      refresh();
  }
    
        public void modifier_demande(MouseEvent Event)
  {
      demande d = new demande();
      d.setId(Integer.parseInt(id_dem.getText()));
      d.setAdresse_livraison(adresse_dem.getText());
      DS.updateDemande(d);
      refresh();
  }
        
                public void show_modifier(ActionEvent Event)
  {
      modifierpane.setVisible(true);
      demande selectedItem = demtable.getSelectionModel().getSelectedItem();
      id_dem.setText(Integer.toString(selectedItem.getId()));
      
  }

}
