package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndTextFieldApplication extends Application {
    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

    @Override
    public void start(Stage window) {
        Button button = new Button("I am a button.");
        TextField textField = new TextField("I am a text field.");
        FlowPane componentGroup = new FlowPane();
        Scene view = new Scene(componentGroup);
        
        componentGroup.getChildren().add(button);
        componentGroup.getChildren().add(textField);
        window.setScene(view);
        window.show();
    }
}
