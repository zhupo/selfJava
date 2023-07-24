package Annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Report(type = 1,level = "debug")
@Report(type = 2,level = "warning")
public class Main {
    int n;
    public static void main(String[] args) throws Exception, NoSuchMethodException {
        //1, 判断某个注解是否存在于Class、Field、Method或Constructor：
        //
        //Class.isAnnotationPresent(Class)
        //Field.isAnnotationPresent(Class)
        //Method.isAnnotationPresent(Class)
        //Constructor.isAnnotationPresent(Class)
        Class<Test> t = Test.class;
        Field name = t.getDeclaredField("name");
        Method m = t.getDeclaredMethod("hello");
        Constructor<Test> cons1 = Test.class.getConstructor();
        Constructor<Test> constructor = t.getConstructor();
        System.out.println(t.isAnnotationPresent(Report.class));
        System.out.println(name.isAnnotationPresent(Report.class));
        System.out.println(m.isAnnotationPresent(Report.class));
        System.out.println(constructor.isAnnotationPresent(Report.class));

        //2, 使用反射api读取Annotation
        //Class.getAnnotation(Class)
        //Field.getAnnotation(Class)
        //Method.getAnnotation(Class)
        //Constructor.getAnnotation(Class)
        Report report = null;
        if (Test.class.isAnnotationPresent(Report.class)) {
            report = Test.class.getAnnotation(Report.class);
        }
        Report report1 = name.getAnnotation(Report.class);
        Report report2 = m.getAnnotation(Report.class);
        Report report3 = cons1.getAnnotation(Report.class);
        System.out.println(report);
        System.out.println(report1);
        System.out.println(report2);
        System.out.println(report3);

        //3, 使用注解:
        Test tt = new Test();
        tt.name = "test";
        check(tt);
    }

    static void check(Test test) throws IllegalArgumentException, ReflectiveOperationException {
        //遍历所有Field:
        for (Field field: test.getClass().getFields()) {
            Range range = field.getAnnotation(Range.class);
            if (range != null) {
                //获取field的值
                Object value = field.get(test);
                //如果值是String：
                if (value instanceof String s) {
                    if (s.length() < range.min() || s.length() > range.max()) {
                        throw new IllegalArgumentException("Invalid field111: " + field.getName());
                    }
                }
            }
        }
    }
}
