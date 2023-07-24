package rumen;

public class Variable {
    public static void main(String[] args) {

        //变量*
		int x = 100; // 定义int类型变量x，并赋予初始值100
		x = 200;
		System.out.println(x); // 打印该变量的值


		int n = 100; // 定义变量n，同时赋值为100
		System.out.println("n = " + n); // 打印n的值

		n = 200; // 变量n赋值为200
		System.out.println("n = " + n); // 打印n的值

		x = n; // 变量x赋值为n（n的值为200，因此赋值后x的值也是200）
		System.out.println("x = " + x); // 打印x的值

		x = x + 100; // 变量x赋值为x+100（x的值为200，因此赋值后x的值是200+100=300）
		System.out.println("x = " + x); // 打印x的值
		System.out.println("n = " + n); // 再次打印n的值，n应该是200还是300？

		//char类型
        char a = 'A';
        char zh = '中';
        System.out.println(a);
        System.out.println(zh);

		int ab = 100;
		int ba = 100 + (++ab);
		System.out.println(ba);

		if (ab < ba && ba > ab) {
			System.out.println(ba);
		}

        //练习自然数之和
		n = 100;
		int sum = (1 + n) * n / 2;

		System.out.println(sum);

		System.out.println(sum == 5050 ? "测试通过" : "测试失败");

        double xx = 1.0 / 10;
        double y = 1 - 9.0 / 10;
        // 观察x和y
        System.out.println(xx);
        System.out.println(y);
    }
}
