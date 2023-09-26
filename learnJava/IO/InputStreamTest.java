package IO;

import java.io.*;

public class InputStreamTest {
    private static final String FILE_URL  = "/usr/local/etc/nginx/servers/ozz.conf";
    public static void main(String[] args) throws IOException {
        //read();
        //tryFinallyRead();
        //tryRead();
        //bufferRead();
        blockRead();
    }

    //阻塞
    //在调用InputStream的read()方法读取数据时，我们说read()方法是阻塞（Blocking）的。它的意思是，对于下面的代码：
    //
    //int n;
    //n = input.read(); // 必须等待read()方法返回才能执行下一行代码
    //int m = n;

    static void blockRead() throws IOException {
        //InputStream实现类
        byte[] data = { 72, 101, 108, 108, 111, 33};
        try (InputStream input = new ByteArrayInputStream(data)) {
            int n;
            while((n = input.read()) != -1) {
                System.out.println((char)n);
            }
        }
    }

    static void bufferRead() throws IOException {
        //缓冲
        try (InputStream input = new FileInputStream(FILE_URL)) {
            StringBuilder sb = new StringBuilder();
            byte[] buffer = new byte[1000];
            int n;
            while ((n = input.read(buffer)) != -1) {
                sb.append((char) n);
                System.out.println("read" + n + " bytes.");
            }
            System.out.println(sb.toString());
        }
    }

    static void tryRead() throws IOException {
        try (InputStream input = new FileInputStream(FILE_URL)) {
            int n;
            StringBuilder sb = new StringBuilder();
            while ((n = input.read()) != -1) {
                sb.append((char) n);
            }
            System.out.println(sb);
        }
    }

    static void tryFinallyRead() throws IOException {
        InputStream input = null;
        try {
            input = new FileInputStream(FILE_URL);
            StringBuilder sb = new StringBuilder();
            int n;
            while ((n = input.read()) != -1) {
                sb.append((char) n);
            }
            System.out.println(sb);
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    static void read() throws IOException {
        InputStream input = new FileInputStream(FILE_URL);
        StringBuilder sb = new StringBuilder();
        for(;;) {
            int n = input.read();
            if (n == -1) {
                break;
            }
            sb.append((char) n);
        }
        System.out.println(sb.toString());
        input.close();
    }
}
