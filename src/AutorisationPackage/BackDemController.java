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
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import services.AutorisationService;
import services.DemandeService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 * FXML Controller class
 *
 * @author user
 */
public class BackDemController implements Initializable {

    @FXML
    private TableView<demande> demande_table;
    @FXML
    private TableColumn<demande, String> id;
    @FXML
    private TableColumn<demande, String> type;
    @FXML
    private TableColumn<demande, String> user;
    @FXML
    private TableColumn<demande, String> traitement;
    @FXML
    private TableColumn<demande, Date> date_demande;
    @FXML
    private TableColumn<demande, String> adresse_demande;
    @FXML
    private TableColumn<demande, Date> date_livraison;
    @FXML
    private TableColumn<demande, String> papier;
    @FXML
    private Button graphbtn;
    @FXML
    private ImageView graphbtn_dem;
    @FXML
    private Button calendarbtn;
    @FXML
    private ContextMenu CM;
    @FXML
    private MenuItem MI1;
    @FXML
    private MenuItem MI2;
    @FXML
    private Pane ChartPane;
    @FXML
    private BarChart<?,?> dem_chart;
    @FXML
    private CategoryAxis stat;
    @FXML
    private NumberAxis pour;
    @FXML
    private TextField search_id;
    @FXML
    private TextField search_user;
    @FXML
    private Pane show_calendar;
    
    
    DemandeService DS = new DemandeService();


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
    private void load_graph(MouseEvent Event) {
                dem_chart.getData().clear();
                ChartPane.setVisible(true);
                load_chart_data();
    }

    @FXML
    private void load_calendar(MouseEvent Event) {
        FullCalendarView Calendar = new FullCalendarView(YearMonth.now());
        List<AnchorPaneNode> Days = new ArrayList<>();
        //ADD DAYS HERE
        LocalDate D;
        List<demande> LD = DS.getAllDemandes();
        AnchorPaneNode A =new AnchorPaneNode();
        for (demande dem : LD)
        {
            D=this.ToLocalDate(dem.getDate_livraison());
            A.setDateL(D);
            D=this.ToLocalDate(dem.getDate_demande());
            A.setDate(D);
            Days.add(A);
        }
        Calendar.setAllCalendarDays((ArrayList<AnchorPaneNode>) Days);
        show_calendar.getChildren().add(Calendar.getView());
        show_calendar.setVisible(true);
        
    }
    
public LocalDate ToLocalDate(Date dateToConvert) {
    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
}
    
    
    //PLUS
    
        
        private void refresh() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        type.setCellValueFactory(new PropertyValueFactory<>("auto_id"));
        user.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        traitement.setCellValueFactory(new PropertyValueFactory<>("traitement"));
        date_demande.setCellValueFactory(new PropertyValueFactory<>("date_demande"));
        adresse_demande.setCellValueFactory(new PropertyValueFactory<>("adresse_livraison"));
        date_livraison.setCellValueFactory(new PropertyValueFactory<>("date_livraison"));
        papier.setCellValueFactory(new PropertyValueFactory<>("papier1"));
        demande_table.setItems(getDemandeList());
        ChartPane.setVisible(false);
        show_calendar.setVisible(false);
        show_calendar.getChildren().clear();
        search_id.setText("");
        search_user.setText("");
    }

    
  public ObservableList<demande> getDemandeList()
    {
        ObservableList<demande> temp = FXCollections.observableArrayList();
        List<demande> LD = DS.getAllDemandes();
        LD.forEach((e)->{
            temp.add(e);
        });
        return temp;
    }
  
  
  @FXML
  private void delete_dem(ActionEvent Event){
      DS.deleteDemande(demande_table.getSelectionModel().getSelectedItem());
      refresh();
  }
  
  @FXML
  private void valider_dem(ActionEvent Event){
      DS.validerDemande(demande_table.getSelectionModel().getSelectedItem());
               String mail = "amine.khemiiri@gmail.com";//REPLACE WITH SESSION USER EMAIL 
               String message = "Bonjour l'équipe HuntingKingdom vous informe que votre demande d'autorisation a été validé.\nVous pouvez vérifier toutes les informations sur note site.\nLa date de livraison de votre demande : "+demande_table.getSelectionModel().getSelectedItem().getDate_livraison().toString();
       ///SEND MAIL HERE 
      refresh();
  }
  
  @FXML
  public void refresh_table(MouseEvent Event){
  refresh();}
  
  @FXML
  private void SearchById(KeyEvent Event){
      demande_table.getItems().clear();
      demande D=new demande();
      D.setId(Integer.parseInt(search_id.getText()));
      ObservableList<demande> temp = FXCollections.observableArrayList();
        List<demande> LD = DS.getDemandeById(D);
        LD.forEach((e)->{
            temp.add(e);
        });
      demande_table.setItems(temp);  
  }
  
  @FXML
  private void SearchByUserID(KeyEvent Event){
      demande_table.getItems().clear();
      demande D=new demande();
      D.setUser_id(Integer.parseInt(search_user.getText()));
      ObservableList<demande> temp = FXCollections.observableArrayList();
        List<demande> LD = DS.getDemandesByUser(D);
        LD.forEach((e)->{
            temp.add(e);
        });
      demande_table.setItems(temp); 
      
  }
  
  

    private void load_chart_data() {
        AutorisationService AS= new AutorisationService();
        List<autorisation> LA= new ArrayList();
        autorisation A=new autorisation();
        LA.clear();
        dem_chart.getData().clear();
        List<demande> LD = DS.getAllDemandes();
        double x=0;
        double y=0;
        double p=0;
        double c=0;
        for (demande dem : LD){
            if (dem.getTraitement()==1)
                x=x+1;
            if (dem.getTraitement()==0)
                y=y+1;
            A.setId(dem.getAuto_id());
            LA=AS.getAutorisationById(A);
            if (LA.get(0).getCategorie().equals("Peche"))
               p=p+1;
            if (LA.get(0).getCategorie().equals("Chasse"))
               c=c+1;
        }  
        XYChart.Series set1 = new XYChart.Series<>();
        XYChart.Series set2 = new XYChart.Series<>();
        XYChart.Series set3 = new XYChart.Series<>();
        XYChart.Series set4 = new XYChart.Series<>();
        set1.setName("Chasse");
        set2.setName("Pêche");
        set3.setName("Validé");
        set4.setName("Non Validé");
        set1.getData().add(new XYChart.Data("Demandes de Chasse",(c/(c+p))*100));
        set2.getData().add(new XYChart.Data("Demandes de Peche",(p/(c+p))*100));
        set3.getData().add(new XYChart.Data("Demandes Validés",(x/(x+y))*100));
        set4.getData().add(new XYChart.Data("Demandes Non Validés",(y/(x+y))*100));
        dem_chart.getData().addAll(set1, set2, set3, set4);
    }
    
}
