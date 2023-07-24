package ObjectOrientedProgramming;

public class Override extends Person {
    public Override(String name, int age) {
        super(name, age);
    }

    public static void main(String[] args) {
        Override override = new Override("张三", 18);
        System.out.println(override.getName("方法名一样参数或返回值不一样就是重构重构overload"));
    }

//    @java.lang.Override //Compile error!
    public String getName(String s) {
        System.out.println("Hello Override!");
        System.out.println(s);
        System.out.println(super.getName() + "!"); //子类调用父类的方法
        return this.name;
    }
}
