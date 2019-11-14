package 面向对象编程.Extends.多态2;

public class Noodles {
    public String name;
    public int length;
    public int width;
    public Noodles(){

    }
    public Noodles(String name,int length,int width){
        this.name=name;
        this.length=length;
        this.width=width;
    }
    public void makeNoodlesStep(){
        System.out.println("1.和面");
        System.out.println("2.切面");
        System.out.println("3.煮面");
    }
    public void taste(){
        System.out.println(this.name+"尝起来真不错");
    }
    public void shape(){

    }
}
class DaoXiaoMian extends Noodles{
    //子类继承父类后，继承的是除父类构造方法之外的所有东西
    //继承后的第一步就是帮助子类构造父类super（），目的就是为了获得父类的属性
    public String color;
    public DaoXiaoMian(){

    }
    public DaoXiaoMian(String name,int length,int width,String color){
        super( name,length,width);
        this.color=color;
    }

    public void disPlay(){
        System.out.println(this.name+" "+this.length+" "+this.width+" "+this.color);
    }
    public void func(){
        super.makeNoodlesStep();
    }
    public void shape(){
        System.out.println("宽大的");
    }
}
class ZhaJiangMian extends Noodles{
    public String color;
    public ZhaJiangMian(){

    }
    public ZhaJiangMian(String name,int length,int width,String color){
        super(name,length,width);
        this.color=color;
    }
    public void disPlay2(){
        System.out.println(this.name+" "+this.length+" "+this.width+" "+this.color);
    }
    public void shape(){
        System.out.println("细小的");
    }
}