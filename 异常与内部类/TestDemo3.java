import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-12-01
 * Time: 14:39
 */
class Person implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

/**
 * 自定义异常的时候  需要自己定义一个类时实现
 * Exception
 * 2、在抛出的时候  需要自己进行throws。
 * 3、编译时期
 */
class MyException extends Exception{

    public MyException(String message) {
        super(message);
    }
}

public class TestDemo3 {

    public static void funcException() throws MyException {
        int a = 10;
        if(a == 10) {
            throw new MyException("a== 10");
        }
    }
    public static void main(String[] args) {
        try {
            funcException();
        }catch (MyException e) {
            e.printStackTrace();
        }
    }



    public static void main6(String[] args) {
        System.out.println(readFile());
    }

    public static String readFile() {
    // 尝试打开文件, 并读其中的一行.
        File file = new File("d:/test.txt");
    // 使用文件对象构造 Scanner 对象.
        try {
            Scanner sc = new Scanner(file);
            return sc.nextLine();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main5(String[] args){

        Scanner scanner  = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(a);

       /* Person person1 = new Person();
        try {
            Person person2 = (Person) person1.clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }*/
    }

    public static int div(int a,int b) throws ArithmeticException{
        if(b == 0) {
            throw new ArithmeticException("gaobo");
        }
        return a/b;
    }

    public static void main4(String[] args) {
        try {
            int a = div(10,0);
            System.out.println(a);
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("捕获异常");
        }

    }



    public static int func() {
        try {
            int a = 10/0;
            return 88;
        }catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("算术异常");
            return 8;
        }finally {
            //建议return不要放在finally块当中
            //因为可能会抑制catch或者try当中的return。
            System.out.println("finally");
            //return 9;
        }
    }
    public static void main3(String[] args) {
        try {
            int ret = func();
            System.out.println(ret);
        }catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("算术异常");
        }
        System.out.println("after");
    }


    public static void main2(String[] args) {
        int[] array = {1,2,3,4,5,6};
        try (Scanner scanner = new Scanner(System.in)) {
            //array = null;
            //int a = scanner.nextInt();
            System.out.println(array.length);
            System.out.println("before");
            System.out.println(array[3]);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常捕获");
        } finally {
            //资源的关闭-》文件打开-》文件关闭
            System.out.println("finally永远会被执行的！");
        }
        System.out.println("after");
    }
}
