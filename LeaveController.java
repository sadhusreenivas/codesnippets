import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.text.Text;

public class LeaveController {

    @FXML
    private AnchorPane correctScreen;

    @FXML
    private Text leave;

    private int currentScore;

    public void updateScore( int totalScore) {
       int score = totalScore;
              
       leave.setText("Well Played!!\n Your Total Winnings:\n $ "+score+"\n\n See You Again!");
    }

   
}
