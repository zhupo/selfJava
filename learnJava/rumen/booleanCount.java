package rumen;

public class booleanCount {
    public static void main(String[] args) {
        boolean isGreater = 5 > 3;
        int age = 12;
        boolean isZero = age == 0; // false
        boolean isNonZero = !isZero; // true
        boolean isAdult = age >= 18; // false
        boolean isTeenager = age >6 && age <18; // true
        System.out.println(isGreater);

        //关系运算符的优先级从高到低依次是：
        //!
        // >, >=, <, <=
        // ==, !=
        // &&
        // ||

        //短路运算
        boolean  b = 5 < 3;
        boolean result = b && (5 / 0 > 0);
        System.out.println(result);

        //三元运算符
        int n = -100;
        int x = n >= 0 ? n : -n;
        System.out.println(x);

        //练习
        int age1 = 7;
        boolean  isPrimaryStudent = age1 >= 6 && age <= 12;
        System.out.println(isPrimaryStudent);
    }
}
