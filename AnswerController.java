import java.io.IOException;
import java.net.URISyntaxException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;

public class AnswerController {

    @FXML
    private Button answerA;

    @FXML
    private Button answerB;

    @FXML
    private Button answerC;

    @FXML
    private Button answerD;

    @FXML
    private Text questionText;

    @FXML ActionEvent event;

    @FXML
    private Text questionTitle;

    @FXML
    private Button quitButton;
    
    @FXML
    private Text correctText;
    
    @FXML
    private Text incorrectText;
    
    private Question questionChoice;
    private int currentScore;

    public void initData(Question question) {
        questionChoice = question;
        questionTitle.setText(questionChoice.getQuestionType() + "  $" + questionChoice.getPointValue());
        questionText.setText(questionChoice.getQuestion());

        answerA.setText(questionChoice.getChoices()[0]);
        answerB.setText(questionChoice.getChoices()[1]);
        answerC.setText(questionChoice.getChoices()[2]);
        answerD.setText(questionChoice.getChoices()[3]);
        
        quitButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        answerA.setStyle("-fx-background-color:yellow");
        answerB.setStyle("-fx-background-color:yellow");
        answerC.setStyle("-fx-background-color:yellow");
        answerD.setStyle("-fx-background-color:yellow");
    }

    @FXML
    public void checkAnswer(ActionEvent event) throws URISyntaxException, IOException {
        Button checkAnswerButton = (Button)event.getSource();
        String userAnswerID = checkAnswerButton.getId();
        String userAnswer = userAnswerID.substring(6, 7);

        System.out.println("Correct answer: " + questionChoice.getAnswer());
        System.out.println("User answer: " + userAnswer);
        
        if (userAnswer.toLowerCase().equals(questionChoice.getAnswer().toLowerCase()))
        {
            System.out.println("Correct!");
            //correctAnswer();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Correct.fxml"));
            Parent viewQuestion = loader.load();

            Scene viewQuestionScene = new Scene(viewQuestion);

            CorrectIncorrectController controller = loader.getController();
            controller.initScore(questionChoice.getPointValue(), currentScore);
            controller.cSetPage(questionChoice.getPointValue(), currentScore);
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(viewQuestionScene);
            window.show();
        }
        else
        {
            System.out.println("Wrong!");
            //wrongAnswer();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Incorrect.fxml"));
            Parent viewQuestion = loader.load();

            Scene viewQuestionScene = new Scene(viewQuestion);

            CorrectIncorrectController controller = loader.getController();
            controller.initScore(0, currentScore);
            controller.incSetPage(0, currentScore);
         
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(viewQuestionScene);
            window.show();
        }
    }

    public void keepScore(int totalScore) {
        currentScore = totalScore;
    }
    
   
    
    @FXML
    void quitGame(ActionEvent event) {
        Platform.exit();
    }
}
