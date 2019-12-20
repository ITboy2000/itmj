package search;
//二分查找
/*
* 使用二分查找的数组必须有序
* */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        int index=binarySearch(arr,0,arr.length-1,4);
        if (index==-1){
            System.out.println("不存在目标值");
        }else{
            System.out.println("目标值索引为："+index);
        }
    }
    //二分查找代码
    public static int binarySearch(int[] arr,int left,int right,int findValue){
        if (left>right){
            return -1;
        }
        int mid=(left+right)/2;//定义中间索引
        int midValue=arr[mid];//定义中间值
        if (findValue>midValue){//如果目标元素大于中间元素，向右递归查找
            return binarySearch(arr,mid+1,right,findValue);
        }else if (findValue<midValue){//如果目标元素小于中间元素，向左递归查找
            return binarySearch(arr,left,mid-1,findValue);
        }else {
        //如果找到就返回mid，mid此时就是目标值的索引
            return mid;
        }
    }
}
