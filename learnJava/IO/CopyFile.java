package IO;

import java.io.*;
import java.util.Objects;

public class CopyFile {
    private static final String SOURCE_FILE = "/Users/pan.liu/Documents/javaProjects/selfJava/learnJava/IO/source.txt";
    private static final String COPY_FILE = "/Users/pan.liu/Documents/javaProjects/selfJava/learnJava/IO/copy.txt";
    private static final int DEFAULT_BUFFER_SIZE = 1000;
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("error");
            System.exit(1);
        }
//        copy(args[0], args[1]);
        transferToCopy(args[0], args[1]);
    }

    static void copy(String source, String target) throws IOException {
        try (InputStream input = new FileInputStream(source);
             OutputStream output = new FileOutputStream(target)) {
            int n;

            String s;

            StringBuilder sb = new StringBuilder();

            while ((n = input.read()) != -1) {
                sb.append((char) n);
            }

            s = sb.toString();

            output.write(s.getBytes("UTF-8"));
        }
    }

    static void transferToCopy(String source, String target) throws IOException {
        try (InputStream input = new FileInputStream(source);
            OutputStream output = new FileOutputStream(target)) {
            Objects.requireNonNull(output);
            long transferred = 0;
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            int read;
            while ((read = input.read(buffer, 0, DEFAULT_BUFFER_SIZE)) > 0) {
                output.write(buffer, 0, read);
                transferred += read;
            }
        }
    }
}
