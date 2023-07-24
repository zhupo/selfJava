package rumen;

import Generics.Person;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        //注意，数组是引用类型
        int[] ns = new int[5];
        ns[0] = 1;
        System.out.println(Arrays.toString(ns));
        System.out.println(ns.length);
//        int len = ns.length;
//        System.out.println(ns[len]);

        int[] ns2 = new int[] {1, 2, 3, 3, 5};
        int[] ns3 = {1, 2, 3, 3, 5};
        System.out.println(ns2.length);
        System.out.println(ns3.length);

        String[] names = {"张三", "李四", "王老五"};
        System.out.println(names[0]);

        //引用类型例子
        String[] attributes = {"张三", "李四", "王老五"};
        String s = attributes[1];
        attributes[1] = "cat";
        System.out.println(s);
        System.out.print(s);

        double d = 12900000;
        System.out.println(d); // 1.29E7

        Person[] arr = new Person[2];
    }
}
