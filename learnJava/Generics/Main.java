package Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //1, 泛型就是定义一种模板，例如ArrayList<T>，然后在代码中为用到的类创建对应的ArrayList<类型>：
        ArrayList<String> strList = new ArrayList<String>();
        ArrayList<Float> floatList = new ArrayList<Float>();

        strList.add("hello");
        System.out.println(strList.get(0));

        //2, 使用泛型
        List<String> list = new ArrayList();
        list.add("Hello");
        list.add("world");
        String first = list.get(0);
        String second = list.get(1);
        System.out.println(first);

        List<Number> list1 = new ArrayList<Number>();
        //可以简写
        List<Number> list2 = new ArrayList<>();
        list1.add(Integer.valueOf(123));
        list1.add(Double.valueOf(12.34));
        System.out.println(list1.get(0));
        System.out.println(list1.get(1));

        //3, 泛型接口
        String[] ss = new String[] { "Orange", "Apple", "Pear"};
        Arrays.sort(ss);
        System.out.println(Arrays.toString(ss));

        Person[] ps = new Person[] {
            new Person("Bob", 61),
            new Person("Alice", 88),
            new Person("Lily", 75),
        };
        Arrays.sort(ps);
        System.out.println(Arrays.toString(ps));

        //4, 编写泛型
        //4.1, 单个泛型类型
        Pair<String> pair = new Pair<>("san", "zhang");
        Pair<Integer> pair1 = new Pair<>(1, 2);
        System.out.println(pair.getFirst());
        System.out.println(pair1.getFirst());

        //4.2, 多个泛型类型
        ManyPair manyPair = new ManyPair("test", 123);
        System.out.println(manyPair.getFirst());
        System.out.println(manyPair.getLast());

        //5, extends
        //泛型定义称之为上界通配符（Upper Bounds Wildcards）
        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);

//        Pair<Double> p2 = new Pair<>(1.12, 1.48);
//        Double n2 = add(p2);
//        System.out.println(n2);

        //5.1 使用extends限定T类型
        ExtendsPair<Number> p01 = null;
        ExtendsPair<Integer> p02 = new ExtendsPair<>();
        ExtendsPair<Double> p03 = new ExtendsPair<>();

        //6, super通配符
        Pair<Number> p1 = new Pair<>(12.3, 4.56);
        Pair<Integer> p2 = new Pair<>(123, 456);
        setName(p1, 100);
        setName(p2, 200);
        Object obj = p1.getFirst();
        System.out.println(p1.getFirst() + " " + p1.getLast());
        System.out.println(p2.getFirst() + " " + p2.getLast());

        //PECS原则：Producer Extends Consumer Super
        //即：如果需要返回T，它是生产者（Producer），要使用extends通配符；如果需要写入T，它是消费者（Consumer），要使用super通配符。
        //public class Collections {
        //    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        //        for (int i=0; i<src.size(); i++) {
        //            T t = src.get(i); // src是producer
        //            dest.add(t); // dest是consumer
        //        }
        //    }
        //}

        //7, Pair<?> p无限定通配符: 既不可写，也不可读，只能做null的判断
        Pair<Integer> p3 = new Pair<>(123, 456);
        Pair<?> p4 = p3;
        System.out.println(p4.getFirst() + " " + p4.getLast());

        Pair<String>[] ps1 = null;
        @SuppressWarnings("unchecked")
        Pair<String>[] ps2 = (Pair<String>[]) new Pair[2];
        ps2[0] = new Pair<>("san", "zhang");
        System.out.println(ps2[0].getFirst() + " " + ps2[0].getLast());
    }

    public boolean isNull(Pair<?> p) {
        return p.getFirst() == null || p.getLast() == null;
    }

    public <T> boolean isNullTwo(Pair<T> p) {
        return p.getFirst() == null || p.getLast() == null;
    }

    //<? extends Number>通配符的一个重要限制：方法参数签名setFirst(? extends Number)无法传递任何Number的子类型给setFirst(? extends Number) 只读不写
    public static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        //p.setFirst(new Integer(first.intValue() + 100));
        return first.intValue() + last.intValue();
    }

    //Pair<? super Integer> super通配符；接受所有泛型类型为Integer或Integer父类的Pair类型 只写不读
    public static void setName(Pair<? super Integer> p, Integer n) {
        p.setFirst(n);
        //Integer x = p.getFirst(); //不允许，因为不知道实际类型
        p.setLast(n);
    }
}
