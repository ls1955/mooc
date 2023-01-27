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

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PracticeView {
    private Dictionary dictionary;
    private String word;

    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = dictionary.getRandomWord();
    }
    
    public Parent getView() {
        GridPane mainLayout = new GridPane();
        Label instruction = new Label("Translate this word '" + word + "'");
        TextField translationTextField = new TextField();
        Button checkButton = new Button("Check");
        Label feedBack = new Label("");
        
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setVgap(10);
        mainLayout.setHgap(10);
        mainLayout.setPadding(new Insets(20, 20, 20, 20));
        mainLayout.add(instruction, 0, 0);
        mainLayout.add(translationTextField, 0, 1);
        mainLayout.add(checkButton, 0, 2);
        mainLayout.add(feedBack, 0, 3);
        
        checkButton.setOnMouseClicked((event) -> {
            String translation = translationTextField.getText();
            
            if (dictionary.getTranslation(word).equals(translation)) {
                feedBack.setText("Correct!");
            } else {
                feedBack.setText("Incorrect! The translation of the word '" + word + "' is " + dictionary.getTranslation(word));
                
                return;
            }
            
            word = dictionary.getRandomWord();
            instruction.setText("Translate the word '" + word + "'");
            translationTextField.clear();
        });
        
        return mainLayout;
    }
}
