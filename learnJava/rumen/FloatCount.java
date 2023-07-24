package rumen;

public class FloatCount {
    public static void main(String[] args) {
        double x = 1.0 / 10;
        double y = 1 - 9.0 / 10;
        System.out.println(x);
        System.out.println(y);

        //类型提升
        int n = 5;
        double d = 1.2 + 24.0 / n; // 6.0
        System.out.println(d);

        //在复杂的四则运算中，整数的运算不会提升类型
        double d0 = 1.2 + 24 / 5;
        System.out.println(d0);

        //除0溢出
        double d1 = 0.0 / 0; // NaN
        double d2 = 1.0 / 0; // Infinity
        double d3 = -1.0 / 0; // -Infinity
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);

        //强制转型
        int n1 = (int) 12.3;
        System.out.println(n1);


        double dx = 2.6;
        int nx = (int) (dx + 0.5);
        System.out.println(nx);

        //练习：计算出一元二次方程的两个解：
        double a = 1.0;
        double b = 3.0;
        double c = -4.0;
        //求平方根可用 Math.sqrt();
        double r1 = 0;
        double r2 = 0;
        r1 = (-b + Math.sqrt(b * b - 4 * a * c)) / 2 * a;
        r2 = (-b - Math.sqrt(b * b - 4 * a * c)) / 2 * a;

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r1 == 1 && r2 == -4 ? "Success" : "error");
    }

    //小结：
    /*浮点数常常无法精确表示，并且浮点数的运算结果可能有误差；

    比较两个浮点数通常比较它们的差的绝对值是否小于一个特定值；

    整型和浮点型运算时，整型会自动提升为浮点型；

    可以将浮点型强制转为整型，但超出范围后将始终返回整型的最大值。*/
}
