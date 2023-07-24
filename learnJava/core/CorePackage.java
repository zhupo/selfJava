package core;

public class CorePackage {
    public static void main(String[] args) {
        int i = 99999;
        //不推荐使用
//        Integer n1 = new Integer(i);
        Integer n2 = Integer.valueOf(i);
        Integer n3 = Integer.valueOf("100");

        System.out.println(n3.intValue());

        // 这种直接把int变为Integer的赋值写法，称为自动装箱（Auto Boxing)
        Integer n = 99999; // 编译器自动使用Integer.valueOf(int)
        int x = n; // 编译器自动使用Integer.intValue()
        System.out.println(x);

        // 因为Integer是引用类型，必须使用equals()比较
        System.out.println("x.equals(n): " + (n==n2)); // true
        System.out.println("x.equals(n): " + n.equals(n2)); // true

        //进制转换
        int x1 = Integer.parseInt("100"); // 100
        int x2 = Integer.parseInt("100", 16); // 256,因为按16进制解析
        System.out.println(x1);
        System.out.println(x2);
    }
}
