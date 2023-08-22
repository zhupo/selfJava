package Collection;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class MapTest {
    public void isEquals() {
        List<TestPerson> list = List.of(
                new TestPerson("Bob", 18),
                new TestPerson("Tom", 19),
                new TestPerson("Devin", 20)
        );
        TestPerson target = null;
        for (TestPerson p : list) {
            if ("Bob".equals(p.name)) {
                target = p;
                break;
            }
        }
        System.out.println(target.age);
    }

    public void useMap() {
        //Map中不存在重复的key，因为放入相同的key，只会把原有的key-value对应的value给替换掉。
        //但是value可以重复
        String s = "Xiao Ming";
        TestPerson p = new TestPerson(s, 19);
        HashMap<String, TestPerson> map = new HashMap<>();
        map.put(s, p);
        TestPerson target = map.get(s);
        System.out.println(target == p);
        System.out.println(target.age);
        map.put(s, new TestPerson("Xiao hong", 20));
        System.out.println(map.get(s).name);
        System.out.println(map.get(s).age);

        TestPerson another = map.get("Bob");
        System.out.println(another);

        //遍历Map
        map.put("Bob", new TestPerson("Bob", 18));
        for (String key : map.keySet()) {
            TestPerson t1 = map.get(key);
            System.out.println("map for each name: " + t1.name);
        }

        //会排序的Map, SortedMap接口，实现类TreeMap
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("orange", 1);
        treeMap.put("apple", 2);
        treeMap.put("pear", 3);
        for (String key : treeMap.keySet()) {
            System.out.println(key);
        }

        //Map和List不同的是，Map存储的是key-value的映射关系，并且，它不保证顺序。在遍历的时候，遍历的顺序既不一定是put()时放入的key的顺序，
        // 也不一定是key的排序顺序。使用Map时，任何依赖顺序的逻辑都是不可靠的。以HashMap为例，假设我们放入"A"，"B"，"C"这3个key，遍历的时候，
        // 每个key会保证被遍历一次且仅遍历一次，但顺序完全没有保证，甚至对于不同的JDK版本，相同的代码遍历的输出顺序都是不同的！
    }
}
