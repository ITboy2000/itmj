package Sort;

import java.util.Arrays;

//希尔排序
public class ShellSort {
    public static void main(String[] args) {
        int[] arr={8,9,1,7,2,3,5,4,6,0};
        shellSort(arr);
    }

    //希尔排序代码
    public static void shellSort(int[] arr){
        int temp=0;//临时变量存储交换元素
        int count=0;//计数器，计算排序趟数
        /*
        * delta为分组情况，也是每组元素间隔
        * */
        for (int delta =arr.length/2; delta>0 ;delta=delta/2) {//当delta=delta/2=0时，退出循环
            for (int i =delta; i <arr.length ; i++) {//遍历每一组原素
                //遍历各组中所有元素，共有delta组，每组元素间隔为delta，每组进行直接插入排序
                for (int j = i-delta; j>=0 ;j=j-delta) {//如果j>5，那么j-5=0满足最内层循环条件，继续执行内层循环
                    if (arr[j]>=arr[j+delta]){
                        temp=arr[j];
                        arr[j]=arr[j+delta];
                        arr[j+delta]=temp;
                    }
                }
            }
            count++;
            System.out.println("希尔排序第"+count+"轮"+"排序结果为"+Arrays.toString(arr));
        }
    }
}
