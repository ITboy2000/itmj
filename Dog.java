package 面向对象编程;

public class Dog extends Animal{
    private String sex;
    //静态代码块,只初始化一次
    static{
        System.out.println("Dog:static{}");
    }
    //实例代码块
    {
        System.out.println("Dog:instance{}");
    }

    public Dog(String name,int age,String sex){
        super(name,age);
        this.sex=sex;
        System.out.println("Dog(String name,int age,String sex)");
    }
    public void bark(){
        System.out.println(this.name+"旺旺");
    }
}
