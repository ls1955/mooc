
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros = euros + cents / 100;
            cents = cents % 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public Money plus(Money addition){
        int latestEuros = this.euros() + addition.euros();
        int latestCents = this.cents() + addition.cents();
        
        Money newMoney = new Money(latestEuros, latestCents);
        return newMoney;
    }
    
    public Money minus(Money decreaser){
        int latestEuros = this.euros() - decreaser.euros();
        int latestCents = this.cents() - decreaser.cents();
        
        if(latestEuros < 0){
            latestEuros = 0;
            latestCents = 0;
        }else if(latestCents < 0 && latestEuros >= 1){
            latestEuros--;
            latestCents += 100;
        }
        
        Money newMoney = new Money(latestEuros, latestCents);
        return newMoney;
    }
    
    public boolean lessThan(Money compared){
        if(this.euros() < compared.euros()) return true;
        else if(this.euros() == compared.euros()){
            if(this.cents() < compared.cents()) return true;
            else return false;
        }else{
            return false;
        }
    }
    
    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }

    public String toString() {
        String zero = "";
        if (this.cents < 10) {
            zero = "0";
        }

        return this.euros + "." + zero + this.cents + "e";
    }

}
