package 面向对象编程.Extends.组合;
/*
*组合标识has a语义，在下例中，可以理解为一个学生类包含地址
*   组合并没有涉及到特殊的语法（如extends这样的关键字），仅仅是将一个类的实例作为另一个类的字段
*这是我们设计类的常用方法之一
 *  */
//组合：和继承类似，组合也是表达类之间关系的一种方式，也能够达到代码复用的功能
//地址类
class Address{
    public String domic;
    public int floor;
    public Address(String domic,int floor){
        this.domic=domic;
        this.floor=floor;
    }
    public String toString(){
        return "Address:"+"{"+"domic:"+domic+"floor:"+floor+"}";
    }
}
//学生类
class Student{
    public String name;
    public int age;
    public Address address;//这里体现的就是组合，创建了一个地址型的address，属于Address类
    public Student(String name,int age,Address address){
        this.name=name;
        this.age=age;
         this.address=address;
    }
    public String toString(){
        return "Student:"+"{"+"name:"+name+"age:"+age+
                "address:domic"+address.domic+"address:floor"+address.floor+"}";
    }
}
public class TestDemo01 {
    public static void main(String[] args) {
        Address address=new Address("二号楼",3);
        Student student=new Student("马建",21,address);
        System.out.println(address);
        System.out.println(student);
    }
}
