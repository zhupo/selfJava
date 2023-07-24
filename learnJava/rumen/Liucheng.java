package rumen;

import java.util.Scanner;

public class Liucheng {
    public static void main(String[] args) {
        double d = 3.1415926;
        System.out.printf("%.2f\n", d); // 显示两位小数3.14
        System.out.printf("%.4f\n", d); // 显示4位小数3.1416
        int i = 3;
        System.out.printf("%d\n", i); // 显示4位小数3.1416

//        %d	格式化输出整数
//        %x	格式化输出十六进制整数
//        %f	格式化输出浮点数
//        %e	格式化输出科学计数法表示的浮点数
//        %s	格式化字符串
        int n = 12345000;
        System.out.printf("n=%d, hex=%08x", n, n); // 注意，两个%占位符必须传入两个数

//        Scanner scanner = new Scanner(System.in); // 创建Scanner对象
//        System.out.print("Input your name: "); // 打印提示
//        String name = scanner.nextLine(); // 读取一行输入并获取字符串
//        System.out.print("Input your age: "); // 打印提示
//        int age = scanner.nextInt(); // 读取一行输入并获取整数
//        System.out.printf("Hi, %s, you are %d\n", name, age);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input you first score: ");
        int score1 = scanner.nextInt();
        System.out.print("Input you next score: ");
        int score2 = scanner.nextInt();
        int addScore = score2 - score1;
        double addRatio = ((double) addScore / (double) score1) * 100;
        System.out.println(addScore);
        System.out.println(addRatio);

        System.out.printf("第一次成绩： %d, 第二次成绩： %d, 增加比例: %.2f%%", score1, score2, addRatio);

    }
}
