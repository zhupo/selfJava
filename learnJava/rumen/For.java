package rumen;

public class For {
    public static void main(String[] args) {
        int sum = 0;
        for (int i=1; i<=100000000; i++) {
            sum = sum +i;
        }
        System.out.println(sum);


        int[] ns = { 1, 4, 9, 16, 25 };
        int sum1 = 0;
        for (int i=0; i<ns.length; i++) {
            System.out.println("i = " + i + ", ns[i] = " + ns[i]);
            sum1 = sum1 + ns[i];
        }
        System.out.println("sum = " + sum1);

        //for each
        int[] n = {1, 4, 9, 16, 25};
        for (int a : n) {
            System.out.println(a);
        }


        //练习1 给定一个数组，请用for循环倒序输出每一个元素：
        int[] ns1 = { 22, 4, 9, 16, 25 };
        int nsLength = ns1.length;
        for (int i=0; i < nsLength; i++) {
            System.out.println(ns1[i]);
        }

        //练习2 利用for each循环对数组每个元素求和：
        int[] xx = {1, 2, 3, 4, 5};
        int ss = 0;
        for (int b : xx) {
            ss += b;
        }
        System.out.println(ss);

        //练习3 利用for循环计算圆周率

        double pi = 0;
        int falg = 0;
        System.out.println(1 % 2);

        for (int i=0; i < 2000000000; i=i+2) {
            if (falg % 2 == 0) {
                pi += (4.0 / (i + 1));
            } else {
                pi -= (4.0 / (i + 1));
            }
            falg ++;
        }
        System.out.println(pi);


        double pi1 = 0;

        for (double i = 1; i <= 2000000000; i+=4) {
            pi1 += 4.0/i;
            pi1 -= 4.0/(i + 2);
        }

        System.out.println(pi1);
    }
}
