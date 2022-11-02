
import java.util.ArrayList;

public class Menu {

    private ArrayList<String> meals;

    public Menu() {
        this.meals = new ArrayList<>();
    }

    // implement the required methods here
    public void addMeal(String meal){
        if(this.getMeals().contains(meal)) return;
        
        this.getMeals().add(meal);
    }
    
    public void printMeals(){
        for(String meal: this.meals){
            System.out.println(meal);
        }
    }
    
    public void clearMenu(){
        this.getMeals().clear();
    }
    
    public ArrayList getMeals(){
        return this.meals;
    }
}
