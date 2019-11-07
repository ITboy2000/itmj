package 蓝桥杯习题.蓝桥杯习题练习;
import java.util.*;
public class Test02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] str=new String[]{"-","2","-","a","-"};
        System.out.println("输入ch:");
        String ch=sc.nextLine();
        System.out.println("ch:"+ch);
        for (int i = 0; i <str.length ; i++) {
            if (!str[i].equals(ch)){
                System.out.print(str[i]);
            }
        }
    }
}
