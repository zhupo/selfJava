package IO;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileObject {
    public static void main(String[] args) throws IOException {
        //File f = new File("/usr/local/etc/nginx/servers/ozz.conf");
        File f = new File("ozz.conf");
        System.out.println(f.getPath());//返回构造方法传入的路径
        System.out.println(f.getAbsolutePath());//返回绝对路径
        System.out.println(f.getCanonicalPath());//返回规范路径
        System.out.println(File.separator);//返回系统分割符 /

        File f1 = new File("/usr");
        File f2 = new File("/usr/local/etc");
        File f3 = new File("/usr/local/etc/nginx/servers/ozz.conf");
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());
        System.out.println(f2.isFile());
        System.out.println(f2.isDirectory());
        System.out.println(f3.isFile());
        System.out.println(f3.isDirectory());
        System.out.println("-----------");

        System.out.println(f3.canRead());
        System.out.println(f3.canWrite());
        System.out.println(f3.canExecute());
        System.out.println(f3.length());

        createAndDeleteFile();
        listFiles();

        //和文件操作类似，File对象如果表示一个目录，可以通过以下方法创建和删除目录：
        //boolean mkdir()：创建当前File对象表示的目录；
        //boolean mkdirs()：创建当前File对象表示的目录，并在必要时将不存在的父目录也创建出来；
        //boolean delete()：删除当前File对象表示的目录，当前目录必须为空才能删除成功。
    }

    public static void createAndDeleteFile() throws IOException {
        //createNewFile创建一个新文件,用delete()删除
        //createTempFIle创建一个临时文件, 用deleteOnExit删除
        File file = new File("/Users/pan.liu/Documents/javaProjects/selfJava/test.txt");
        if (file.createNewFile()) {
            System.out.println("文件创建成功");
            if (file.delete()) {
                System.out.println("文件删除成功");
                //删除文件成功;
            }
        }
    }

    public static void listFiles() {
        File f = new File("/usr/local/etc/nginx/servers/");
        File[] fs1 = f.listFiles();
        printFiles(fs1);

        File[] fs2 = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("rbc");//返回rbc表示接受该文件
            }
        });

        printFiles(fs2);
    }

    static void printFiles(File[] files) {
        System.out.println("--------------");
        if (files != null) {
            for (File f : files) {
                System.out.println(f);
            }
        }
        System.out.println("--------------");
        StringBuilder sb = new StringBuilder();
        sb.append((char) 1);
    }
}
