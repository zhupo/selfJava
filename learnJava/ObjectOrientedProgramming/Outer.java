package ObjectOrientedProgramming;

public class Outer {
    private String name;
    public static String TEST_NAME = "zhang san";

    Outer(String name) {
        this.name = name;
    }

    /** Inner Class **/
    class Inner {
        void hello() {
            System.out.println("Hello, " + Outer.this.name);
        }
    }

    /** Anonymous Class **/
    void asyncHello() {
        Runnable r = new Runnable() {
            @java.lang.Override
            public void run() {
                System.out.println("Hello, " + Outer.this.name);
            }
        };
        new Thread(r).start();
    }

    /** Static Nested Class **/
    static class StaticNested {
        void hello() {
            System.out.println("Hello, " + Outer.TEST_NAME);
        }
    }

//编译到指定文件夹
//    javac -d ./bin src/**/*.java
}
