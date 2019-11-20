package 面向对象编程.接口;

import java.util.Arrays;

interface ISkillOne{
    void show1();
}

interface ISkillTwo{
    void show2();
}

interface ISkillThree{
    void show3();
}

class Heros{
    public String name;
    public String type;
    public String sex;

    public Heros(String name, String type, String sex) {
        this.name = name;
        this.type = type;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Heros{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}

class Hero1 extends Heros implements ISkillOne,ISkillTwo,ISkillThree{
    public Hero1(String name, String type, String sex) {
        super(name, type, sex);
    }

    public void disPlay(){
        System.out.println("["+this.name+","+this.type+","+this.sex+"]");
    }

    @Override
    public void show1() {
        System.out.println(this.name+"一技能");
    }

    @Override
    public void show2() {
        System.out.println(this.name+"二技能");
    }

    @Override
    public void show3() {
        System.out.println(this.name+"大招");
    }
}

class Hero2 extends Heros implements ISkillOne,ISkillTwo,ISkillThree{
    public Hero2(String name, String type, String sex) {
        super(name, type, sex);
    }

    public void disPlay(){
        System.out.println("["+this.name+","+this.type+","+this.sex+"]");
    }

    @Override
    public void show1() {
        System.out.println(this.name+"一技能");
    }

    @Override
    public void show2() {
        System.out.println(this.name+"二技能");
    }

    @Override
    public void show3() {
        System.out.println(this.name+"大招");
    }
}

class Hero3 extends Heros implements ISkillOne,ISkillTwo,ISkillThree{
    public Hero3(String name, String type, String sex) {
        super(name, type, sex);
    }

    public void disPlay(){
        System.out.println("["+this.name+","+this.type+","+this.sex+"]");
    }

    @Override
    public void show1() {
        System.out.println(this.name+"一技能");
    }

    @Override
    public void show2() {
        System.out.println(this.name+"二技能");
    }

    @Override
    public void show3() {
        System.out.println(this.name+"大招");
    }
}
public class TestDemo04 {
    public static void main(String[] args) {
        Heros[] heros=new Heros[3];
        heros[0]=new Hero1("白起","坦克","男");
        heros[1]=new Hero2("百里守约","射手","男");
        heros[2]=new Hero3("王昭君","法师","女");
        System.out.println(Arrays.toString(heros));
        ISkillOne skillOne1= (ISkillOne) heros[0];
        skillOne1.show1();
        ISkillTwo skillTwo1= (ISkillTwo) heros[0];
        skillTwo1.show2();
        ISkillThree skillThree1= (ISkillThree) heros[0];;
        skillThree1.show3();

        ISkillOne skillOne2= (ISkillOne) heros[1];
        skillOne2.show1();
        ISkillTwo skillTwo2= (ISkillTwo)  heros[1];
        skillTwo2.show2();
        ISkillThree skillThree2= (ISkillThree)  heros[1];;
        skillThree2.show3();


        ISkillOne skillOne3= (ISkillOne) heros[2];
        skillOne3.show1();
        ISkillTwo skillTwo3= (ISkillTwo)  heros[2];
        skillTwo3.show2();
        ISkillThree skillThree3= (ISkillThree)  heros[2];;
        skillThree3.show3();
    }
}
