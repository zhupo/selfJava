package core;

public class Main {
    public static void main(String[] args) {
        //Record
        //使用record定义的是不变类；
        //可以编写Compact Constructor对参数进行验证；
        //可以定义静态方法。
        CoreRecordPoint p = new CoreRecordPoint(123, 456);
        CoreRecordPoint p1 = new CoreRecordPoint(1234, 456);
        System.out.println(p.x());
        System.out.println(p.y());
        System.out.println(p);
        System.out.println(p.equals(p1));

        var z = CoreRecordPoint.of();
        var y = CoreRecordPoint.of(123, 456);
        System.out.println(z);
        System.out.println(y);
    }
}
