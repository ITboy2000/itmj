package Sort;

import java.util.Arrays;

//选择排序
public class SelectSort {
    public static void main(String[] args) {
        int[] array={9,4,2,7,1,3,5,8,6};
        System.out.println("排序前的数组");
        System.out.println(Arrays.toString(array));
        selectSort(array);
        System.out.println("排序后的数组");
        System.out.println(Arrays.toString(array));
    }
    //选择排序
    public static void selectSort(int[] array){
        for (int i = 0; i <array.length-1 ; i++) {
            /*
            * 在排序之前首先假定待排序列的最小值为待排序列的第一个元素
            * 说明：选择排序的思想是每一趟找出一个最小的数放在待排序列的第一个位置
            * 所以下一次排序是要从最小元素的下一个元素开始选择排序
            * 举例：一轮选择排序后的待排序列情况为{}里面的序列 1{4,2,7,9,3,5,8,6}
            * */
            int minIndex=i;//假定最小元素的索引为待排序列的第一个元素索引
            int min=array[i];//假定最小值为待排序列的第一个元素
            for (int j = i+1; j <array.length ; j++) {//内层循环一趟找出一个最小的数放在array[0]
                if (min>array[j]){
                    min=array[j];
                    minIndex=j;
                }
            }
            if (minIndex!=i){
            array[minIndex]=array[i];
            array[i]=min;
            }
        }
    }
}
