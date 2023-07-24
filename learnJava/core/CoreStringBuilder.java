package core;

public class CoreStringBuilder {
    public static void main(String[] args) {
        //虽然可以直接拼接字符串，但是，在循环中，每次循环都会创建新的字符串对象，然后扔掉旧的字符串。这样，绝大部分字符串都是临时对象，不但浪费内存，还会影响GC效率。
        String s = "";
        for (int i = 0; i <= 1000; i++) {
            s = s + "," + i;
        }
        System.out.println(s);

        //StringBuilder是一个可变对象，往StringBuilder中新增字符时，不会创建新的临时对象：
        StringBuilder sb = new StringBuilder(1024);
        for (int i = 0; i <= 1000; i++) {
            sb.append(',');
            sb.append(i);
        }
        String s1 = sb.toString();
        System.out.println(s1);

        //StringBuilder还可以进行链式操作
        var sb1 = new StringBuilder(1024);
        sb1.append("Mr ")
                .append("Bob")
                .append("!")
                .insert(0, "Hello, ");
        System.out.println(sb1.toString());

        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String insert = buildInsertSql(table, fields);
        String sql = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";;
        System.out.println(insert);
        System.out.println(sql.equals(insert) ? "测试成功" : "测试失败");
    }

    public static String buildInsertSql(String table, String[] fields) {
        String[] values = {"?", "?", "?"};
        var sb = new StringBuilder(1024);
        sb.append("INSERT INTO ")
                .append(table)
                .append(" ")
                .append("(")
                .append(String.join(", ", fields))
                .append(") ")
                .append("VALUES ")
                .append("(")
                .append(String.join(", ", values))
                .append(")");
        return sb.toString();
    }
}
