package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {
    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        BorderPane mainLayout = new BorderPane();
        HBox buttonsDiv = new HBox();
        Button jokeButton = new Button("Joke");
        Button textButton = new Button("Answer");
        Button explanation1Button = new Button("Explanation");
        Button explanation2Button = new Button("further explanation");
        Scene mainScene = new Scene(mainLayout);
        
        buttonsDiv.setPadding(new Insets(20, 20, 20, 20));
        buttonsDiv.setSpacing(10);
        buttonsDiv.getChildren().addAll(jokeButton, textButton, explanation1Button, explanation2Button);
        mainLayout.setTop(buttonsDiv);
        
        StackPane jokeLayout = createView("What do you call a bear with no teeth?");
        StackPane textLayout = createView("A gummy bear.");
        StackPane explanationLayout = createView("Gum is the soft red part where teeth come out of.");
        StackPane furtherExplanationLayout = createView("A bear with no teeth still have gum. Thus, gummy bear.");
        
        jokeButton.setOnAction((event) -> mainLayout.setCenter(jokeLayout));
        textButton.setOnAction((event) -> mainLayout.setCenter(textLayout));
        explanation1Button.setOnAction((event) -> mainLayout.setCenter(explanationLayout));
        explanation2Button.setOnAction((event) -> mainLayout.setCenter(furtherExplanationLayout));
        
        mainLayout.setCenter(jokeLayout);
        window.setScene(mainScene);
        
        window.show();
    }
    
    private StackPane createView(String text) {
        StackPane stackPane = new StackPane();
        
        stackPane.setPrefSize(300, 180);
        stackPane.getChildren().add(new Label(text));
        stackPane.setAlignment(Pos.CENTER);
        
        return stackPane;
    }
}
