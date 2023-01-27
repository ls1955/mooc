package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {
    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label promptText = new Label("Enter your name and start.");
        TextField nameField = new TextField();
        Button startButton = new Button("Start");
        GridPane promptLayout = new GridPane();
        Scene prompt = new Scene(promptLayout);
        
        promptLayout.add(promptText, 0, 0);
        promptLayout.add(nameField, 0, 1);
        promptLayout.add(startButton, 0, 2);
        promptLayout.setPrefSize(300, 180);
        promptLayout.setAlignment(Pos.CENTER);
        promptLayout.setVgap(10);
        promptLayout.setHgap(10);
        promptLayout.setPadding(new Insets(20, 20, 20, 20));
        
        Label welcomeText = new Label();
        StackPane welcomeLayout = new StackPane();
        Scene welcomeScene = new Scene(welcomeLayout);
        
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.getChildren().add(welcomeText);
        welcomeLayout.setAlignment(Pos.CENTER);
        
        startButton.setOnAction((event) -> {
            String name = nameField.getText().trim();
            
            if (name.equals("")) {
                return;
            }
            
            welcomeText.setText("Welcome " + name + "!");
            
            stage.setScene(welcomeScene);
        });
        
        stage.setScene(prompt);
        stage.show();
    }
}
