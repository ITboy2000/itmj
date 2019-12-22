package search;

import java.util.Arrays;

//斐波那契（黄金分割法查找）查找
public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr={1,2,5,7,8,9};
        System.out.println("index="+fibSearch(arr,7));

    }
    public static int maxSize=20;
    //斐波那契查找使用公式：mid=left+f(k-1)-1
    //非递归的到斐波那契数列
    public static int[] fib(){
        int[] f=new int[maxSize];
        f[0]=1;
        f[1]=1;
        for (int i = 2; i <f.length ; i++) {
            f[i]=f[i-1]+f[i-2];
        }
        System.out.println(Arrays.toString(f));
        return f;
    }

    //斐波那契查找代码
    /*
    * arr原始数组
    * key查找值
    * 找到就返回对应下标，没有就返回-1
    * */
    public static int fibSearch(int[] arr,int key){
        int left=0;
        int right=arr.length-1;
        int k=0;//斐波那契分割数值对应下标
        int mid=0;//存放mid值
        int[] f=fib();//获取斐波那契数列
        //获取斐波那契数列分割数值下标
        while (right>f[k]-1){//说明没有找到
            k++;
        }
        //因为f[k]可能大于数组arr的长度，所以我们要使用Arrays类构造一个新的数组指向arr[]
        //构建的新数组不足的部分使用0填充
        int[] temp=Arrays.copyOf(arr,f[k]);
        //对新的数组不足的部分使用原始数组最后一个元素进行填充
        for (int i = right+1; i <temp.length ; i++) {
            temp[i]=arr[right];
        }
        //使用while循环找到key
        while (left<=right){
            mid=left+f[k-1]-1;
            if (key<temp[mid]){
                //向数组左边查找
                right=mid-1;
                //为什么是k--?
                /*
                * 1.全部元素=左边元素+右边元素
                * 2.f[k]=f[k-1]+f[k-2]
                * 前面有f[k-1]个元素，所以就可以继续拆分，f[k-1]=f[k-2]+f[k-3];
                * 在f[k-1]的前面继续查找
                * 下次循环mid=f[k-1-1]-1
                * */
                k--;
            }else if (key>temp[mid]){
                //向数组右边查找
                left=mid+1;
                //为什么是k-=2?
                /*
                 * 1.全部元素=左边元素+右边元素
                 * 2.f[k]=f[k-1]+f[k-2]
                 * 后面有f[k-2]个元素，所以就可以继续拆分，f[k-1]=f[k-3]+f[k-4];
                 * 在f[k-2]的前面继续查找
                 * 下次循环mid=f[k-1-2]-1
                 * */
                k-=2;
            }else {//找到了
                //需要确定返回哪个下标
                if (mid<right){
                    return mid;
                }else{
                    return right;
                }
            }
        }
        return -1;
    }
}
