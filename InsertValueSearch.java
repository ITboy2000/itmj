package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//插值查找
//使用的公式：定义标杆下标 ：mid=left+(right-left)*(findValue-arr[left])/(arr[right]-arr[left]);
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,7,7,8,9};
        List resIndexList=insertValueSearch(arr,0,arr.length-1,7);
        System.out.println("目标值的索引值集合为："+resIndexList);
    }

    //插值查找代码
    public static List<Integer> insertValueSearch(int[] arr, int left, int right, int findValue){
        if (left>right||findValue<arr[0]||findValue>arr[arr.length-1]){
            return new ArrayList<Integer>();
        }
        int mid=left+(right-left)*(findValue-arr[left])/(arr[right]-arr[left]);
        int midValue=arr[mid];
        if (findValue>midValue){
            return insertValueSearch(arr, mid+1, right, findValue);
        }else if (findValue<midValue){
            return insertValueSearch(arr, left, mid-1, findValue);
        }else{
            ArrayList<Integer> resIndexList=new ArrayList<Integer>();
            int temp=mid-1;
            while (true){
                if (left<0||arr[temp]!=midValue){
                    break;
                }
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);

            temp=mid+1;
            while (true){
                if (left>arr.length-1||arr[temp]!=midValue){
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }
}
