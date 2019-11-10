package 面向对象编程;
//继承-------is a 关系
//final
public class Animal {//final class className:密封类，密封类不能被继承
    protected String name;//protected关键字主要是为了继承出现的
    //protected关键字表示谁继承了我谁才可以使用我的东西
    private int age;
    public int a=10;
    //静态代码块
    static{
        System.out.println("Animal:static{}");
    }
    //实例代码块
    {
        System.out.println("Animal:instance{}");
    }

    public Animal(String name, int age){
        this.name=name;
        this.age=age;
        System.out.println("Animal(String name,int age,String sex)");
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void eat(){
        System.out.println(this.name+"Animal.eat()");
    }
    public void sleep(){
        System.out.println("sleep()");
    }
}
