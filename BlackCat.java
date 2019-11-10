package 面向对象编程;

public class BlackCat extends Cat {
    private String color;

    public BlackCat(String name,int age,String sex,String color){
        super(name,age,sex);
        this.color=color;
    }

}
