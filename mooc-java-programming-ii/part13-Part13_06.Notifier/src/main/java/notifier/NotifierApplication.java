package notifier;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application{
    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        TextField textField = new TextField();
        Button updateButton = new Button("Update");
        Label label = new Label();
        VBox verticalLayout = new VBox();
        Scene scene = new Scene(verticalLayout);
        
        updateButton.setOnAction((event) -> {
            label.setText(textField.getText());
        });
        
        verticalLayout.getChildren().addAll(textField, updateButton,label);
        window.setScene(scene);
        window.show();
    }
}
