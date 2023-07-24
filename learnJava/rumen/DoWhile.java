package rumen;

public class DoWhile {
    public static void main(String[] args) {
        int sum = 0;
        int n = 1;
        do {
            sum = sum +n;
            n++;
        } while (n <= 100);
        System.out.println(sum);

        //练习， a 到 b的和

        int sum1 = 0;
        int a = 20;
        int b = 100;
        do {
            sum1 += a;
            a++;
        } while (a <= b);
        System.out.println(sum1);
    }
}
