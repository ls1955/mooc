/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cheong
 */

import java.util.ArrayList;

public class Statistics {
    private ArrayList<Integer> statistics;
    private Grades grades;
    
    public Statistics(){
        this.statistics = new ArrayList<>();
        this.grades = new Grades();
    }
    
    public void add(int point){
        this.statistics.add(point);
        
        if(point < 50) this.grades.addGradeAt(0);
        else if(point < 60) this.grades.addGradeAt(1);
        else if(point < 70) this.grades.addGradeAt(2);
        else if(point < 80) this.grades.addGradeAt(3);
        else if(point < 90) this.grades.addGradeAt(4);
        else this.grades.addGradeAt(5);
    }
    
    public double average(){
        return (1.0 * this.sum()) / this.size();
    }
    
    public int sum(){
        int sum = 0;
        
        for(Integer point: this.statistics){
            sum += point;
        }
        
        return sum;
    }
    
    public int size(){
        return this.statistics.size();
    }
    
    public void printGrade(){
        this.grades.printGrades();
    }
}
