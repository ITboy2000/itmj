/**
 * Created with IntelliJ IDEA.
 * Description:内部类
 * User: GAOBO
 * Date: 2019-12-01
 * Time: 16:25
 */

/**
 * 内部类：
 * 实例内部类
 * 静态内部类
 * 匿名内部类
 * 本地内部类
 */
/*class OuterClass {
    public int data1 = 10;
    public static int data2 = 20;
    //实例内部类->实例方法-》实例数据
    *//**
     * 1、实例内部类不能有静态的数据成员
     * 2、如何拿到内部类的对象
     *         OuterClass o = new OuterClass();
     * OuterClass.InnerClass in  = o.new InnerClass();
     * 3、面试问题：
     *     实例内部类是否拥有外层类对象/是否有额外的开销？
     *//*
    class InnerClass {
        public int data1 = 100;
        //public static int data2 = 300;
        public int data2 = 999;
        public InnerClass() {
            System.out.println("InnerClass()");
        }
        public void func() {
            System.out.println("data2："+data2);
            System.out.println("data1："+this.data1);
            System.out.println("data1："+OuterClass.this.data1);
        }
    }
}*/
class OuterClass {
    public int data1 = 10;
    public static int data2 = 20;

    /**
     * 静态内部类：
     * 1、OuterClass.InnerClass in =
     *          new OuterClass.InnerClass(outerClass);
     * 2、静态内部类 不能直接访问外部内部类的非静态数据成员
     * 但是可以间接访问的。
     */
    static class InnerClass {
        public int data1 = 999;
        public static int  data2 = 888;
        OuterClass o2 = null;
        public InnerClass() {
        }
        public InnerClass(OuterClass o) {
            o2 = o;
        }
        public void func() {
            System.out.println("data1: "+data1);
            System.out.println("data2: "+data2);
            System.out.println("data2: "+OuterClass.data2);
            System.out.println("data1: "+o2.data1);
        }
    }
}
class MyThread {
    public void func(){
        System.out.println("func!");
    }
}
public class TestDemo4 {
    public static void main(String[] args) {
        new MyThread(){
            @Override
            public void func() {
                System.out.println("hello");
            }
        }.func();
    }

    public static void main1(String[] args) {
        OuterClass outerClass = new OuterClass();
        //System.out.println(outerClass.data1);

        OuterClass.InnerClass in = new OuterClass.InnerClass(outerClass);
        in.func();

        /*实例内部类
        OuterClass o = new OuterClass();
        OuterClass.InnerClass in  = o.new InnerClass();
        in.func();*/
    }
}
