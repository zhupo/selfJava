package core;

public class CoreString {
    public static void main(String[] args) {
        //判断两个字符串相等
        String s = "Hello";
        System.out.println(s);
        s = s.toUpperCase();
        System.out.println(s);

        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        //搜索子串的更多的例子：
        "Hello".contains("ll"); // true

        "Hello".indexOf("l"); // 2
        "Hello".lastIndexOf("l"); // 3
        "Hello".startsWith("He"); // true
        "Hello".endsWith("lo"); // true

        "Hello".substring(2); // "llo"
        "Hello".substring(2, 4); // "ll"
        "  \tHello\r\n ".trim(); // "Hello"
        "\u3000Hello\u3000".strip(); // "Hello"
        " Hello ".stripLeading(); // "Hello "
        " Hello ".stripTrailing(); // " Hello"

        //String还提供了isEmpty()和isBlank()来判断字符串是否为空和空白字符串：
        "".isEmpty(); // true，因为字符串长度为0
        "  ".isEmpty(); // false，因为字符串长度不为0
        "  \n".isBlank(); // true，因为只包含空白字符
        " Hello ".isBlank(); // false，因为包含非空白字符

        //替换字符串
        String s3 = "hello";
        s3.replace('l', 'w'); // "hewwo"，所有字符'l'被替换为'w'
        s3.replace("ll", "~~"); // "he~~o"，所有子串"ll"被替换为"~~"

        //正则表达式替换字符串
        String s4 = "A,,B;C ,D";
        s4.replaceAll("[\\,\\;\\s]+", ","); // "A,B,C,D"

        //分割字符串
        String s5 = "A,B,C,D";
        String[] ss = s5.split("\\,"); // {"A", "B", "C", "D"}
        for (String n : ss) {
            System.out.println(n);
        }

        //拼接字符串
        String[] arr = {"A", "B", "C"};
        String s6 = String.join("***", arr);
        System.out.println(s6);

        //格式化字符串
        String s7 = "Hi %s, your score is %d!";
        System.out.println(s7.formatted("Alice", 80));
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));
        // 有几个占位符，后面就传入几个参数。参数类型要和占位符一致。我们经常用这个方法来格式化信息。常用的占位符有：
        // %s：显示字符串；
        // %d：显示整数；
        // %x：显示十六进制整数；
        // %f：显示浮点数。

        //类型转换
        String.valueOf(123); // "123"
        String.valueOf(45.67); // "45.67"
        String.valueOf(true); // "true"
        String.valueOf(new Object()); // 类似java.lang.Object@636be97c
        //字符串转其他类型
        int n1 = Integer.parseInt("123"); // 123
        int n2 = Integer.parseInt("ff", 16); // 按十六进制转换，255
        boolean b1 = Boolean.parseBoolean("true"); // true
        boolean b2 = Boolean.parseBoolean("FALSE"); // false
        System.out.println(Integer.getInteger("java.version")); // 版本号，11);
        //转换为char[]
        char[] cs = "Hello".toCharArray();
        String s8 = new String(cs);
        System.out.println(s8);
        cs[0] = 'X';
        System.out.println(s8);

        int[] scores = new int[] {88, 77, 51, 66};
        Score score = new Score(scores);
        score.printScores();
        scores[2] = 99;
        score.printScores();
    }
}
