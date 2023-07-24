package rumen;

import java.util.Arrays;

public class ArrayOperation {
    public static void main(String[] args) {
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int i=0; i<ns.length; i++) {
            int n = ns[i];
            System.out.println(n);
        }

        int[] ns1 = { 1, 4, 9, 16, 25 };
        for (int n : ns1) {
            System.out.println(n);
        }

//        System.out.println(ns);//无意义
        System.out.println(Arrays.toString(ns));//Arrays.toString(ns) 直接打印


        //练习，倒序打印每个元素
        for (int i = ns.length - 1; i >= 0; i--) {
            System.out.println(ns[i]);
        }

        //冒泡排序
        int[] ns2 = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        // 排序前:
        System.out.println(Arrays.toString(ns2));
        for (int i = 0; i < ns2.length - 1; i++) {
            for (int j = 0; j < ns2.length - i - 1; j++) {
                if (ns2[j] > ns2[j+1]) {
                    // 交换ns[j]和ns[j+1]:
                    int tmp = ns2[j];
                    ns2[j] = ns2[j+1];
                    ns2[j+1] = tmp;
                }
            }
        }
        // 排序后:
        System.out.println(Arrays.toString(ns2));


        int[] ns3 = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        Arrays.sort(ns3);
        System.out.println(Arrays.toString(ns3));

        //练习降序
        int[] ns4 = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        //排序前：
        System.out.println(Arrays.toString(ns4));
        for (int i = 0; i < ns4.length - 1; i++) {
            for (int j = 0; j < ns4.length - i - 1; j++) {
                if (ns4[j] < ns4[j+1]) {
                    //交换
                    int tmp = ns4[j];
                    ns4[j] = ns4[j+1];
                    ns4[j+1] = tmp;
                }
            }
        }
        //排序后：
        System.out.println(Arrays.toString(ns4));

        //多维数组
        int[][] nx = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
        };
        System.out.println(nx.length);
        int[] arr0 = nx[0];
        System.out.println(Arrays.toString(arr0));
        System.out.println(nx[1][2]);

        for (int[] arr : nx) {
            for (int n : arr) {
                System.out.print(n + ", ");
            }
        }

        System.out.println(Arrays.deepToString(nx));


        //练习： 使用二维数组表示一组学生的各科成绩，计算所有学生的平均分
        int[][] scores = {
                { 82, 90, 91 },
                { 68, 72, 64 },
                { 95, 91, 89 },
                { 67, 52, 60 },
                { 79, 81, 85 },
        };
        double average = 0;
        int scoresSum = 0;
        int scoreNum = 0;
        for (int[] arr : scores) {
            for (int score : arr) {
                scoresSum += score;
                scoreNum ++;
            }
        }
        average = (double) scoresSum / scoreNum;

        if (Math.abs(average - 77.733333) < 0.000001) {
            System.out.println("测试成功");
        } else {
            System.out.println("测试失败");
        }
    }
}
