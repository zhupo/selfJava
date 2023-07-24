package core;

public class CoreEnum {
    public static void main(String[] args) {
        CoreEnumWeekday day = CoreEnumWeekday.MON;
        if (day == CoreEnumWeekday.SAT || day == CoreEnumWeekday.SUN) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }
        //定义的enum类型总是继承自java.lang.Enum，且无法被继承；
        //只能定义出enum的实例，而无法通过new操作符创建enum的实例；
        //定义的每个实例都是引用类型的唯一实例；
        //可以将enum类型用于switch语句。

        //因为enum是一个class，每个枚举的值都是class实例，因此，这些实例有一些方法：
        //name(),返回常量名
        String s = CoreEnumWeekday.SUN.name();
        System.out.println(s);
        //ordinal() 返回定义的常量的顺序
        int n = CoreEnumWeekday.MON.ordinal();
        System.out.println(n);

        // 注意：判断枚举常量的名字，要始终使用name()方法，绝不能调用toString()！
        System.out.println(day.name()); //MON
        System.out.println(day.toString()); //星期一

        if (day.dayValue == 6 || day.dayValue == 0) {
            System.out.println("Today is " + day + ". Work at home!");
        } else {
            System.out.println("Today is " + day + ". Work at office!");
        }


        day = CoreEnumWeekday.SUN;
        // switch
        switch (day) {
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
                System.out.println("Today is " + day + ". word at office!");
                break;
            case SAT:
            case SUN:
                System.out.println("Today is " + day + ". word at home!");
                break;
            default:
                throw new RuntimeException("cannot process " + day);
        }
    }
}
