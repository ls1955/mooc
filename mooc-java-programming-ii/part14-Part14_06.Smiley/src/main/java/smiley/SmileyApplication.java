package smiley;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {
    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainDiv = new BorderPane();
        Canvas canvas = new Canvas(640, 640);
        GraphicsContext context = canvas.getGraphicsContext2D();
        Color whiteColor = Color.WHITE;
        Color blackColor = Color.BLACK;
        int unitSize = 640 / 8;
        Scene scene = new Scene(mainDiv);
        
        int[][] blackCoordinates = {{1, 2}, {1, 5}, {4, 1}, {4, 6}, {5, 2}, {5, 3}, {5, 4}, {5, 5}};
        
        mainDiv.setCenter(canvas);
        
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                context.setFill(whiteColor);
                context.fillRect(y * unitSize, x * unitSize, unitSize, unitSize);
            }
        }
        
        context.setFill(blackColor);
        
        for (int i = 0; i < blackCoordinates.length; i++) {
                int currX = blackCoordinates[i][0];
                int currY = blackCoordinates[i][1];
                
                context.fillRect(currY * unitSize, currX * unitSize, unitSize, unitSize);
        }
        
        stage.setScene(scene);
        stage.show();
    }

}
