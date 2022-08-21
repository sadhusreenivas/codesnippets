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

public class CorrectIncorrectController {

    @FXML
    private AnchorPane correctScreen;

    @FXML
    private Button nextButton;
    
    @FXML
    private Text correctText;
    
    @FXML
    private Text incorrectText;

    private int currentScore;

    public void initScore(int score, int totalScore) {
        currentScore = totalScore;
        currentScore += score;
        
    }
    
    public void cSetPage(int score, int totalScore) {
        correctText.setText("Congrats !! You are Correct! \t You won $ "+score+"\n Total Winnings so far:\n $ "+currentScore);
    }
    
    public void incSetPage(int score, int totalScore) {
        incorrectText.setText("Sorry !! Its Wrong! \t You scored $ "+score+"\n Total Winnings so far:\n $ "+currentScore);
    
    }

    @FXML
    public void nextScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(Main.class.getResource("QuestionsPage.fxml"));
        Parent viewQuestion = loader.load();

        Scene viewQuestionScene = new Scene(viewQuestion);

        QuestionTestController controller = loader.getController();
        controller.updateScore(currentScore);
        controller.changeColor();
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewQuestionScene);
        window.show();
    }
}
