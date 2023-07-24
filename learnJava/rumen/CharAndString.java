package rumen;

public class CharAndString {
    public static void main(String[] args) {
        //字符类型char是基本数据类型
        char c1 = 'A';
        char c2 = '中';
        System.out.println(c1);

        //Unicode编码
        int n1 = 'A';
        int n2 = '中';
        System.out.println(n1);

        // 注意是十六进制:
        char c3 = '\u0041'; // 'A'，因为十六进制0041 = 十进制65
        char c4 = '\u4e2d'; // '中'，因为十六进制4e2d = 十进制20013
        System.out.println(c1);


        //字符串类型String是引用类型
        String s = ""; // 空字符串，包含0个字符
        String s1 = "A"; // 包含一个字符
        String s2 = "ABC"; // 包含3个字符
        String s3 = "中文 ABC"; // 包含6个字符，其中有一个空格

        //转义字符\
        String s4 = "abc\"xyz";
        String s5 = "abc\\xyz";
        System.out.println(s4);

//        \" 表示字符"
//        \' 表示字符'
//        \\ 表示字符\
//        \n 表示换行符
//        \r 表示回车符
//        \t 表示Tab

        //字符串拼接
        String ss1 = "Hello ";
        String ss2 = "world";
        System.out.println(ss1 + ss2);

        //如果用+连接字符串和其他数据类型，会将其他数据类型先自动转型为字符串，再连接：
        int age2 = 25;
        String ss3 = "age is " + age2;
        System.out.println(ss3);


//        String ss = """
//                   SELECT * FROM
//                     users
//                   WHERE id > 100
//                   ORDER BY name DESC
//                   """;
//        System.out.println(ss);

//        Java的字符串除了是一个引用类型外，还有个重要特点，就是字符串不可变

        String s11 = "hello";
        String t = s11;
        s11 = "world";
        System.out.println(t); // t是"hello"还是"world"?
        System.out.println(s11 + "s11");

        int a = 72;
        int b = 105;
        int c = 65281;
        String s12 = String.format("%c%c%c", a, b, c);
        System.out.println(s12);

    }
}
