package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    private String currSymbol;

    public TicTacToeApplication() {
        this.currSymbol = "X";
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void init() throws Exception {
        this.currSymbol = "X";
    }

    @Override
    public void start(Stage window) throws Exception {
        BorderPane mainDiv = new BorderPane();
        Label turnsLabel = new Label("Turn: X");

        GridPane board = new GridPane();
        Button button00 = new Button("");
        Button button01 = new Button("");
        Button button02 = new Button("");
        Button button10 = new Button("");
        Button button11 = new Button("");
        Button button12 = new Button("");
        Button button20 = new Button("");
        Button button21 = new Button("");
        Button button22 = new Button("");

        Scene scene = new Scene(mainDiv);

        board.add(button00, 0, 0);
        board.add(button01, 1, 0);
        board.add(button02, 2, 0);
        board.add(button10, 0, 1);
        board.add(button11, 1, 1);
        board.add(button12, 2, 1);
        board.add(button20, 0, 2);
        board.add(button21, 1, 2);
        board.add(button22, 2, 2);
        board.setVgap(10);
        board.setHgap(10);

        mainDiv.setTop(turnsLabel);
        mainDiv.setCenter(board);

        button00.setOnMouseClicked((event) -> {
            if (isEmpty(button00)) {
                button00.setText(currSymbol);
                updateSymbol();
                turnsLabel.setText("Turn: " + currSymbol);

                if (isGameOver(button00, button01, button02, button10, button11, button12, button20, button21, button22)) {
                    turnsLabel.setText("The end!");
                    window.close();

                    return;
                }
            }
        });
        button01.setOnMouseClicked((event) -> {
            if (isEmpty(button01)) {
                button01.setText(currSymbol);
                updateSymbol();
                turnsLabel.setText("Turn: " + currSymbol);

                if (isGameOver(button00, button01, button02, button10, button11, button12, button20, button21, button22)) {
                    turnsLabel.setText("The end!");
                    window.close();

                    return;
                }
            }
        });
        button02.setOnMouseClicked((event) -> {
            if (isEmpty(button02)) {
                button02.setText(currSymbol);
                updateSymbol();
                turnsLabel.setText("Turn: " + currSymbol);

                if (isGameOver(button00, button01, button02, button10, button11, button12, button20, button21, button22)) {
                    turnsLabel.setText("The end!");
                    window.close();

                    return;
                }
            }
        });
        button10.setOnMouseClicked((event) -> {
            if (isEmpty(button10)) {
                button10.setText(currSymbol);
                updateSymbol();
                turnsLabel.setText("Turn: " + currSymbol);

                if (isGameOver(button00, button01, button02, button10, button11, button12, button20, button21, button22)) {
                    turnsLabel.setText("The end!");
                    window.close();

                    return;
                }
            }
        });
        button11.setOnMouseClicked((event) -> {
            if (isEmpty(button11)) {
                button11.setText(currSymbol);
                updateSymbol();
                turnsLabel.setText("Turn: " + currSymbol);

                if (isGameOver(button00, button01, button02, button10, button11, button12, button20, button21, button22)) {
                    turnsLabel.setText("The end!");
                    window.close();

                    return;
                }
            }
        });
        button12.setOnMouseClicked((event) -> {
            if (isEmpty(button12)) {
                button12.setText(currSymbol);
                updateSymbol();
                turnsLabel.setText("Turn: " + currSymbol);

                if (isGameOver(button00, button01, button02, button10, button11, button12, button20, button21, button22)) {
                    turnsLabel.setText("The end!");
                    window.close();

                    return;
                }
            }
        });
        button20.setOnMouseClicked((event) -> {
            if (isEmpty(button20)) {
                button20.setText(currSymbol);
                updateSymbol();
                turnsLabel.setText("Turn: " + currSymbol);

                if (isGameOver(button00, button01, button02, button10, button11, button12, button20, button21, button22)) {
                    turnsLabel.setText("The end!");
                    window.close();

                    return;
                }
            }
        });
        button21.setOnMouseClicked((event) -> {
            if (isEmpty(button21)) {
                button21.setText(currSymbol);
                updateSymbol();
                turnsLabel.setText("Turn: " + currSymbol);

                if (isGameOver(button00, button01, button02, button10, button11, button12, button20, button21, button22)) {
                    turnsLabel.setText("The end!");
                    window.close();

                    return;
                }
            }
        });
        button22.setOnMouseClicked((event) -> {
            if (isEmpty(button22)) {
                button22.setText(currSymbol);
                updateSymbol();
                turnsLabel.setText("Turn: " + currSymbol);

                if (isGameOver(button00, button01, button02, button10, button11, button12, button20, button21, button22)) {
                    turnsLabel.setText("The end!");
                    window.close();

                    return;
                }
            }
        });

        if (turnsLabel.getText().equals("The end!") || isGameOver(button00, button01, button02, button10, button11, button12, button20, button21, button22)) {
            turnsLabel.setText("The end!");
            window.close();

            return;
        }
        
        window.setScene(scene);
        window.show();
    }

    private void updateSymbol() {
        currSymbol = currSymbol.equals("X") ? "O" : "X";
    }

    private boolean isEmpty(Button button) {
        return button.getText().equals("");
    }

    private boolean isGameOver(Button button00, Button button01, Button button02, Button button10, Button button11, Button button12, Button button20, Button button21, Button button22) {
        String symbol00 = button00.getText();
        String symbol01 = button01.getText();
        String symbol02 = button02.getText();
        String symbol10 = button10.getText();
        String symbol11 = button11.getText();
        String symbol12 = button12.getText();
        String symbol20 = button20.getText();
        String symbol21 = button21.getText();
        String symbol22 = button22.getText();

        if (!symbol00.equals("") && symbol00.equals(symbol01) && symbol00.equals(symbol02)) {
            return true;
        } else if (!symbol10.equals("") && symbol10.equals(symbol11) && symbol10.equals(symbol12)) {
            return true;
        } else if (!symbol20.equals("") && symbol20.equals(symbol21) && symbol20.equals(symbol22)) {
            return true;
        } else if (!symbol00.equals("") && symbol00.equals(symbol10) && symbol00.equals(symbol20)) {
            return true;
        } else if (!symbol01.equals("") && symbol01.equals(symbol11) && symbol01.equals(symbol21)) {
            return true;
        } else if (!symbol02.equals("") && symbol02.equals(symbol12) && symbol02.equals(symbol22)) {
            return true;
        } else if (!symbol00.equals("") && symbol00.equals(symbol11) && symbol00.equals(symbol22)) {
            return true;
        } else if (!symbol02.equals("") && symbol02.equals(symbol11) && symbol02.equals(symbol20)) {
            return true;
        } else if (!symbol00.equals("") && !symbol01.equals("") && !symbol02.equals("") && !symbol10.equals("") && !symbol11.equals("") && !symbol12.equals("") && !symbol20.equals("") && !symbol21.equals("") && !symbol22.equals("")) {
            return true;
        }

        return false;
    }
}
