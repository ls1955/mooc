package validating;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age)  {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name should not be empty.");
        } else if (name.length() > 40) {
            throw new IllegalArgumentException("Name is too long.");
        } else if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Invalid age.");
        }

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
