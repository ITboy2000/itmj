package 面向对象编程;

public class Test {
    public static void main(String[] args) {
        Cat cat=new Cat("咪咪",2,"母");
        cat.eat();//此时的eat是父类的eat（）
        System.out.println("==============================");
        Cat cat2=new Cat("咪咪",2,"母");
        BlackCat blackCat=new BlackCat("黑猫",9,"公","黑色");
        blackCat.eat();
//        Dog dog=new Dog("豆豆",2,"公");
//        dog.bark();
//        dog.eat();
//        Animal animal=new Animal("动物",100);
//        animal.sex;//基类只能访问自己的成员属性和方法
//        String name=animal.name;
    }
    /*
     *  静态代码块先加载>实例代码块加载>构造方法加载
     * 父类先执行然后是子类！
      * */
}
