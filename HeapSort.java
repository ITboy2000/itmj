package Sort;

import java.util.Arrays;

//堆排序
public class HeapSort {
    public static void main(String[] args) {
        //将数组进行升序排序，采用大根堆
        int[] arr={4,6,8,5,9};
        //传参
        heapSort(arr);
    }
    //编写一个堆排序的方法
    public static void heapSort(int[] arr){
        System.out.println("堆排序！");
        int temp=0;

        //分步完成
        /*adjustHeap(arr,1,arr.length);
        System.out.println("第一次调整"+Arrays.toString(arr));//4,9,8,5,6
        adjustHeap(arr,0,arr.length);
        System.out.println("第二次调整"+Arrays.toString(arr));//9,6,8,5,4*/
        //最终代码
        //将无序序列构建成一个堆，根据需要，构建大根堆或小根堆
        for (int i =arr.length/2-1; i>=0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }

        /*
        * 1.将堆顶元素与末尾元素为进行交换，将最大元素降到数组末端
        * 2.重新调整结构，使其满足堆的定义，然后继续交换，反复执行调整+交换
        * */
        for (int j = arr.length-1; j>0 ; j--) {
            //交换
            temp=arr[j];
            arr[j]=arr[0];  //arr[0]是最大值
            arr[0]=temp;
            adjustHeap(arr,0,j);
        }

        System.out.println(Arrays.toString(arr));
    }
    //将一个数组调整成一个大根堆
    /*
    * 此方法功能：完成将以i对应的非叶子节点的的树调整为大根堆（局部调整）
    * i=arr.length/2-1
    * 比如：{4,6,8,5,9}，第一次i=1，就是节点6，以节点6为父节点进行调整==》{4,9,8,5,6}
    * arr：待调整的数组
    * i：当前非叶子节点在数组中的索引
    * length：待调整元素的个数，逐渐减少
    * */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp=arr[i];//取出当前节点，保存在临时变量中
        //开始调整，k=i*2+1,k是i节点的左子节点
        for (int k =i*2+1; k <length ; k=k*2+1) {
            if (k+1<length&&arr[k]<arr[k+1]){//说明左子节点值小于右子节点的值
                k++;//k指向右子节点
            }
            if (arr[k]>temp){//如果子节点值大于父节点值
                arr[i]=arr[k];//把较大的值赋值给当前节点
                i=k;//i指向k，继续比较
            }else {
                break;//
            }
            
        }
        //for循环结束后说明：以i为父节点的子树已经把最大值放在了i的位置
        arr[i]=temp;//将temp的值放在调整后的位置
    }
}
