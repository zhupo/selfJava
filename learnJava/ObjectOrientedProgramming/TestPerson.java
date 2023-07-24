package ObjectOrientedProgramming;

public class TestPerson {
    public static void main(String[] args) {
//        Person ming = new Person();
//        ming.name = "xiaohong";
//        ming.age = 26;
//        System.out.println(ming.name);
//        System.out.println(ming.age);
//
//        Person hong = new Person();
//        hong.setName("xiaohong");
//        int age = 18;
//        hong.setAge(age);
//        age = 20;
//        System.out.println(hong.getName());
//        System.out.println(hong.getAge());
//
//        //引用类型改变，对象也是引用类型，会跟着改变
//        Person p = new Person();
//        String[] fullName = new String[] {"san", "zhang"};
//        p.setFullName(fullName);
//        System.out.println(p.getFullName());
//        fullName[0] = "si";
//        System.out.println(p.getFullName());
//
//        Person p1 = new Person();
//        String bob = "Bob";
//        p.setName(bob);
//        System.out.println(p.getName());
//        bob = "Alice";
//        System.out.println(p.getName());

        Extend student  = new Extend("张三", 18, 100);
        System.out.println(student.getScore());
        System.out.println(student.hello());

        //向上转型
        Person p = new Extend("李四", 20, 95);
        System.out.println(p.name);

        //向下转型
        if (student instanceof Extend) {
            Extend s = (Extend) student;
            System.out.println(s.name);
        }

        //Abstract
        AbstractExtends testAbstract = new AbstractExtends();
        testAbstract.run();
    }
}


// java 15开始 允许使用sealed 修饰class, 并通过permits 明确写出能够从该class 继承的子类名称, 如下就允许 Rect, Circle, Triangle 三个类名继承
//public sealed class Shape permits Rect, Circle, Triangle {
//    ...
//}

//ok
//public final class Rect extends Shape {...}
