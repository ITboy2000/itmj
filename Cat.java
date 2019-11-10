package 面向对象编程;

public class Cat extends Animal{//cat 继承 animal,继承是继承除构造方法之外的所有东西
    //继承后要帮助父类进行构造
    private String sex;
    //静态代码块
    static{
        System.out.println("Cat:static{}");
    }
    //实例代码块
    {
        System.out.println("Cat:instance{}");
    }

    public Cat(String name,int age,String sex){
        super(name,age);//1.super（）：代表调用父类的构造方法，如果要构造子类先要构造父类
        //必须放在第一行
        this.sex=sex;
        System.out.println("Cat(String name,int age,String sex)");
    }
    public void fun(){//2.调用父类方法
        super.sleep();
        int a=super.a;//3.调用父类的值
    }
}
