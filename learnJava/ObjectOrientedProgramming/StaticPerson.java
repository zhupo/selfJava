package ObjectOrientedProgramming;

public class StaticPerson {
    public String name;
    public int age;

    public static int number = 100;

    public StaticPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void setNumber(int value) {
        number = value;
    }
}
