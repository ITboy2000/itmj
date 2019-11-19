package 面向对象编程.接口;

import java.util.Arrays;
//自定义类型进行排序时，必须实现comparable接口，并且重写compareableTO（）方法
class Student implements Comparable<Student>{
    public String name;
    public int age;
    public double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
//        return this.age-o.age;
        return this.name.compareTo(o.name);//comparableTo（）通过字符串大小比较
    }
}

public class TestDemo03 {
    //自己写sort方法,传的数据类型肯定是实现comparable接口的
    public static void sort(Comparable[] comparables){
        //冒泡排序
        for (int i = 0; i <comparables.length ; i++) {
            for (int j = 0; j <comparables.length-i ; j++) {
                if (comparables[j].compareTo(comparables[j+1])>0){
                    Comparable temp=comparables[j+1];
                    comparables[j+1]=comparables[j];
                    comparables[j]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Student[] students=new Student[3];
        students[0]=new Student("曹操",78,56.3);
        students[1]=new Student("张飞",86,66.6);
        students[2]=new Student("刘备",12,55.5);
        System.out.println(Arrays.toString(students));
//        Arrays.sort(students);
        sort(students);
        System.out.println(Arrays.toString(students));

    }
}
