package IO;

import java.io.*;

public class OutPutStreamTest {
    private static final String TEST_FILE = "/Users/pan.liu/Documents/javaProjects/selfJava/learnJava/IO/test.txt";

    public static void main(String[] args) throws IOException {
        //defaultWrite();
        batchWrite();
        byteArrayWrite();
    }
    //和InputStream一样，OutputStream的write()方法也是阻塞的。

    static void byteArrayWrite() throws IOException {
        byte[] data;
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            output.write("Hello " . getBytes("UTF-8"));
            output.write("world!" . getBytes("UTF-8"));
            data = output.toByteArray();
        }
        System.out.println(new String(data, "UTF-8"));
    }

    static void defaultWrite() throws IOException {
        OutputStream output = new FileOutputStream(TEST_FILE);
        output.write(72);
        output.write(101);
        output.write(108);
        output.write(108);
        output.write(111);
        output.close();
    }

    static void batchWrite() throws IOException {
        try (OutputStream output = new FileOutputStream(TEST_FILE)) {
            output.write("Hello".getBytes("UTF-8"));
        }
        try (InputStream input = new FileInputStream(TEST_FILE)) {
            int n;
            StringBuilder sb = new StringBuilder();
            while ((n = input.read()) != -1) {
                sb.append((char) n);
            }
            System.out.println(sb);
        }
    }
}
