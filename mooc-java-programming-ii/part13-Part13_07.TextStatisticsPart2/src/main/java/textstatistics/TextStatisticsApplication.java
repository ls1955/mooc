package textstatistics;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.Arrays;

public class TextStatisticsApplication extends Application {
    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        BorderPane mainDiv = new BorderPane();
        HBox texts = new HBox();
        TextArea textArea = new TextArea();
        Scene scene = new Scene(mainDiv);
        Label lettersLabel = new Label("Letters: 0");
        Label wordsLabel = new Label("Words: 0");
        Label longestWordLabel = new Label("The longest word is:");
        
        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            int newLettersAmount = newValue.length();
            String[] words = newValue.split(" ");
            int newWordsAmount = words.length;
            String longestWord = Arrays.stream(words).sorted((word1, word2) -> word2.length() - word1.length()).findFirst().get();
            
            lettersLabel.setText("Letters: " + newLettersAmount);
            wordsLabel.setText("Words: " + newWordsAmount);
            longestWordLabel.setText("The longest word is: " + longestWord);
        });
        
        texts.getChildren().add(lettersLabel);
        texts.getChildren().add(wordsLabel);
        texts.getChildren().add(longestWordLabel);
        texts.setSpacing(10);
        
        mainDiv.setCenter(textArea);
        mainDiv.setBottom(texts);
        
        window.setScene(scene);
        window.show();
    }
}
