
public class Statistics {
    private int count;
    private int sum;
    
    public Statistics(){
        this.count = 0;
        this.sum = 0;
    }
    
    public void addNumber(int num){
        this.sum += num;
        this.count++;
    }
    
    public int getCount(){
        return this.count;
    }
    
    public int sum(){
        return this.sum;
    }
    
    public double average(){
        if(this.count == 0){
            return 0;
        }
        
        double average = (1.0 * this.sum) / this.count;
        return average;
    }
}
