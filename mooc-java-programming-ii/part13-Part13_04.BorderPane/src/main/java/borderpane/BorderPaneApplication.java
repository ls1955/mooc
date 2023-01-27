package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneApplication extends Application {
    public static void main(String[] args) {
        launch(BorderPaneApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        Label north = new Label("NORTH");
        Label east = new Label("EAST");
        Label south = new Label("SOUTH");
        BorderPane layout = new BorderPane();
        Scene scene = new Scene(layout);
        
        layout.setTop(north);
        layout.setRight(east);
        layout.setBottom(south);
        window.setScene(scene);
        window.show();
    }

    
}