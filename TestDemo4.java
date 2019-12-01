package String;
import java.util.*;
public class TestDemo04 {
    public static String func(String str){
        char[] array=str.toCharArray();
        int left=0;
        int right=str.length()-1;
        while (left<right){
            char temp=array[left];
            array[left]=array[right];
            array[right]=temp;
            left++;
            right--;
        }
        return new String(array);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入反转字符串位置：");
        int size=sc.nextInt();
        System.out.println("输入字符串：");
        String s=sc.next();
        String s2=s.substring(0,3);
        String s3=s.substring(3);
        String ret1=func(s2);
        String ret2=func(s3);
        String s4=ret1+ret2;
        String ret3=func(s4);
        System.out.println(ret3.toString());

    }
}
