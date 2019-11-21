package 面向对象编程.接口;
//克隆接口（implements Cloneable），在自定义类型进行克隆时，
// 一定要实现Cloneable接口，并且重写clone（）方法
class Money implements Cloneable{
    double m=12.9;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable{
    public String name;
    Money money;
    public Person(){
    }
    public Person(String name) {
        this.name = name;
        this.money=new Money();
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {//只是克隆了Person,也就是说是一个浅拷贝
        Person p=(Person) super.clone();
        p.money=(Money) this.money.clone();//再将Money也克隆一次，达到深拷贝。
        //return super.clone();//返回的是object是一个对象
        return p;
    }
}
public class TestDemo05 {
    /*克隆：
     * */
    public static void main(String[] args)throws CloneNotSupportedException {
        Person person=new Person("CAOCAO");
        Person person1=(Person)person.clone();
        person1.money.m=99.9;
        System.out.println(person.money.m);//12.9
        System.out.println(person1.money.m);//99.9
        System.out.println(person.name);
    }
}
