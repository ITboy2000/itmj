package 面向对象编程.接口;
//开发过程中一个接口也在一个java文件当中
//接口当中的所有方法都不能实现
//接口当中的方法都是抽象方法--默认的public abstract
//接口当中的成员变量都是public static final
//接口不可以被实例化
//接口的存在意义就是被继承
/*
 * 类和接口之间的关系为实现
 * 只要接口被普通类实现，接口当中的方法都要被重写.
 * 接口和接口是继承
 * */
interface Shape2{
    void func();
}

public interface Shape {
    int size=10;
    void draw();
}
