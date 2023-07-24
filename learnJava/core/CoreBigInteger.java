package core;

import java.math.BigInteger;

public class CoreBigInteger {
    public static void main(String[] args) {
        BigInteger bi = new BigInteger("1234567890");
        System.out.println(bi.pow(5));

        //和long型整数运算比，BigInteger不会有范围限制，但缺点是速度比较慢。
        BigInteger i1 = new BigInteger("1234567890");
        BigInteger i2 = new BigInteger("12345678901234567890");
        BigInteger sum = i1.add(i2); // 12345678902469135780

        BigInteger i = new BigInteger("123456789000");
        System.out.println(i.longValue()); // 123456789000
        //System.out.println(i.multiply(i).longValueExact()); //java.lang.ArithmeticException: BigInteger out of long range

        //BigInteger和Integer、Long一样，也是不可变类，并且也继承自Number类。因为Number定义了转换为基本类型的几个方法：
        //转换为byte：byteValue()
        //转换为short：shortValue()
        //转换为int：intValue()
        //转换为long：longValue()
        //转换为float：floatValue()
        //转换为double：doubleValue()

        BigInteger n = new BigInteger("999999").pow(99);
        float f = n.floatValue();
        System.out.println(f);
    }
}
