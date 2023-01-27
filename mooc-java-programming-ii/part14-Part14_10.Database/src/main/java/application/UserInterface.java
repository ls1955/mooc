package application;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }

            // implement the functionality here
            switch(Integer.valueOf(command)) {
                case 1: {
                    // list the stuff
                    System.out.println("Listing the database contents");
                    List<Todo> toDoLists = this.database.list();
                    
                    toDoLists.forEach( list -> System.out.println(list));
                    break;
                } case 2: {
                    // add the stuff
                    System.out.println("Adding a new todo");
                    System.out.println("Enter name");
                    String name = this.scanner.nextLine();
                    System.out.println("Enter description");
                    String description = this.scanner.nextLine();
                    int id = this.database.list().size() + 1;
                    
                    this.database.add(new Todo(id, name, description, false));
                    break;
                } case 3: {
                    // mark as done
                    System.out.println("Which todo should be marked as done (give the id)?");
                    int id = Integer.valueOf(this.scanner.nextLine());
                    
                    this.database.markAsDone(id);
                    break;
                } case 4: {
                    // remove stuff
                    System.out.println("Which todo should be removed (give the id)?");
                    int id = Integer.valueOf(this.scanner.nextLine());
                    
                    this.database.remove(id);
                    break;
                }
            }
        }

        System.out.println("Thank you!");
    }

}
