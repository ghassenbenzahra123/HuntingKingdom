import Entities.Animal;
import Entities.Emplacement;
import MapPackage.AnimalAddController;
import MapPackage.AnimalDeleteController;
import MapPackage.AnimalEditController;
import MapPackage.EmpAddController;
import MapPackage.EmpDeleteController;
import MapPackage.EmpEditController;
import Services.animalService;
import Services.emplacementService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MapController{

    
    @FXML
    private TableView<Emplacement> emptable;

    @FXML
    private TableColumn<Emplacement, String> codeemp;

    @FXML
    private TableColumn<Emplacement, String> saisonemp;

    @FXML
    private TableView<Animal> animaltable;

    @FXML
    private TableColumn<Animal, String> idanimal;

    @FXML
    private TableColumn<Animal, String> regionanimal;

    @FXML
    private TableColumn<Animal, String> etatanimal;

    @FXML
    private TableColumn<Animal, String> qteanimal;

    @FXML
    private TableColumn<Animal, String> saisonanimal;

    @FXML
    private TableColumn<Animal, String> typeanimal;

    @FXML
    private TableColumn<Animal, String> descanimal;
    
    @FXML
    private Button empadd;

    @FXML
    private Button empedit;

    @FXML
    private Button empdel;

    @FXML
    private Button animaladd;

    @FXML
    private Button animaledit;

    @FXML
    private Button animaldel;

    public void refresh_tables(MouseEvent event)
    {
        idanimal.setCellValueFactory(new PropertyValueFactory<>("id"));
        regionanimal.setCellValueFactory(new PropertyValueFactory<>("region"));
        etatanimal.setCellValueFactory(new PropertyValueFactory<>("etat"));
        qteanimal.setCellValueFactory(new PropertyValueFactory<>("qteEstim"));
        saisonanimal.setCellValueFactory(new PropertyValueFactory<>("saison"));
        typeanimal.setCellValueFactory(new PropertyValueFactory<>("type"));
        descanimal.setCellValueFactory(new PropertyValueFactory<>("desc"));
        codeemp.setCellValueFactory(new PropertyValueFactory<>("code"));
        saisonemp.setCellValueFactory(new PropertyValueFactory<>("saison"));
        emptable.setItems(getEmplacementList());
        animaltable.setItems(getAnimalList());
    }
    
    public ObservableList<Animal> getAnimalList()
    {
        animalService as = new animalService();
        ObservableList<Animal> temp = FXCollections.observableArrayList();
        List<Animal> la = as.getAll();
        la.forEach((e)->{
            temp.add(e);
        });
        return temp;
    }
    
    public ObservableList<Emplacement> getEmplacementList()
    {
        emplacementService es = new emplacementService();
        ObservableList<Emplacement> temp = FXCollections.observableArrayList();
        List<Emplacement> le = es.getAll();
        le.forEach((e)->temp.add(e));
        return temp;
    }
    
    public void showAddEmp(MouseEvent event) throws IOException
    {
        Stage addStage = new Stage();
        Pane mainpane = (Pane) FXMLLoader.load(EmpAddController.class.getResource("/MapPackage/AjoutEmp.fxml"));
        Scene scene = new Scene(mainpane);
        addStage.setScene(scene);
        addStage.initStyle(StageStyle.UNDECORATED);
        addStage.show();
    }
    
    public void showEditEmp(MouseEvent event) throws IOException
    {
        Stage editStage = new Stage();
        FXMLLoader loader = new FXMLLoader(EmpEditController.class.getResource("/MapPackage/EditEmp.fxml"));
        Parent root = loader.load();
        EmpEditController sc = loader.getController();
        Emplacement e = emptable.getSelectionModel().getSelectedItem();
        if(e!=null)
        {
            sc.transferData(e);
            editStage.setScene(new Scene(root));
            editStage.initStyle(StageStyle.UNDECORATED);
            editStage.show();
        }
    }
    
    public void showDeleteEmp(MouseEvent event) throws IOException
    {
        Stage deleteStage = new Stage();
        FXMLLoader loader = new FXMLLoader(EmpDeleteController.class.getResource("/MapPackage/DeleteEmp.fxml"));
        Parent root = loader.load();
        EmpDeleteController sc = loader.getController();
        Emplacement e = emptable.getSelectionModel().getSelectedItem();
        if(e!=null)
        {
            sc.transferData(e);
            deleteStage.setScene(new Scene(root));
            deleteStage.initStyle(StageStyle.UNDECORATED);
            deleteStage.show();
        }
    }
    
    public void showAddAnimal(MouseEvent event) throws IOException
    {
        emplacementService es = new emplacementService();
        Stage addStage = new Stage();
        FXMLLoader loader = new FXMLLoader(AnimalAddController.class.getResource("/MapPackage/AjoutAnimal.fxml"));
        Parent root = loader.load();
        AnimalAddController aa = loader.getController();
        List<Emplacement> le = es.getAll();
        if(le!=null)
        {
            aa.transferEmpList(le);
            addStage.setScene(new Scene(root));
            addStage.initStyle(StageStyle.UNDECORATED);
            addStage.show();
        }
    }
    
    public void showEditAnimal(MouseEvent event) throws IOException
    {
        emplacementService es = new emplacementService();
        Stage editStage = new Stage();
        FXMLLoader loader = new FXMLLoader(AnimalEditController.class.getResource("/MapPackage/EditAnimal.fxml"));
        Parent root = loader.load();
        AnimalEditController ae = loader.getController();
        List<Emplacement> le = es.getAll();
        Animal a = animaltable.getSelectionModel().getSelectedItem();
        if(a!=null)
        {
            ae.transferData(a,le);
            editStage.setScene(new Scene(root));
            editStage.initStyle(StageStyle.UNDECORATED);
            editStage.show();
        }
    }
    
    public void showDeleteAnimal(MouseEvent event) throws IOException
    {
        Stage deleteStage = new Stage();
        FXMLLoader loader = new FXMLLoader(AnimalDeleteController.class.getResource("/MapPackage/DeleteAnimal.fxml"));
        Parent root = loader.load();
        AnimalDeleteController ad = loader.getController();
        Animal a = animaltable.getSelectionModel().getSelectedItem();
        if(a!=null)
        {
            ad.transferData(Integer.toString(a.getId()));
            deleteStage.setScene(new Scene(root));
            deleteStage.initStyle(StageStyle.UNDECORATED);
            deleteStage.show();
        }
    }

}
