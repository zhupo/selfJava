package reflection;

public class Class {
    public static void main(String[] args) {
        //如何获取一个class的Class实例？有三个方法：
        //1,直接通过一个class的静态变量获取:
        java.lang.Class cls = String.class;
        //2，通过一个实例变量提供的getClass()
        String s = "Hello";
        java.lang.Class cls1 = s.getClass();
        //3.如果知道一个class的完成类名, 可以通过静态方法Class.forName()获取
        java.lang.Class cls2 = null;
        try {
            cls2 = java.lang.Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(cls == cls1);
        System.out.println(cls == cls2);

//        Integer n = Integer.getInteger("123");
//
//        boolean b1 = n instanceof Integer; // true，因为n是Integer类型
//        boolean b2 = n instanceof Number; // true，因为n是Number类型的子类
//
//        boolean b3 = n.getClass() == Integer.class; // true，因为n.getClass()返回Integer.class
//        boolean b4 = n.getClass() == Number.class; // false，因为Integer.class!=Number.class
//
//        System.out.println(b1);
//        System.out.println(b2);
//        System.out.println(b3);
//        System.out.println(b4);

        printClassInfo("".getClass());
        printClassInfo(Runnable.class);
        printClassInfo(java.time.Month.class);
        printClassInfo(String[].class);
        printClassInfo(int.class);
        //JVM是动态加载

    }

    public static void printClassInfo(java.lang.Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());

        System.out.println("----------");
    }
}
