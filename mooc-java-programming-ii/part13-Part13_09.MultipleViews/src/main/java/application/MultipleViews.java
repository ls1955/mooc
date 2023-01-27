package application;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane firstPageLayout = new BorderPane();
        Label firstPageLabel = new Label("First view!");
        Button firstPageButton = new Button("To the second view!");
        Scene firstScene = new Scene(firstPageLayout);
        
        VBox secondPageLayout = new VBox();
        Button secondPageButton = new Button("To the third view!");
        Label secondPageLabel = new Label("Second view!");
        Scene secondScene = new Scene(secondPageLayout);
        
        GridPane thirdPageLayout = new GridPane();
        Label thirdPageLabel = new Label("Third view!");
        Button thirdPageButton = new Button("To the first view!");
        Scene thirdScene = new Scene(thirdPageLayout);
        
        firstPageLayout.setTop(firstPageLabel);
        firstPageLayout.setCenter(firstPageButton);
        firstPageButton.setOnAction((event) -> stage.setScene(secondScene));
        
        secondPageLayout.getChildren().addAll(secondPageButton, secondPageLabel);
        secondPageButton.setOnAction((event) -> stage.setScene(thirdScene));
        
        thirdPageLayout.add(thirdPageLabel, 0, 0);
        thirdPageLayout.add(thirdPageButton, 1, 1);
        thirdPageButton.setOnAction((event) -> stage.setScene(firstScene));
        
        stage.setScene(firstScene);
        stage.show();
    }
}
