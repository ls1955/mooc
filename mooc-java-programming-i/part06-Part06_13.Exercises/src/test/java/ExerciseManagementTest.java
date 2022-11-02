
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ExerciseManagementTest {
    private ExerciseManagement management;
    
    @Before
    public void initialize(){
        management = new ExerciseManagement();
    }
    
    @Test
    public void exerciseListEmptyAtBeginning(){
        assertEquals(0, management.exerciseList().size());
    }
    
    @Test
    public void addingExerciseGrowsListByOne(){
        management.add("Write a test.");
        assertEquals(1, management.exerciseList().size());
    }
    
    @Test
    public void addingThreeExerciseGrowsListByThree(){
        management.add("Write a test.");
        management.add("Write another test.");
        management.add("Here comes the third test.");
        assertEquals(3, management.exerciseList().size());
    }
    
    @Test
    public void addedExerciseIsInList(){
        management.add("Write a test.");
        assertTrue(management.contains("Write a test."));
    }
    
    @Test 
    public void nonaddedExerciseIsNotInList(){
        management.add("Ooh boy did I love bacon.");
        assertFalse(management.exerciseList().contains("Write a test."));
    }
    
    @Test
    public void exerciseCanBeMarkedAsCompleted(){
        management.add("New exercise");
        management.markAsCompleted("New exercise");
        assertTrue(management.isCompleted("New exercise"));
    }
    
    @Test
    public void ifNotMarkedAsCompletedIsNotCompleted(){
        management.add("New exercise");
        management.markAsCompleted("New exercise");
        assertFalse(management.isCompleted("Mmm I would like some tuna."));
    }
}
