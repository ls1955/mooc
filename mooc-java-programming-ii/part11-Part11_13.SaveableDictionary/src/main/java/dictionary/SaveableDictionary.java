/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author cheong
 */

import java.io.PrintWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class SaveableDictionary {
    private Hashtable<String, String> translations;
    private String file;

    public SaveableDictionary() {
        this.translations = new Hashtable<>();
    }
    
    public SaveableDictionary(String file) {
        this();
        this.file = file;
    }
    
    public boolean load() {
        try (Scanner fileReader = new Scanner(Paths.get(file))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] lineParts = line.split(":");
                
                translations.put(lineParts[0], lineParts[1]);
            }
            
            return true;
        } catch (Exception e) {
            System.out.println("File do not exist");
            
            return false;
        }
    }
    
    public boolean save() {
        try (PrintWriter printWriter = new PrintWriter(file)) {
            for (String key : translations.keySet()) {
                printWriter.println(key + ":" + translations.get(key));
            }
            
            printWriter.close();
            
            return true;
        } catch (Exception e) {
            System.out.println("File does not exist");
            
            return false;
        }
    }
    
    public void add(String words, String translation) {
        if (translations.containsKey(words)) return;
        
        translations.put(words, translation);
    }
    
    public void delete(String word) {
         translations.keySet().removeIf( key -> key.equals(word) || translations.get(key).equals(word));
    }
    
    public String translate(String word) {
        for (String key : translations.keySet()) {
            if (key.equals(word)) {
                return translations.get(key);
            } else if (translations.get(key).equals(word)) {
                return key;
            }
        }
        
        return null;
    }
}
