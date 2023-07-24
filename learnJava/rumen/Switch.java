package rumen;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        int option = 99;
        switch (option) {
            case 1:
                System.out.println("Selected 1");
                break;
            case 2:
                System.out.println("Selected 2");
                break;
            case 3:
                System.out.println("Selected 3");
                break;
            default:
                System.out.println("Not selected");
                break;
        }
        double a = (Math.random());
        int b = (int) (0.851458366543249 * 3);

        System.out.println(a);
        System.out.println(b);

        //2
        //java12新特性
//        String fruit = "apple";
//        switch (fruit) {
//            case "apple" -> System.out.println("Selected apple");
//            case "pear" -> System.out.println("Selected pear");
//            case "mango" -> {
//                System.out.println("Selected mango");
//                System.out.println("Good choice!");
//            }
//            default -> System.out.println("No fruit selected");
//        }

        //练习，石头，剪刀，布的游戏

        Scanner scanner = new Scanner(System.in);

        System.out.println(" 1: 石头");

        System.out.println(" 2: 剪刀");

        System.out.println(" 3: 布");

        System.out.println("please choice:(输入数字)");

        int choice = scanner.nextInt();

        int random = 1 + (int) (Math.random() * 3);

        switch (choice - random) {

            case 0:

                System.out.println("平局");

                break;

            case 1:

            case -2:

                System.out.println("你输了");

                break;

            case -1:

            case 2:

                System.out.println("你赢了");

                break;

            default:

                System.out.println("非法输入");

                break;

        }

        System.out.println("电脑的选择" + random);

        scanner.close();
    }
}
