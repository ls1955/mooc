/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cheong
 */
import java.util.Scanner;

public class TextUI {

    private Scanner scanner;
    private SimpleDictionary dictionary;

    public TextUI(Scanner scanner, SimpleDictionary dictionary) {
        this.scanner = scanner;
        this.dictionary = dictionary;
    }

    public void start() {
        while (true) {
            String input = this.scanner.nextLine();
            if (input.equals("end")) {
                this.end();
                break;
            }

            this.processInput(input);
        }
    }

    private void processInput(String input) {
        if (input.equals("add")) {
            this.add();
        }else if (input.equals("search")) {
            this.search();
        }else{
            System.out.println("Unknown command");
        }
    }

    private void add() {
        System.out.println("Word: ");
        String word = this.scanner.nextLine();
        System.out.println("Translation: ");
        String translation = this.scanner.nextLine();

        this.dictionary.add(word, translation);
    }

    private void search() {
        System.out.println("To be translated: ");
        String word = this.scanner.nextLine();

        String translation = this.dictionary.translate(word);
        if (translation == null) {
            System.out.println("Word " + word + " was not found");
        } else {
            System.out.println("Translation: " + translation);
        }
    }

    private void end() {
        System.out.println("Bye bye!");
    }
}
