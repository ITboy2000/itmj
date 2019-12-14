package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//冒泡排序算法时间复杂度：O(n^2),两个for循环;
/*
* 基本思想：通过对待排序序列从前向后（从下标较小的开始），
* 依次比较相邻元素的值，如果发现逆序则交换，使较大的值逐渐向后移动，
* 如果在一趟排序过程没有进行交换过，那么代表序列有序，可以对冒泡排序进行优化，减少不必要的比较
* */
public class BubbleSorting {
    public static void main(String[] args) {
        int[] array=new int[]{1,5,2,3,9,7,4,8,6,10};
        //测试排序时间
        Date date1=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str=simpleDateFormat.format(date1);
        System.out.println("排序前的时间："+date1Str);
        bubbleSort(array);
        Date date2=new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+date2Str);
    }
    public static void  bubbleSort(int[] array){
        int count=0;
        System.out.println("排序前的数组情况：");
        System.out.println(Arrays.toString(array));
        for (int i = 0; i <array.length-1; i++) {//外层循环排序趟数,最多进行array.length-1趟排序
            //进入排序前先记录待排数组
            String str1=Arrays.toString(array);
            for (int j = 0; j <array.length-1-i; j++) {//内层循环两两交换
                /*
                 * for (int j = 0; j <array.length-1-i; j++)说明：
                 * 每趟冒泡排序都能确定一个较大数的位置
                 * 所以进入下一次排序只需要排上次排序后较大数前所有的元素，所以内层循环每次减一
                 * */
                if (array[j]>array[j+1]){//如果前一个元素大于后一个元素，交换两个元素位置
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
            String str2=Arrays.toString(array);//记录排序一趟后的数组情况
            if (str2.equals(str1)){//如果一趟排序先后和排序之前数组相等那么就退出循环
                break;
            }else {//如果不相等，排序次数加一
                count++;
            }
        }
        System.out.println("排序后的数组：");
        System.out.println(Arrays.toString(array));
        System.out.println("排序趟数："+count);
    }
}
