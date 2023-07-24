package ObjectOrientedProgramming;

public class ConstructPerson {
    private String name;
    private int age;

    public ConstructPerson() {

    }

    //多构造方法
    public ConstructPerson(String name) {
        this.name = name;
    }

    public ConstructPerson(String name, int age) {
        //构造方法可以调用其他构造方法语法this(...参数)
        this(name);
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
