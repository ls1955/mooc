/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cheong
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Employees {

    private ArrayList<Person> persons;

    public Employees() {
        this.persons = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        this.persons.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        for (Person person : peopleToAdd) {
            this.persons.add(person);
        }
    }

    public void print() {
        Iterator<Person> iterator = this.persons.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void print(Education education) {
        Iterator<Person> iterator = this.persons.iterator();

        while (iterator.hasNext()) {
            Person currPerson = iterator.next();

            if (currPerson.getEducation() == education) {
                System.out.println(currPerson);
            }
        }
    }

    public void fire(Education education) {
        Iterator<Person> iterator = this.persons.iterator();

        while (iterator.hasNext()) {
            Person currPerson = iterator.next();

            if (currPerson.getEducation() == education) {
                iterator.remove();
            }
        }
    }
}
