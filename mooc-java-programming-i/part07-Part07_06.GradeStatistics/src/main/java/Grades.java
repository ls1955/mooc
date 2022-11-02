/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cheong
 */
public class Grades {
    private int[] grades;
    
    public Grades(){
        this.grades = new int[6];
    }
    
    public void addGradeAt(int index){
        this.grades[index]++;
    }
    
    public void printGrades(){
        for(int i=5; i>=0; i--){
            System.out.print(i + ": ");
            
            while(this.grades[i] > 0){
                System.out.print("*");
                this.grades[i]--;
            }
            
            System.out.println("");
        }
    }
}
