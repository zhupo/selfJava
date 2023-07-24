package reflection;

public class TestPerson {
    public String name;

    private int age;

    public TestPerson (int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("Person:hello");
    }
}
