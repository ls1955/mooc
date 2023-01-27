package collage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {

        // the example opens the image, creates a new image, and copies the opened image
        // into the new one, pixel by pixel
        Image sourceImage = new Image("file:monalisa.png");

        PixelReader imageReader = sourceImage.getPixelReader();

        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();

        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter imageWriter = targetImage.getPixelWriter();

        for (int yCoordinate = 0; yCoordinate < height; yCoordinate++) {
            for (int xCoordinate = 0; xCoordinate < width; xCoordinate++) {

                Color color = imageReader.getColor(xCoordinate, yCoordinate);
                double red = 1.0 - color.getRed();
                double green = 1.0 - color.getGreen();
                double blue = 1.0 - color.getBlue();
                double opacity = color.getOpacity();

                Color newColor = new Color(red, green, blue, opacity);

                if (xCoordinate % 2 == 0 && yCoordinate % 2 == 0) {
                    imageWriter.setColor(xCoordinate / 2, yCoordinate / 2, newColor);
                    imageWriter.setColor(xCoordinate / 2 + width / 2, yCoordinate / 2, newColor);
                    imageWriter.setColor(xCoordinate / 2, yCoordinate / 2 + height / 2, newColor);
                    imageWriter.setColor(xCoordinate / 2 + width / 2, yCoordinate / 2 + height / 2, newColor);
                }
            }
        }

        ImageView image = new ImageView(targetImage);

        Pane pane = new Pane();
        pane.getChildren().add(image);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
