package Collection;

import java.util.*;

public class SetTest {
    public void run() {
        HashSet<String> set = new HashSet<>();
        System.out.println(set.add("abc"));
        System.out.println(set.add("xyz"));
        System.out.println(set.add("xyz"));
        System.out.println(set.contains("xyz"));
        System.out.println(set.contains("XYZ"));
        System.out.println(set.remove("hello"));
        System.out.println(set.size());

        HashSet<String> set1 = new HashSet<>();
        set1.add("apple");
        set1.add("banana");
        set1.add("pear");
        set1.add("orange");
        for (String s : set1) {
            System.out.println(s);
        }

        //可以排序的SET, TreeSet继承SortedSet
        TreeSet<String> set2 = new TreeSet<>();
        set2.add("apple");
        set2.add("banana");
        set2.add("pear");
        set2.add("orange");
        for (String s : set2) {
            System.out.println(s);
        }
    }

    public void test() {
        List<Message> received = List.of(
                new Message(1, "Hello!"),
                new Message(2, "发工资了吗？"),
                new Message(2, "发工资了吗？"),
                new Message(3, "去哪吃饭？"),
                new Message(3, "去哪吃饭？"),
                new Message(4, "Bye")
        );
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }

    private List<Message> process(List<Message> received) {
        ArrayList<Message> re = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if (o1 == o2) {
                            return 0;
                        }
                        return o1 - o2;
                    }
                }
        );
        for (Message m : received) {
            if (set.add(m.sequence)) {
                re.add(m);
            }
        }

        //TODO: 按照sequence去除重复消息
        return re;
    }
}
