
public class MainProgram {

    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        
        // Here you can write code to test that PaymentCard works as intended
        // be sure to erase the extra code for the last part of the exercise!
        PaymentCard paulsCard = new PaymentCard(20.00);
        PaymentCard mattsCard = new PaymentCard(30.00);
        
        paulsCard.eatHeartily();
        mattsCard.eatAffordably();
        
        System.out.println("Paul: " + paulsCard.toString());
        System.out.println("Matt: " + mattsCard.toString());
        
        paulsCard.addMoney(20.00);
        mattsCard.eatHeartily();
        
        System.out.println("Paul: " + paulsCard.toString());
        System.out.println("Matt: " + mattsCard.toString());
        
        paulsCard.eatAffordably();
        paulsCard.eatAffordably();
        mattsCard.addMoney(50.00);
        
        System.out.println("Paul: " + paulsCard.toString());
        System.out.println("Matt: " + mattsCard.toString());
    }
}
