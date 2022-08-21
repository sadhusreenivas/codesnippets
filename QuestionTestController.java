
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class QuestionTestController implements Initializable {
    @FXML
    private Label lblName1;
       
    @FXML
    private Button AsportsButton1;

    @FXML
    private Button CsportsButton3;

    @FXML
    private Button BsportsButton2;

    @FXML
    private Button DsportsButton4;

    @FXML
    private Button AhistoryButton1;

    @FXML
    private Button BhistoryButton2;

    @FXML
    private Button ChistoryButton3;

    @FXML
    private Button DhistoryButton4;

    @FXML
    private Button AtvmoviesButton1;

    @FXML
    private Button BtvmoviesButton2;

    @FXML
    private Button CtvmoviesButton3;

    @FXML
    private Button DtvmoviesButton4;

    @FXML
    private Button AmusicButton1;

    @FXML
    private Button BmusicButton2;

    @FXML
    private Button CmusicButton3;

    @FXML
    private Button DmusicButton4;
    
    @FXML
    private Label scoreCounter;
    
    @FXML
    private Label lblQtn;
    
    @FXML
    private Button btnLeave;

    @FXML
    private Text tsports;
    
    @FXML
    private Text thistory;
    
    @FXML
    private Text tmovies;
    
    @FXML
    private Text tmusic;
    
    private int totalScore;
    private static int qcounter = 0;
    private String bid;
    
    static String buttonIDID="";
    
    public void updateScore(int currentScore) throws IOException{
        totalScore = currentScore;
        scoreCounter.setText("Score: " + totalScore); 
    }

    @FXML 
    public Question loadQuestion(ActionEvent event) throws IOException, URISyntaxException {
        Button buttonID = (Button)event.getSource();
        buttonIDID = buttonID.getId();
        System.out.println(buttonID );
        System.out.println("Button ID Retrived: " + buttonIDID);
       
        // buttonIDID.setStyle("-fx-background-image : url('redbutton.jpg');-fx-background-size:175 130;");
        
        String questionType = "";
        Question questionChoice = new Question();
        
        if(buttonIDID.substring(buttonIDID.length() - 1).equals("1"))
        {    
            questionType = buttonIDID.substring(1,2);
            
            if (questionType.equals("s"))
            {   
                questionType = "Sports";
                questionChoice = getQuestion(0, buttonIDID, 100, questionType);
               
             }
            else if (questionType.equals("h"))
            {   
                questionType = "History";
                questionChoice = getQuestion(4, buttonIDID, 100, questionType);  
            }
            else if (questionType.equals("t"))
            {   
                questionType = "TV-Movies";
                questionChoice = getQuestion(8, buttonIDID, 100, questionType);  
            }
            else if (questionType.equals("m"))
            {   
                questionType = "Music";
                questionChoice = getQuestion(12, buttonIDID, 100, questionType);
                
            }
        }
        else if(buttonIDID.substring(buttonIDID.length() - 1).equals("2"))
        {
            questionType = buttonIDID.substring(1,2);
            
            if (questionType.equals("s"))
            {   
                questionType = "Sports";
                questionChoice = getQuestion(1, buttonIDID, 200, questionType);
                
            }
            else if (questionType.equals("h"))
            {   
                questionType = "History";
                questionChoice = getQuestion(5, buttonIDID, 200, questionType);  
            }
            else if (questionType.equals("t"))
            {   
                questionType = "TV-Movies";
                questionChoice = getQuestion(9, buttonIDID, 200, questionType);  
            }
            else if (questionType.equals("m"))
            {   
                questionType = "Music";
                questionChoice = getQuestion(13, buttonIDID, 200, questionType);  
            }
        }
        else if(buttonIDID.substring(buttonIDID.length() - 1).equals("3"))
        {
            questionType = buttonIDID.substring(1,2);
            
             if (questionType.equals("s"))
            {   
                questionType = "Sports";
                questionChoice = getQuestion(2, buttonIDID, 300, questionType);  
            }
            else if (questionType.equals("h"))
            {   
                questionType = "History";
                questionChoice = getQuestion(6, buttonIDID, 300, questionType);  
            }
            else if (questionType.equals("t"))
            {   
                questionType = "TV-Movies";
                questionChoice = getQuestion(10, buttonIDID, 300, questionType);  
            }
            else if (questionType.equals("m"))
            {   
                questionType = "Music";
                questionChoice = getQuestion(14, buttonIDID, 300, questionType);  
            }
        }
        else if(buttonIDID.substring(buttonIDID.length() - 1).equals("4"))
        {
            questionType = buttonIDID.substring(1,2);
            
            if (questionType.equals("s"))
            {   
                questionType = "Sports";
                questionChoice = getQuestion(3, buttonIDID, 400, questionType);  
            }
            else if (questionType.equals("h"))
            {   
                questionType = "History";
                questionChoice = getQuestion(7, buttonIDID, 400, questionType);  
            }
            else if (questionType.equals("t"))
            {   
                questionType = "TV-Movies";
                questionChoice = getQuestion(11, buttonIDID, 400, questionType);  
            }
            else if (questionType.equals("m"))
            {   
                questionType = "Music";
                questionChoice = getQuestion(15, buttonIDID, 400, questionType);  
            }
        }
        
        return questionChoice;
    }
    
    public void changeColor(){
       if (buttonIDID.equals("AsportsButton1"))
       AsportsButton1.setStyle("-fx-background-image : url('redbutton.jpg');-fx-background-size:175 130;");
       //AsportsButton1.setDisable(true);
       
       if (buttonIDID.equals("BsportsButton2"))
       BsportsButton2.setStyle("-fx-background-image : url('redbutton.jpg');-fx-background-size:175 130;");
       //BsportsButton2.setDisable(true);
       
       if (buttonIDID.equals("CsportsButton3"))
       CsportsButton3.setStyle("-fx-background-image : url('redbutton.jpg');-fx-background-size:175 130;");
       //CsportsButton3.setDisable(true);
       
       if (buttonIDID.equals("DsportsButton4"))
       DsportsButton4.setStyle("-fx-background-image : url('redbutton.jpg');-fx-background-size:175 130;");
       //DsportsButton4.setDisable(true);
                
       if (buttonIDID.equals("AhistoryButton1"))
       AhistoryButton1.setStyle("-fx-background-image : url('redbutton.jpg');-fx-background-size:175 130;");
       
        if (buttonIDID.equals("BhistoryButton2"))
       BhistoryButton2.setStyle("-fx-background-image : url('redbutton.jpg');-fx-background-size:175 130;");
        
         if (buttonIDID.equals("ChistoryButton3"))
       ChistoryButton3.setStyle("-fx-background-image : url('redbutton.jpg');-fx-background-size:175 130;");
         
       if (buttonIDID.equals("DhistoryButton4"))
       DhistoryButton4.setStyle("-fx-background-image : url('redbutton.jpg');-fx-background-size:175 130;");
     
       if (buttonIDID.equals("AtvmoviesButton1"))
       AtvmoviesButton1.setStyle("-fx-background-image : url('redbutton.jpg');-fx-background-size:175 130;");
       
       if (buttonIDID.equals("BtvmoviesButton2"))
       BtvmoviesButton2.setStyle("-fx-background-image : url('redbutton.jpg');-fx-background-size:175 130;");
       
       
       if (buttonIDID.equals("CtvmoviesButton3"))
       CtvmoviesButton3.setStyle("-fx-background-image : url('redbutton.jpg');-fx-background-size:175 130;");
       
       if (buttonIDID.equals("DtvmoviesButton4"))
       DtvmoviesButton4.setStyle("-fx-background-image : url('redbutton.jpg');-fx-background-size:175 130;");
       
       if (buttonIDID.equals("AmusicButton1"))
       AmusicButton1.setStyle("-fx-background-image : url('redbutton.jpg');-fx-background-size:175 130;");
       
       if (buttonIDID.equals("BmusicButton2"))
       BmusicButton2.setStyle("-fx-background-image : url('redbutton.jpg');-fx-background-size:175 130;");
        
         if (buttonIDID.equals("CmusicButton3"))
       CmusicButton3.setStyle("-fx-background-image : url('redbutton.jpg');-fx-background-size:175 130;");
         
       if (buttonIDID.equals("DmusicButton4"))
       DmusicButton4.setStyle("-fx-background-image : url('redbutton.jpg');-fx-background-size:175 130;");
    }

    
    public void changeSceneToQuestion(ActionEvent event) throws IOException, URISyntaxException {
        qcounter++;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("GenericQuestion.fxml"));
        Parent viewQuestion = loader.load();

        Scene viewQuestionScene = new Scene(viewQuestion);

        AnswerController controller = loader.getController();
        controller.initData(loadQuestion(event));
        controller.keepScore(totalScore);
          
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        String name = (String)window.getUserData();
        lblQtn.setText(qcounter+" Questions read out of 16");
        System.out.println("Questions read:" +qcounter);
        lblName1.setText("Welcome "+name);
        window.setScene(viewQuestionScene);
        window.setTitle(" Welcome to Jeopardy game: "+name +"!");
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        btnLeave.setStyle("-fx-background-color: orange; -fx-text-fill: indigo;"); 
        lblName1.setStyle("-fx-font:consolas; -fx-text-fill:Yellow; -fx-font-size:20");
        scoreCounter.setStyle("-fx-background-color: orange; -fx-text-fill: indigo; -fx-font-size:25");
        lblQtn.setStyle("-fx-background-color: yellow; -fx-text-fill:red; -fx-font-size:22");
        scoreCounter.setText(" Winnings: $ " + totalScore); 
        lblName1.setText("Welcome! Lets Play the game!!");
        lblQtn.setText(qcounter+" Questions read out of 16");
    }
    public Question getQuestion(int questionLineNumber, String buttonIDID, int score, String questionType) throws IOException, URISyntaxException {
        System.out.println("Question Line Number: " + questionLineNumber);
        System.out.println("Question Type: " + questionType);
        System.out.println("Score: "+score);
        //URL url = Main.class.getResource("/src/resources/QuestionsPool.txt");
        Path questionPool = Paths.get("src/QuestionsPool.txt");
        List l = new ArrayList();
        l = Files.readAllLines(questionPool);
        String line =(String) l.get(questionLineNumber);
        System.out.println(line);
        String question = line.substring(0, line.indexOf("@"));

        String answer = line.substring(line.indexOf("@") + 1);
    
        String[] answerChoices = answer.split("#");
        System.out.println("Button IDID: " + buttonIDID);
        String correctAns = buttonIDID.substring(0,1);

        return new Question(questionType, correctAns, answerChoices, question, score);
    }
    
     public void leaveGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Leavegame.fxml"));
        Parent viewQuestion = loader.load();

        Scene viewQuestionScene = new Scene(viewQuestion);

        LeaveController controller = loader.getController();
        controller.updateScore(totalScore);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewQuestionScene);
        String name = (String)window.getUserData();
        window.setTitle(" See you again at Jeopardy: "+name +"!");
        window.show();
    }
}

