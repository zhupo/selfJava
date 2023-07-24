package core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class CoreBigDecimal {
    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal("123.4567");
        System.out.println(bd.multiply(bd)); // 15241.55677489

        BigDecimal d1 = new BigDecimal("123.45");
        BigDecimal d2 = new BigDecimal("123.4500");
        BigDecimal d3 = new BigDecimal("1234500");
        System.out.println(d1.scale()); // 2,两位小数
        System.out.println(d2.scale()); // 4
        System.out.println(d3.scale()); // 0

        //通过BigDecimal的stripTrailingZeros()方法，可以将一个BigDecimal格式化为一个相等的，但去掉了末尾0的BigDecimal：
        BigDecimal d4 = new BigDecimal("123.45000");
        BigDecimal d5 = d4.stripTrailingZeros();
        System.out.println(d4.scale());
        System.out.println(d5.scale());

        BigDecimal d6 = new BigDecimal("1234500");
        BigDecimal d7 = d3.stripTrailingZeros();
        System.out.println(d6.scale()); // 0
        System.out.println(d7.scale()); // -2 如果一个BigDecimal的scale()返回负数，例如，-2，表示这个数是个整数，并且末尾有2个0。

        BigDecimal d8 = new BigDecimal("123.456789");
        BigDecimal d9 = d8.setScale(4, RoundingMode.HALF_UP);
        BigDecimal d10 = d8.setScale(4, RoundingMode.DOWN);
        System.out.println(d9); // 四舍五入，123.4568
        System.out.println(d10); // 直接截断，123.4567

        //对BigDecimal做加、减、乘时，精度不会丢失，但是做除法时，存在无法除尽的情况，这时，就必须指定精度以及如何进行截断：
        BigDecimal bd1 = new BigDecimal("123.456");
        BigDecimal bd2 = new BigDecimal("23.456789");
        BigDecimal bd3 = bd1.divide(bd2, 10, RoundingMode.HALF_UP);// 保留10位小数并四舍五入
//        BigDecimal bd4 = bd1.divide(bd2); //报错：ArithmeticException，因为除不尽
        System.out.println(bd3);
//        System.out.println(bd4);

        //对BigDecimal做除法的同时求余数
        BigDecimal n = new BigDecimal("12.345");
        BigDecimal m = new BigDecimal("0.12");
        BigDecimal[] dr = n.divideAndRemainder(m);
        System.out.println(dr[0]);// 商 102 永远是整数
        System.out.println(dr[1]); // 余数, 0.105, 余数不会大于除数

        //余数不会大于除数。我们可以利用这个方法判断两个BigDecimal是否是整数倍数：
        BigDecimal n1 = new BigDecimal("12.75");
        BigDecimal m1 = new BigDecimal("0.15");
        BigDecimal[] dr1 = n1.divideAndRemainder(m1);
        if (dr1[1].signum() == 0) {
            System.out.println("n1是m1的" + dr1[0] + "倍");
        }

        //比较BigDecimal
        BigDecimal bd5 = new BigDecimal(123.456);
        BigDecimal bd6 = new BigDecimal(123.456000);
        System.out.println(bd5.equals(bd6)); //false, 因为scale不同????
        System.out.println(bd5.equals(bd6.stripTrailingZeros())); //true

        System.out.println(bd5.compareTo(bd6)); // -1 表示小于，1表示大于，0表示等于
        //必须使用compareTo()方法来比较，它根据两个值的大小分别返回负数、正数和0，分别表示小于、大于和等于。
        // 总是使用compareTo()比较两个BigDecimal的值，不要使用equals()！

        //Random 伪随机数
        Random r = new Random(12345);
        for (int i = 0; i < 10; i++) {
            System.out.print(r.nextInt(100) + ",");
        }
        // 51, 80 ...

        //SecureRandom 真随机数
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstanceStrong(); // 获取高强度安全随机数生成器
        } catch (NoSuchAlgorithmException e) {
            sr = new SecureRandom(); // 获取普通的安全随机数生成器
        }
        byte[] buffer = new byte[16];
        sr.nextBytes(buffer); // 用安全随机数填充buffer
        System.out.println(Arrays.toString(buffer));
    }
}
