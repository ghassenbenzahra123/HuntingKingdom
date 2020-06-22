package AutorisationPackage;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;
import javafx.scene.layout.Background;

/**
 * Create an anchor pane that can store additional data.
 */
public class AnchorPaneNode extends AnchorPane {

    // Date associated with this pane
    private LocalDate date;

    /**
     * Create a anchor pane node. Date is not assigned in the constructor.
     * @param children children of the anchor pane
     */
    public AnchorPaneNode(Node... children) {
        super(children);
        // Add action handler for mouse clicked
        this.setOnMouseClicked(e -> System.out.println("This pane's date is: " + date));
       // this.getChildren().
        
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
      //  this.setStyle("-fx-background-color: blue;");
        this.date = date;
    }
    public void setDateL(LocalDate date) {
     //   this.setStyle("-fx-background-color: red;");
        this.date = date;
    }
}
