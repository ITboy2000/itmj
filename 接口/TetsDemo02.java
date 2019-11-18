package 面向对象编程.接口;

interface Flying{
    void fly();
}

interface Running{
    void Running();
}

interface Sleeping{
    void Sleeping();
}

class Animal{
    public String name;
    public int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Cat extends Animal implements Running,Sleeping{
    @Override
    public void Sleeping() {
        System.out.println(this.name+"睡觉");
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void Running() {
        System.out.println(this.name+"跑！");
    }
}

class RedCat extends Cat{

    public RedCat(String name, int age) {
        super(name, age);
    }
}

class Bird extends Animal implements Flying,Running{
    @Override
    public void fly() {
        System.out.println(this.name+"飞！");
    }

    @Override
    public void Running() {
        System.out.println(this.name+"跑");
    }

    public Bird(String name, int age) {
        super(name, age);
    }
}

class Robot implements Flying{
    @Override
    public void fly() {
        System.out.println("机器人跑步！");
    }
}

public class TetsDemo02 {

    public static void walk(Running running){
        System.out.println("我和小伙伴去散步！");
        running.Running();
    }

    public static void sleep(Sleeping sleeping){
        System.out.println("我和小伙伴睡觉！");
        sleeping.Sleeping();
    }

    public static void fly(Flying flying){
        System.out.println("Robot！");
        flying.fly();
    }

    public static void main(String[] args) {
        Cat cat=new Cat("小花",12);
        walk(cat);
        sleep(cat);
        //sleep(cat);编译错误，Cat类没有实现Sleeping接口
        fly(new Robot());
    }
}
