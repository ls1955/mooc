
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        // Implement the random number generation here
        for (int i = 0; i < 7; i++) {
            int randomNumber = new Random().nextInt(40) + 1;
            
            // the method containsNumber is probably useful
            if (containsNumber(randomNumber)) i--;
            else numbers.add(randomNumber);
        }
    }

    public boolean containsNumber(int number) {
        // Check here whether the number is among the drawn numbers
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == number) return true;
        }
        return false;
    }
}

