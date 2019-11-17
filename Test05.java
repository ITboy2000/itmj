package 蓝桥杯习题.蓝桥杯习题练习;
import  java.util.*;
public class Test05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //5
       /* System.out.println("输入单词长度：");
        int size=sc.nextInt();
        int count=0;
        String[] a=new String[size];
        System.out.println("输入单词：");
        for (int i = 0; i <size ; i++) {
             a[i]=sc.next();
        }
        System.out.println(Arrays.toString(a));
        for (int i = 0; i <size ; i++) {
            String temp=a[i];
            if (a[i].equals("a")||a[i].equals("e")||
                    a[i].equals("i")||a[i].equals("o")||a[i].equals("u")){
                System.out.println(a[i]);
                break;
            }else {
                System.out.println("n");
                break;
            }
        }*/
        System.out.println("请输入n：");
        int n = sc.nextInt();
        int[] array=new int[n];
        for (int i = 0; i <n ; i++) {
            array[i]=i+1;
        }
        func(array,n);
    }

    public static void func(int[] array,int n) {
        int count=n;
        for (int i = 0; i <array.length ; i++) {
            while (array[i]%10!=0||array[i]/10!=0){
                int a=array[i]%10;
                if (a==2){
                    count--;
                    break;
                }else {
                    array[i]=(array[i]-a)/10;
                }
            }
        }
        System.out.println();
        System.out.println(count);
    }
}