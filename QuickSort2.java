package Sort;

import java.util.Arrays;

//快速排序
public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr={4,3,2,1,5,9,8,7,6,};
        quickSort(arr,0,arr.length-1);
        System.out.println("快速排序后的数组为："+Arrays.toString(arr));
    }

    //递归调用
    public static void quickSort(int[] arr,int left,int right){
        if (left<right){
            int index=quick(arr,left,right);
            //向左递归
            quickSort(arr, left, index-1);
            System.out.println(Arrays.toString(arr));
            //向右递归
            quickSort(arr, index+1, right);
            System.out.println(Arrays.toString(arr));
        }
    }


    //快速排序代码
    public static int quick(int[] arr,int left,int right){
        int val=arr[left];//定义待排序列最左边元素为参照值
        while(left<right){//符合条件进入循环
            while(left<right&&arr[right]>=val){//从序列右边往左遍历，直到找到小于参照值的元素
                right--;
            }
            //退出循环说明找到符合元素，将符合元素放入到参照元素所在位置
            if (left<right){
                //将符合条件元素放入参照值所在位置
                arr[left]=arr[right];
                left++;
            }

            while (left<right&&arr[left]<val){//从序列左边往右遍历，直到找到大于参照值的元素
                left++;
            }
            if (left<right){
                //将符合条件元素放入参照值所在位置
                arr[right]=arr[left];
                right--;
            }
        }
        //退出while循环就代表一次快速排序已经完成
        arr[left]=val;
        return left;
    }
}
