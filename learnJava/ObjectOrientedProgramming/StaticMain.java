package ObjectOrientedProgramming;

import mr.pan.ImpPerson;
import javax.xml.XMLConstants;
import java.util.Arrays;

// 一般不推荐这种写法，因为在导入多个包后，很难看出impPerson类属于哪个包
//import mr.pan.*;
// 导入System类的所有静态字段和静态方法:
//import static java.lang.System.*;
//默认自动import当前package的其他class;
//默认自动import java.lang.
//注意：自动导入的是java.lang包，但类似java.lang.reflect这些包仍需要手动导入。

public class StaticMain {
    public static void main(String[] args) {
        StaticPerson ming = new StaticPerson("Xiao Ming", 19);
        StaticPerson hong = new StaticPerson("Xiao Hong", 18);
        ming.number = 88;
        System.out.println(ming.number);
        hong.number = 99;
        System.out.println(ming.number);
        System.out.println(StaticPerson.number);

        //Static function
        //因为静态方法属于class而不属于实例，因此，静态方法内部，无法访问this变量，也无法访问实例字段，它只能访问静态字段
        StaticPerson.setNumber(123);
        System.out.println(StaticPerson.number);

        //因为interface是一个纯抽象类，所以它不能定义实例字段。但是，interface是可以有静态字段的，并且静态字段必须为final类型：
//        public interface Person {
//            public static final int MALE = 1;
//            public static final int FEMALE = 2;
//        }
//        可以简写为如下
//        public interface Person {
//            // 编译器会自动加上public statc final:
//            int MALE = 1;
//            int FEMALE = 2;
//        }

        ImpPerson impPerson = new ImpPerson("xiao wang", 17);
        System.out.println("name: " + impPerson.name + ", age: " + impPerson.age);

//        编译：
//        javac -d ./bin src/**/*.java
//        命令行-d指定输出的class文件存放bin目录，后面的参数src/**/*.java表示src目录下的所有.java文件，包括任意深度的子目录。
//          运行：java -cp bin rumen.Hello

//        注意：Windows不支持**这种搜索全部子目录的做法，所以在Windows下编译必须依次列出所有.java文件：
//
//        C:\work> javac -d bin src\com\itranswarp\sample\Main.java src\com\itranswarp\world\Persion.java

        //实例化内部类
        //Inner Class
        Outer outer = new Outer("Nested");// 实例化一个Outer
        Outer.Inner inner = outer.new Inner();// 实例化一个Inter
        inner.hello();
        //Anonymous Class
        outer.asyncHello();
        //Static Nested Class
        Outer.StaticNested staticNested = new Outer.StaticNested();
        staticNested.hello();


        //jar cf yourJarFile.jar classProject -- 将编译文件夹打成jar包
        //jar cfe yourJarFile.jar com.example.mainClass -C classProject . -- 将编译文件夹打成jar包,并指定com.example.mainClass为入口文件。
        //可以用到https://www.liaoxuefeng.com/wiki/1252599548343744/1255945359327200 Maven工具来创建jar包
        //jar tf yourJarFile.jar -- 查看jar包内容
        //java -jar youJarFile.jar -- 运行一个jar包
        System.out.println(XMLConstants.XML_NS_PREFIX);

        // 把一个jar包转换成一个模块
        // $(/usr/libexec/java_home)/bin/jmod create --class-path hello.jar hello.jmod
        // /Library/Java/JavaVirtualMachines/jdk-20.jdk/Contents/Home/bin/jmod create --class-path test.jar test.jmod

        // 把一个模块变成jre包
        //jlink --module-path test.jmod --add-modules java.base,java.xml,selfJava --output jre/
        //jre/bin/java --module selfJava --  执行jre
    }
}
