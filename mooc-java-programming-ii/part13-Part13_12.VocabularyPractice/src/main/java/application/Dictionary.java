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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Dictionary {
    private ArrayList<String> words;
    private HashMap<String, String> translations;
    
    public Dictionary() {
        this.words = new ArrayList<>();
        this.translations = new HashMap<>();
    }
    
    public String getTranslation(String word) {
        return this.translations.get(word);
    }
    
    public void addWordAndTranslation(String word, String translation) {
        if (!this.translations.containsKey(word)) {
            this.words.add(word);
        }
        
        this.translations.put(word, translation);
    }
    
    public String getRandomWord() {
        Random random = new Random();
        
        return this.words.get(random.nextInt(this.words.size()));
    }
}
