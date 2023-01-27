/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author cheong
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PracticeApplication extends Application {
    private Dictionary dictionary;

    @Override
    public void init() throws Exception {
        this.dictionary = new Dictionary();
    }
    
    public static void main(String args) {
        launch(PracticeApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        InputView inputView = new InputView(dictionary);
        PracticeView practiceView = new PracticeView(dictionary);
        
        BorderPane mainLayout = new BorderPane();
        Scene view = new Scene(mainLayout, 400, 300);
        HBox buttonsLayout = new HBox();
        Button enterButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");
        
        buttonsLayout.setPadding(new Insets(20, 20, 20, 20));
        buttonsLayout.setSpacing(10);
        buttonsLayout.getChildren().addAll(enterButton, practiceButton);
        mainLayout.setTop(buttonsLayout);
        
        enterButton.setOnAction((event) -> mainLayout.setCenter(inputView.getView()));
        practiceButton.setOnAction((event) -> mainLayout.setCenter(practiceView.getView()));
        
        mainLayout.setCenter(inputView.getView());
        
        stage.setScene(view);
        stage.show();
    }
}
