package search;

import java.util.Arrays;

//线性查找
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr={-1,11,58,62,11};
        int[] index=new int[arr.length];//用来记录目标值在原始数组中的索引
        seqSearch(arr,index,11);
    }
    public static void  seqSearch(int[] arr, int[] index, int value){
        int count=-1;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]==value){
                count++;
                index[count]=i;
            }
        }
        if (count==-1){
            System.out.println("数组中不存在目标值");
        }else {
            System.out.println("目标值的索引值为：");
            for (int i = 0; i <index.length ; i++) {
                if (index[i]!=0){
                    System.out.print(index[i]+" ");
                }
            }
        }
    }
}
