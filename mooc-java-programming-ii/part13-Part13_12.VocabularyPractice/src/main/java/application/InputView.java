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

public class InputView {
    private Dictionary dictionary;

    public InputView(Dictionary dictionary) {
        this.dictionary = dictionary;
    }
    
    public Parent getView() {
        GridPane mainLayout = new GridPane();
        Label wordPrompt = new Label("Word");
        TextField wordTextField = new TextField();
        Label translationPrompt = new Label("Translation");
        TextField translationTextField = new TextField();
        Button addButton = new Button("Add the word pair");
        
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setVgap(10);
        mainLayout.setHgap(10);
        mainLayout.setPadding(new Insets(20, 20, 20, 20));
        mainLayout.add(wordPrompt, 0, 0);
        mainLayout.add(wordTextField, 0, 1);
        mainLayout.add(translationPrompt, 0, 2);
        mainLayout.add(translationTextField, 0, 3);
        mainLayout.add(addButton, 0, 4);
        
        addButton.setOnAction((event) -> {
            String word = wordTextField.getText();
            String translation = translationTextField.getText();
            
            if (word.equals("") || translation.equals("")) {
                System.out.println("The word / translation should not be empty.");
                
                return;
            }
            
            dictionary.addWordAndTranslation(word, translation);
            
            wordTextField.clear();
            translationTextField.clear();
        });
        
        return mainLayout;
    }
}
