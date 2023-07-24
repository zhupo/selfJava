package ExceptionProcess;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        byte[] bs = toGBK("中文");
        System.out.println(Arrays.toString(bs));
        try {
            process1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static byte[] toGBK(String s) {
        try {
            return s.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println(e);
            return s.getBytes();
        } finally {
            System.out.println("End");
        }//在catch中抛出异常，不会影响finally的执行。JVM会先执行finally，然后抛出异常。
    }

    static void process1() {
        try {
            process2();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static void process2() {
        Integer.parseInt(null); //会抛出NumberFormatException
    }
}
