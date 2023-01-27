package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {
    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

    @Override
    public void start(Stage window) {
        Button button = new Button("I am a button.");
        Label label = new Label("I am a label.");
        FlowPane componentGroup = new FlowPane();
        Scene view = new Scene(componentGroup);
        
        componentGroup.getChildren().add(button);
        componentGroup.getChildren().add(label);
        window.setScene(view);
        window.show();
    }
}
