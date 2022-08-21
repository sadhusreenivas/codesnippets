import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        root.setStyle("-fx-background-color: BEIGE;"); 
        root.setStyle("-fx-background-image:url('jeopardy.jpg'); -fx-background-size:800 500;-fx-background-repeat: no-repeat;-fx-background-color:orange; ");
        Scene scene = new Scene(root);
        primaryStage.setTitle("Jeopardy");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
 public static void main(String[] args) {
        launch(args);
    }
}