package reflection;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //Field getField(name)：根据字段名获取某个public的field（包括父类）
        //Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
        //Field[] getFields()：获取所有public的field（包括父类）
        //Field[] getDeclaredFields()：获取当前类的所有field（不包括父类）
        java.lang.Class<TestStudent> stdClass = TestStudent.class;
        // 获取public 字段"score":
        System.out.println(stdClass.getField("score"));
        // 获取public 字段"name":
        System.out.println(stdClass.getField("name"));
        // 获取private 字段"grade":
        System.out.println(stdClass.getDeclaredField("grade"));
        // 获取当前类所有的字段//不包括父类
        Field[] fields = stdClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //1, 获取字段的所有信息
        Field field = String.class.getDeclaredField("value");
        System.out.println(field.getName());
        System.out.println(field.getType());
        int m = field.getModifiers();
        System.out.println(m);
        System.out.println(Modifier.isFinal(m));
        System.out.println(Modifier.isPublic(m));
        System.out.println(Modifier.isProtected(m));
        System.out.println(Modifier.isPrivate(m));
        System.out.println(Modifier.isStatic(m));

//        System.out.println(stdClass.getDeclaredFields().toString());

        //2, 通过反射获取字段值
        Object p = new TestStudent(18, "张三", 730);
        java.lang.Class c = p.getClass();
        Field f = c.getDeclaredField("grade");
        //允许访问private字段
        f.setAccessible(true);
        Object value = f.get(p);
        System.out.println(value);

        //3, 通过反射设置字段值
        //设置字段值是通过Field.set(Object, Object)实现的，其中第一个Object参数是指定的实例，第二个Object参数是待修改的值
        TestPerson p1 = new TestPerson(2, "tom");
        System.out.println(p1.getAge());
        java.lang.Class c1 = p1.getClass();
        Field f1 = c1.getDeclaredField("age");
        Field f2 = c1.getDeclaredField("name");
        f1.setAccessible(true);
        f1.set(p1, 3);
        f2.set(p1, "hogan");
        System.out.println(p1.getAge());
        System.out.println(p1.getName());

        //4, 通过反射调用方法:
        //Method getMethod(name, Class...)：获取某个public的Method（包括父类）
        //Method getDeclaredMethod(name, Class...)：获取当前类的某个Method（不包括父类）
        //Method[] getMethods()：获取所有public的Method（包括父类）
        //Method[] getDeclaredMethods()：获取当前类的所有Method（不包括父类）

        // 获取public方法getScore，参数为String:
        System.out.println(stdClass.getMethod("getScore", String.class));

        // 获取继承的public方法getName，无参数:
        System.out.println(stdClass.getMethod("getName"));

        // 获取private方法getGrade，参数为int:
        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));

        //5, 调用方法：
        String s = "Hello world";
        String r = s.substring(6);
        Method m1 = String.class.getMethod("substring", int.class);
        Method m2 = String.class.getMethod("substring", int.class, int.class);//多个参数
        String r1 = (String) m1.invoke(s, 6);// 对Method实例调用invoke就相当于调用该方法
        String r2 = (String) m2.invoke(s, 6, 11);// 对Method实例调用invoke就相当于调用该方法
        System.out.println(r);
        System.out.println(r1);
        System.out.println(r2);

        //6, 调用静态方法:
        //调用静态方法时，由于无需指定实例对象，所以invoke方法传入的第一个参数永远为null
        // 获取Integer.parseInt(String)方法，参数为String:
        Method m3 = Integer.class.getMethod("parseInt", String.class);
        //调用该静态方法并获取结果:
        Integer n = (Integer) m3.invoke(null, "12345");
        System.out.println(n);

        //7, 调用非public方法
        TestPerson p2 = new TestPerson(28, "张三");
        Method m4 = p2.getClass().getDeclaredMethod("setName", String.class);
        //允许调用私有方法
        m4.setAccessible(true);
        m4.invoke(p2, "Bob");
        System.out.println(p2.name);

        //8, 多态
        Method h = TestPerson.class.getMethod("hello");
        h.invoke(new TestStudent(2, "李四"));//总是会调用实际类型的覆写方法

        //9，调用构造方法
        //获取构造方法Integer(int)
        Constructor<Integer> cons1 = Integer.class.getConstructor(int.class);
        //调用构造方法:
        Integer n1 = (Integer) cons1.newInstance(123);
        System.out.println(n1);

        Constructor cons2 = Integer.class.getConstructor(String.class);
        Integer n2 = (Integer) cons2.newInstance("456");
        System.out.println(n2);

//        Constructor cons3 = TestStudent.class.getConstructor(TestStudent.class);
//        cons3.setAccessible(true);
//        TestStudent ts = (TestStudent) cons3.newInstance("张三", 18);
//        System.out.println(ts.name);

        //通过Class实例获取Constructor的方法如下：
        //
        //getConstructor(Class...)：获取某个public的Constructor；
        //getDeclaredConstructor(Class...)：获取某个Constructor；
        //getConstructors()：获取所有public的Constructor；
        //getDeclaredConstructors()：获取所有Constructor。
        //注意Constructor总是当前类定义的构造方法，和父类无关，因此不存在多态的问题。
        //
        //调用非public的Constructor时，必须首先通过setAccessible(true)设置允许访问。setAccessible(true)可能会失败。

        //10, 获取父类的class:
        java.lang.Class i = Integer.class;
        java.lang.Class<? super Integer> n3 = i.getSuperclass();
        System.out.println("1111111111" + n3);
        java.lang.Class o = n3.getSuperclass();
        System.out.println(o);
        System.out.println(o.getSuperclass());

        //11,获取interface: (要特别注意：getInterfaces()只返回当前类直接实现的接口类型，并不包括其父类实现的接口类型：)
        System.out.println(java.io.DataInputStream.class.getSuperclass()); // java.io.FilterInputStream，因为DataInputStream继承自FilterInputStream
        System.out.println(java.io.Closeable.class.getSuperclass()); // null，对接口调用getSuperclass()总是返回null，获取接口的父接口要用getInterfaces()

        java.lang.Class s1 = Integer.class;
        java.lang.Class[] is = s1.getInterfaces();
        for (java.lang.Class ii : is) {
            System.out.println(ii);
        }

        Object nin = Integer.valueOf(123);
        boolean isDouble = nin instanceof Double; // false
        boolean isInteger = nin instanceof Integer; // true
        boolean isNumber = nin instanceof Number; // true
        boolean isSerializable = nin instanceof java.io.Serializable; // true

        //如果是两个Class实例，要判断一个向上转型是否成立，可以调用isAssignableFrom()：
        // Integer i = ?
        Integer.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Integer
        // Number n = ?
        Number.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Number
        // Object o = ?
        Object.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Object
        // Integer i = ?
        Integer.class.isAssignableFrom(Number.class); // false，因为Number不能赋值给Integer

        //12, 动态代理
        Hello hello = new HelloWorld();
        hello.morning("Bob");

        //动态
        //1,定义一个InvocationHandler实例，它负责实现接口的方法调用；
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(proxy.getClass());
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning baby , " + args[0]);
                }
                return null;
            }
        };

        InvocationHandler handler1 = (proxy, method, arg1s) -> {
            return null;
        };

        //2,通过Proxy.newProxyInstance()创建interface实例，它需要3个参数：
            //1,使用的ClassLoader，通常就是接口类的ClassLoader；
            //2,需要实现的接口数组，至少需要传入一个接口进去；
            //3,用来处理接口方法调用的InvocationHandler实例。
        //3,将返回的Object强制转型为接口。
        Hello hello1 = (Hello) Proxy.newProxyInstance(
            Hello.class.getClassLoader(), //传入ClassLoader
            new java.lang.Class[] { Hello.class }, //传入要实现的接口
            handler //传入处理调用方法的InvocationHandler
        );

        //4, 调用接口方法
        hello1.morning("张三");
    }
}
