
import java.util.ArrayList;

public class ExerciseManagement {
    private ArrayList<Exercise> exercises;

    public ExerciseManagement(){
        this.exercises = new ArrayList<Exercise>();
    }
    
    public ArrayList<Exercise> exerciseList(){
        return this.exercises;
    }
    
    public void add(String exercise){
        this.exercises.add(new Exercise(exercise));
    }
    
    public boolean contains(String exercise){
        for(Exercise exer: this.exercises){
            if(exer.getName().equals(exercise)) return true;
        }
        
        return false;
    }
    
    public void markAsCompleted(String exercise){
        for(Exercise exer: this.exercises){
            if(exer.getName().equals(exercise)){
                exer.setCompleted();
            }
        }
    }
    
    public boolean isCompleted(String exercise){
        for(Exercise exer: this.exercises){
            if(exer.getName().equals(exercise)){
                return exer.isCompleted();
            }
        }
        
        return false;
    }
}
