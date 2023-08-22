package Collection;

import java.util.Objects;

public class TestPerson {
    public String name;
    public int age;

    public TestPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean equals(Object o) {
        //遇到null值会报错
//        if (o instanceof TestPerson p) {
//            return this.name.equals(p.name) && this.age == p.age;
//        }

        //写法复杂不推荐
//        if (o instanceof  TestPerson p) {
//            boolean nameEquals = false;
//            if (this.name == null && p.name == null) {
//                nameEquals = true;
//            }
//            if (this.name != null) {
//                nameEquals = this.name.equals(p.name);
//            }
//
//            return nameEquals && this.age == p.age;
//        }

        //推荐写法
        if (o instanceof TestPerson p) {
            return Objects.equals(this.name, p.name) && this.age == p.age;
        }

        return false;
        //先确定实例“相等”的逻辑，即哪些字段相等，就认为实例相等；
        //用instanceof判断传入的待比较的Object是不是当前类型，如果是，继续比较，否则，返回false；
        //对引用类型用Objects.equals()比较，对基本类型直接用==比较。
    }
}
