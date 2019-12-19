package Sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={8,4,5,7,1,3,6,2};
        int[] temp=new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println("归并排序后："+Arrays.toString(arr));
    }

    //分+和
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left<right){
            int mid=(left+right)/2;//中间索引
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);

            //向右递归进行分解
            mergeSort(arr, mid+1, right, temp);

            //到合并时
            merge(arr, left,mid ,right, temp);
        }
    }
    //合并的方法
    /*
    * arr排序原始数组
    * left左边有序序列的索引
    * mid中间索引
    * right右边有序序列索引
    * temp中转数组
    * */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;//初始化i左边有序序列的索引
        int j=mid+1;//初始化j右边有序序列索引
        int t=0;//指向当前temp数组的当前索引

        //1.先把左右两边数据按规则填充到temp数组中，直到左右两边序列有一边处理完毕
        while (i<=mid&&j<=right){//继续
            if (arr[i]<=arr[j]){//如果左边序列元素小于右边序列元素，就把左边元素填充到temp中
                temp[t]=arr[i];
                t++;
                i++;
            }else {//arr[i]>arr[j]
                temp[t]=arr[j];
                t++;
                j++;
            }
        }
        //2.把有剩余的一边的数据一次全部填充到temp
        while (i<=mid){//说明左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t]=arr[i];
            t++;
            i++;
        }

        while (j<=right){//说明右边的有序序列还有剩余的元素，就全部填充到temp
            temp[t]=arr[j];
            t++;
            j++;
        }
        //3.将temp数组中的元素拷贝到arr
        //并不是每次都拷贝所有的
        t=0;
        int tempLeft=left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            t++;
            tempLeft++;
        }
    }
}
