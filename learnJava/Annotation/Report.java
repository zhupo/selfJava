package Annotation;

import java.lang.annotation.*;

//元注解
@Target({
    ElementType.TYPE,
    ElementType.METHOD,
    ElementType.FIELD,
    ElementType.CONSTRUCTOR
})
@Retention(RetentionPolicy.RUNTIME)// 如果@Retention不存在，则该Annotation默认为CLASS。因为通常我们自定义的Annotation都是RUNTIME，所以，务必要加上@Retention(RetentionPolicy.RUNTIME)这个元注解：
@Repeatable(Reports.class) //使用@Repeatable这个元注解可以定义Annotation是否可重复。这个注解应用不是特别广泛。
//@Inherited
public @interface Report {
    //1,@Target
    //类或接口：ElementType.TYPE；
    //字段：ElementType.FIELD；
    //方法：ElementType.METHOD；
    //构造方法：ElementType.CONSTRUCTOR；
    //方法参数：ElementType.PARAMETER。
    int type() default 0;
    String level() default "info";
    String value() default "";

    //2, @Retention
    //另一个重要的元注解@Retention定义了Annotation的生命周期：
    //
    //仅编译期：RetentionPolicy.SOURCE；
    //仅class文件：RetentionPolicy.CLASS；
    //运行期：RetentionPolicy.RUNTIME。

    //3, @Repeatable 定义annotation是否可以重复
    //@Repeatable(Reports.class)

    //4, @Inherited: 使用@Inherited定义子类是否可继承父类定义的Annotation。@Inherited仅针对@Target(ElementType.TYPE)类型的annotation有效，并且仅针对class的继承，对interface的继承无效：


}
