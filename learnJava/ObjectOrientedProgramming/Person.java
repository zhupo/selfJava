package ObjectOrientedProgramming;

public class Person {
    public String name;
    public int age;

    private String[] fullName;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    //加上final不允许被继承
//    public final String getName() {
//        return this.name;
//    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("invalid age value");
        }
        this.age = age;
    }

    public String getFullName() {
        return this.fullName[0] + " " + this.fullName[1];
    }

    public void setFullName(String[] name) {
        this.fullName = name;
    }
}
