package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {
    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        BorderPane mainDiv = new BorderPane();
        HBox texts = new HBox();
        TextArea textArea = new TextArea("Enter something here?");
        Scene scene = new Scene(mainDiv);
        
        texts.getChildren().add(new Label("Letters: 0"));
        texts.getChildren().add(new Label("Words: 0"));
        texts.getChildren().add(new Label("The longest word is:"));
        texts.setSpacing(10);
        
        mainDiv.setCenter(textArea);
        mainDiv.setBottom(texts);
        
        window.setScene(scene);
        window.show();
    }
}
