package search;

import java.util.ArrayList;
import java.util.List;

//对二查找的功能完善，找到数组中所有目标值
//一定要注意使用二分查找的数组必须有序！！！！！！！！！！！！！
public class BinarySearch2 {

    public static void main(String[] args) {
        int[] arr={0,1,2,3,4,4,4,4};
         List<Integer> resIndexList=binarySearch(arr,0,arr.length-1,4);
        System.out.println("目标值索引集合："+resIndexList);

    }
    //二分查找代码
    public static ArrayList<Integer> binarySearch(int[] arr,int left,int right,int findValue){
        if (left>right){//如果left>right说明目标元素不存在，返回-1
            return new ArrayList<Integer>();//如果不存在就返回空的ArrayList，主方法中根据ArrayList长度进行判断是否存在目标值
        }
        int mid=(left+right)/2;//定义中间索引
        int midValue=arr[mid];//定义中间值
        if (findValue>midValue){//如果目标元素大于中间元素，向右递归查找
            return binarySearch(arr,mid+1,right,findValue);
        }else if (findValue<midValue){//如果目标元素小于中间元素，向左递归查找
            return binarySearch(arr,left,mid-1,findValue);
        }else {
            /*
            * 找数组中所有目标值的索引思路如下：
            * 1.找到mid之后不要马上返回
            * 2.向mid左边扫描将满足目标值索引的所有元素下表加入到ArrayList集合当中
            * 3.向mid右边扫描将满足目标值索引的所有元素下表加入到ArrayList集合当中
            * 4.返回集合
            * */

            //创建索引集合
            ArrayList<Integer> resIndexList= new ArrayList<Integer>() ;
            //向mid左边扫描将满足目标值索引的所有元素下表加入到ArrayList集合当中
            int temp=mid-1;
            while (true){
                if (temp<0||arr[temp]!=findValue){
                    break;
                }
                //否则就将左边目标值下标放入resIndexList中
                resIndexList.add(temp);
                temp-=1;//向前继续扫描
            }
            //将一开始找到的mid加入到resIndexList中
            resIndexList.add(mid);

            //向mid右边扫描将满足目标值索引的所有元素下表加入到ArrayList集合当中
            temp=mid+1;
            while (true){
                if (temp>arr.length-1||arr[temp]!=findValue){
                    break;
                }
                //否则就将左边目标值下标放入resIndexList中
                resIndexList.add(temp);
                temp+=1;//向后继续扫描
            }
            return resIndexList;
        }
    }
}
