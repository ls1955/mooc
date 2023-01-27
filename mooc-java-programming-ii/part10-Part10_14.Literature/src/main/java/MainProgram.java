
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        Comparator<Book> bookComparator = Comparator.comparing(Book::getAgeRecommendation)
                                                    .thenComparing(Book::getName);
        
        while(true){
            System.out.println("Input the name of the book, empty stops: ");
            String name = scanner.nextLine();
            
            if(name.isEmpty())
                break;
            
            System.out.println("Input the age recommendation: ");
            int ageRecommendation = Integer.valueOf(scanner.nextLine());
            
            books.add(new Book(name, ageRecommendation));
        }

        Collections.sort(books, bookComparator);
        
        System.out.println(books.size() + " books in total.");
        System.out.println("");
        System.out.println("Books:");
        for(Book book: books){
            System.out.println(book.getName() + " (recommended for " + book.getAgeRecommendation() + " year-olds or older)");
        }
    }

}
