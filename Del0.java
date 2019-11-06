package 蓝桥杯习题.蓝桥杯习题练习;
import java.util.*;
public class Del0 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入数据个数");
        int num=sc.nextInt();
        int []array=new int[num];
        for (int i = 0; i <array.length ; i++) {
            array[i]=sc.nextInt();
        }
        CompactIntegers(array);
    }

    public static void CompactIntegers(int[] array) {
        int count=0;
        for (int i = 0; i <array.length ; i++) {
            if (array[i]!=0){
                count++;
                System.out.print(array[i]+" ");
            }
        }
        System.out.println();
        System.out.println(count);
    }
}
