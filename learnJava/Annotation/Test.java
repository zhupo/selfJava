package Annotation;

@Report(type = 1,level = "debug")
public class Test {
    @Report
    @Range(min = 1, max=20)
    public String name;

    @Range(max=10)
    public String city;

    @Report
    public Test() {

    }

    @Report
    public Test(Test test) {
        // 带有一个Test类参数的构造方法
    }

    @Report
    void hello() {
        System.out.println("Hello world!");
    }

}
