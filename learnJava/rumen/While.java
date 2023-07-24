package rumen;

public class While {
    public static void main (String[] args) {
        int sum = 0;
        int n = 0;
        while (n <= 19) {
            sum = sum + n;
            n ++;
        }
        System.out.println(sum);

        //练习 使用while 计算从a 到b的和：
        int sum1 = 0;
        int a = 20;
        int b = 100;

        while (a <= b) {
            sum1 += a;
            a++;
        }

        System.out.println(sum1);
    }
}
