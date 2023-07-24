package rumen;

import java.util.Scanner;

public class If {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1);
        System.out.println(s2);
//        if (s1 == s2) {
        if (s1.equals(s2)) {
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 != s2");
        }

        String s3 = null;
        if (s3 != null && s3.equals("hello")) {
            System.out.println("hello");
        }

        if ("hello".equals(s3)) {
            System.out.println("hello");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input your height(m): ");
        double height = scanner.nextDouble();
        System.out.print("Input your weight(kg): ");
        double weight= scanner.nextDouble();
        double bmi = weight / (height * height);
        System.out.println("Your BMI is: " + bmi);
        System.out.printf("Your BMI is: %.2f  ", bmi);

        if (bmi < 18.5) {
            System.out.println("过轻");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("正常");
        } else if (bmi >= 25 && bmi < 28) {
            System.out.println("过重");
        } else if (bmi >= 28 && bmi < 32) {
            System.out.println("肥胖");
        } else {
            System.out.println("非常肥胖");
        }
    }
}
