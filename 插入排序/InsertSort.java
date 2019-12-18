package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//插入排序，从小到大进行排序
public class InsertSort {
    public static void main(String[] args) {
        int[] array={-1,8,7,2,3,9,4,2,1,6};
        Date date1=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String date1Str=simpleDateFormat.format(date1);
        System.out.println("排序前的时间："+date1Str);
        insertSort(array);
        Date date2=new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+date2Str);
        System.out.println("排序后的数组为："+Arrays.toString(array));
    }
    //插入排序方法
    public static void insertSort(int[] array){
        for (int i = 1; i <array.length ; i++) {//总共需要进行array.length-1轮排序，因为第一个元素为有序
            int insertVal=array[i];//定义待插入元素，从原始数组的第二个元素开始
            int insertIndex=i-1;//定义从带插入元素的前一个元素开始比较

            //使用while循环进行插入
            /*
            * 1.insertIndex>=0此条件防止数组越界
            * 2.insertVal<=array[insertIndex]此条件成立说明待插入元素还没有找到插入位置
            * 因为要是将待插入元素插入到有序列表后，后一个元素一定会大于等于前一个元素
            *{-1,8,7,2,3,9,4,5,1,6}
            * 举例，在插入7的时候{-1,8,7,2,3,9,4,5,1,6}=>{-1,8,8,2,3,9,4,5,1,6}=>{-1,7,8,2,3,9,4,5,1,6}
            * 举例：在插入2的时候{-1,7,8,2,3,9,4,5,1,6}=>{-1,7,8,8,3,9,4,5,1,6}=>{-1,7,7,8,3,9,4,5,1,6}
            * while循环退出后{-1,2,7,8,3,9,4,5,1,6},因为此时2不小于-1
            * while循环退出的条件是，待插入元素不在小于前面的元素，也就是比前面的元素都大
            * */
            while (insertIndex>=0&&insertVal<=array[insertIndex]){
                array[insertIndex+1]=array[insertIndex];//如果待插入元素小于前面的元素，那么就让前面的元素向后移动
                insertIndex--;
            }
            //当退出while循环后说明插入位置的前一个元素的索引已经找到了，就是insertIndex
            array[insertIndex+1]=insertVal;
        }
    }
}
