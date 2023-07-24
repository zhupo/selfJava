package rumen;

public class Hello {
	public static void main(String[] args) {
		//安装多版本jdk
		//https://blog.csdn.net/weixin_39397471/article/details/123009053
		//查看jdk位置： /usr/libexec/java_home -V
		//java 环境 .bash_profile
		//export JAVA_20_HOME="/Library/Java/JavaVirtualMachines/jdk-20.jdk/Contents/Home -v 20"
		//export JAVA_8_HOME="/Library/Java/JavaVirtualMachines/jdk1.8.0_341.jdk/Contents/Home -v 1.8"
		//alias jdk8='export JAVA_HOME=$JAVA_8_HOME'
		//alias jdk20='export JAVA_HOME=$JAVA_20_HOME'
		//JAVA_HOME=$JAVA_20_HOME
		//PATH=$JAVA_HOME/bin:$PATH:.
		//export JAVA_HOME
		//export PATH
		System.out.println("Hello, world!");

		//变量*
//		int x = 100; // 定义int类型变量x，并赋予初始值100
//		x = 200;
//		System.out.println(x); // 打印该变量的值


//		int n = 100; // 定义变量n，同时赋值为100
//		System.out.println("n = " + n); // 打印n的值
//
//		n = 200; // 变量n赋值为200
//		System.out.println("n = " + n); // 打印n的值
//
//		int x = n; // 变量x赋值为n（n的值为200，因此赋值后x的值也是200）
//		System.out.println("x = " + x); // 打印x的值
//
//		x = x + 100; // 变量x赋值为x+100（x的值为200，因此赋值后x的值是200+100=300）
//		System.out.println("x = " + x); // 打印x的值
//		System.out.println("n = " + n); // 再次打印n的值，n应该是200还是300？
//
//		//char类型
		char a = 'A';
		char zh = '中';
		System.out.println(a);
		System.out.println(zh);
//
//		int ab = 100;
//		int ba = 100 + (++ab);
//		System.out.println(ba);
//
//		if (ab < ba && ba > ab) {
//			System.out.println(ba);
//		}

		//练习自然数之和
//		int n = 100;
//		int sum = (1 + n) * n / 2;
//
//		System.out.println(sum);
//
//		System.out.println(sum == 5050 ? "测试通过" : "测试失败");

		double x = 1.0 / 10;
		double y = 1 - 9.0 / 10;
		// 观察x和y
		System.out.println(x);
		System.out.println(y);
	}
}