package core;

import java.util.StringJoiner;

public class CoreStringJoiner {
    public static void main(String[] args) {
        String[] names = {"Bob", "Alice", "Grace"};
        var sj = new StringJoiner(", ", "Hello ", "!");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());

        //在不需要指定“开头”和“结尾”的时候，用String.join()更方便：
        var s = String.join(", ", names);
        System.out.println(s);

        String[] fields = {"name", "position", "salary"};
        String table = "employee";
        String select = buildSelectSql(table, fields);
        System.out.println(select);
        System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");
    }

    static String buildSelectSql(String table, String[] fields) {
        var sj = new StringJoiner(", ", "SELECT ", " FROM employee");
        for (String field : fields) {
            sj.add(field);
        }

        return sj.toString();
    }
}
