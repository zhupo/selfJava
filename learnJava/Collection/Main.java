package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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
        list1.add("pear");
        list1.add("apple");//允许重复，size = 3
        list1.add(null);//允许添加null，size = 4
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

        //1.3.3 for each
        List<String> list4 = List.of("a1", "b1", "c1");
        for (String s1 : list4) {
            System.out.println(s1);
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
