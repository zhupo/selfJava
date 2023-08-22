package Collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //1, 使用list
        list();
        //2, 编写equals方法
        equals();
        //3, 使用Map
        MapTest mapTest = new MapTest();
        mapTest.isEquals();
        mapTest.useMap();
        //4, 使用Properties
        properties();
        //5, 使用Set
        SetTest setTest = new SetTest();
        setTest.run();
        setTest.test();
        //6, 使用queue
        QueueTest queueTest = new QueueTest();
        queueTest.run();
        //7, 使用Deque
        DequeTest dequeTest = new DequeTest();
        dequeTest.run();
        //8, 使用Stack
        StackTest stackTest = new StackTest();
        stackTest.run();
    }

    public static void properties() throws IOException {
//        String f = "setting.properties";
//        Properties props = new Properties();
//        props.load(new FileInputStream(f));
//
//        String filePath = props.getProperty("last_open_file");
//        String interval = props.getProperty("auto_save_interval", "120");

        String f = "/Users/pan.liu/Documents/javaProjects/selfJava/learnJava/Collection/setting.properties";
        Properties props = new Properties();
        props.load(new FileInputStream(f));
//        props.load(props.getClass().getResourceAsStream(f));

        String filepath = props.getProperty("last_open_file");
        String interval = props.getProperty("auto_save_interval", "120");
        System.out.println(filepath);
        //写入配置文件
        props.setProperty("url", "http:www.liaoxuefeng.com");
        props.setProperty("language", "Java");
        props.store(new FileOutputStream(f), "这是写入的properties注释");
    }

    public static void list() {
        //List：一种有序列表的集合，例如，按索引排列的Student的List；
        //Set：一种保证没有重复元素的集合，例如，所有无重复名称的Student的Set；
        //Map：一种通过键值（key-value）查找的映射表集合，例如，根据Student的name查找对应Student的Map

        //一，list
        //1, ArrayList
        //在末尾添加一个元素：boolean add(E e)
        //在指定索引添加一个元素：boolean add(int index, E e)
        //删除指定索引的元素：E remove(int index)
        //删除某个元素：boolean remove(Object e)
        //获取指定索引的元素：E get(int index)
        //获取链表大小（包含元素的个数）：int size()
        ArrayList list = new ArrayList();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("apple");
        list1.add("apple1");
        list1.add("pear");
        list1.add("apple");//允许重复，size = 3
        list1.add(null);//允许添加null，size = 4
        list1.remove("apple1");
        list1.remove(1);
        System.out.println(list1.get(2));
        System.out.println(list1.size());

        //1.2 创建list
        List<Integer> list2 = List.of(1,2,5);// 不能传入null值

        //1.3 遍历list
        //不推荐，一是代码复杂，二是因为get(int)方法只有ArrayList的实现是高效的，换成LinkedList后，索引越大，访问速度越慢。
        for (int i=0; i<list1.size(); i++) {
            System.out.println(list1.get(i));
        }

        //1.3.2 Iterator
        List<String> list3 = List.of("a", "b", "c");
        for (Iterator<String> it = list3.iterator(); it.hasNext();) {
            String s = it.next();
            System.out.println(s);
        }

        //1.3.3 for each 循环本身就可以帮我们使用Iterator遍历
        List<String> list4 = List.of("a1", "b1", "c1");
        for (String s1 : list4) {
            System.out.println("for each: " + s1);
        }

        //1.4.1 List to array
        Object[] array = list1.toArray();
        for (Object s : array) {
            System.out.println(s);
        }

        //1.4.2 toArray(T[])
        List<Integer> list5 = List.of(12, 34, 56);
        Integer[] array1 = list5.toArray(new Integer[3]);
        //Number[] array1 = list5.toArray(new Number[3]);
        for (Integer n : array1) {
            System.out.println(n);
        }

        //1.4.3
        Integer[] array2 = list5.toArray(new Integer[]{list5.size()});
        //or
        Integer[] array3 = list5.toArray(Integer[]::new);

        //1.5 Array to List: 只读List
        Integer[] array4 = {1, 2, 3};
        List<Integer> list6 = List.of(array4);
        List<Integer> list7 = Arrays.asList(array4);
        System.out.println(list7.get(1));

        //练习:todo
        final int start = 10;
        final int end = 20;
        List<Integer> list8 = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list8.add(i);
        }
        //随即删除
        int removed = list8.remove((int) (Math.random() * list8.size()));
        int found = findMissingNumber(start, end, list8);
        System.out.println(list8.toString());
        System.out.println("remove number: " + removed);
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }

    public static void equals() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list.contains("C"));
        System.out.println(list.indexOf("C"));
        System.out.println(list.contains(new String("C"))); // true or false?
        System.out.println(list.indexOf(new String("C"))); // 2 or -1?
        List list1 = List.of("A", "b", "c");
        System.out.println(list1.contains("c"));
        System.out.println(list1.indexOf("c"));

        List<TestPerson> list2 = List.of(
                new TestPerson("Xiao Ming", 18),
                new TestPerson("Xiao Hong", 19),
                new TestPerson("Xiao Wang", 20)
        );

        System.out.println(list2.contains(new TestPerson("Xiao Ming", 18)));
        System.out.println(list2.indexOf(new TestPerson("Xiao Wang", 20)));

        //编写Equals
        //自反性（Reflexive）：对于非null的x来说，x.equals(x)必须返回true；
        //对称性（Symmetric）：对于非null的x和y来说，如果x.equals(y)为true，则y.equals(x)也必须为true；
        //传递性（Transitive）：对于非null的x、y和z来说，如果x.equals(y)为true，y.equals(z)也为true，那么x.equals(z)也必须为true；
        //一致性（Consistent）：对于非null的x和y来说，只要x和y状态不变，则x.equals(y)总是一致地返回true或者false；
        //对null的比较：即x.equals(null)永远返回false。
    }

    public static int findMissingNumber(int start, int end, List<Integer> list) {
        int totalSum = (end - start + 1) * (start + end) / 2;
        System.out.println(totalSum);
        int listSum = 0;
        for (Integer i : list) {
            listSum += i;
        }
        System.out.println(listSum);
        return totalSum - listSum;
    }
}
