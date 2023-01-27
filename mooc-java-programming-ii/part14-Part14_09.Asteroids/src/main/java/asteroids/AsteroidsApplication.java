package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class AsteroidsApplication extends Application {
    public static int WINDOWWIDTH = 300;
    public static int WINDOWHEIGHT = 200;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        Text text = new Text(10, 20, "Points: 0");
        AtomicInteger points = new AtomicInteger();
        Ship ship = new Ship(WINDOWWIDTH / 2, WINDOWHEIGHT / 2);
        List<Character> asteroids = new ArrayList<>();
        List<Character> projectiles = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            Random rng = new Random();
            Asteroid asteroid = new Asteroid(rng.nextInt(WINDOWWIDTH / 3), rng.nextInt(WINDOWHEIGHT));
            asteroids.add(asteroid);
        }
        
        pane.setPrefSize(WINDOWWIDTH, WINDOWHEIGHT);
        pane.getChildren().add(text);
        pane.getChildren().add(ship.getShape());
        asteroids.forEach( asteroid -> pane.getChildren().add(asteroid.getShape()));
        
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
        Scene scene = new Scene(pane);
        
        scene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });
        
        scene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }
                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }
                if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }
                if (pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3) {
                    int xPos = (int) ship.getShape().getTranslateX();
                    int yPos = (int) ship.getShape().getTranslateY();
                    double angle = ship.getShape().getRotate();
                    Projectile projectile = new Projectile(xPos, yPos);
                    
                    projectile.getShape().setRotate(angle);
                    projectiles.add(projectile);
                    projectile.accelerate();
                    projectile.setMoveDirection(projectile.getMoveDirection().normalize().multiply(3));
                    pane.getChildren().add(projectile.getShape());
                }
                
                ship.move();
                asteroids.forEach( asteroid -> asteroid.move());
                projectiles.forEach( projectile -> projectile.move());
                
                asteroids.forEach( asteroid -> {
                    if (ship.hasCollide(asteroid)) stop();
                });
                
                projectiles.forEach ( projectile -> {
                    asteroids.forEach ( asteroid -> {
                        if (asteroid.hasCollide(projectile)) {
                            asteroid.setAlive(false);
                            projectile.setAlive(false);
                        }
                    });
                    
                    if (!projectile.isAlive()) {
                        text.setText("Points: " + points.addAndGet(1000));
                    }
                });
                
                cleanUp(projectiles, pane);
                cleanUp(asteroids, pane);
                
                if (Math.random() < 0.005) {
                    Asteroid asteroid = new Asteroid(WINDOWWIDTH, WINDOWHEIGHT);
                    
                    if (!asteroid.hasCollide(ship)) {
                        asteroids.add(asteroid);
                        pane.getChildren().add(asteroid.getShape());
                    }
                }
            }
        }.start();
        stage.setTitle("Asteroids!");
        stage.setScene(scene);
        stage.show();
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;
    }

    private void cleanUp(List<Character> characters, Pane pane) {
        characters.stream()
                .filter( character -> !character.isAlive())
                .forEach ( character -> pane.getChildren().remove(character.getShape()));
        characters.removeAll(characters.stream()
            .filter( character -> !character.isAlive())
            .collect(Collectors.toList()));
    }
}
