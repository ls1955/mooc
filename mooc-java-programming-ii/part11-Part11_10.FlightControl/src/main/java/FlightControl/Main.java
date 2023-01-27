package FlightControl;

import FlightControl.ui.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextUI ui = new TextUI(scanner);
        
        ui.start();
    }
}
