package 力扣刷题;
//快速排序：分而治之
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{0, 5,0, 0, 0, 8, 2, 9, 1,};
        quickSort(array,0,array.length-1);
        for (int a:array){
            System.out.print(a+" ");
        }
    }

    public static void quickSort(int data[],int left,int right) {
        int l=left;//做下标
        int r=right;//右下标
        //pivot中轴是中轴值,基准值
        int pivot=data[(left+right)/2];
        int temp=0;//临时变量，交换时使用
        //while循环目的是让比pivot之小的值放到左边
        //比pivot大的放到右边
        while(l<r){
            //在pivot左边一直找，找到大于或等于pivot的值，再推出
            while (data[l]<pivot){
                l+=1;
            }
            //在pivot右边一直找，找到小于或等于pivot的值，再推出
            while(data[r]>pivot){
                r-=1;
            }
            //如果l>=r说明pivot的左右两边的值已经按照左边全部是小于等于pivot的值
            //右边全部是大于等于pivot的值
            if (l>=r){
                break;
            }
            //交换
            temp=data[l];
            data[l]=data[r];
            data[r]=temp;

            //如果交换完后发现这个data[l]==pivot的值，r--前移一下
            if (data[l]==pivot){
                r-=1;
            }
            //如果交换完后发现这个data[r]==pivot的值，l++后移一下
            if (data[r]==pivot){
                l+=1;
            }
        }
        //如果说l==r，必须l++，r--，否则会栈溢出
        if (l==r){
            l+=1;
            r-=1;
            //向左递归
            if (left<r){
                quickSort(data,left,r);
            }
            if (right>l){
                quickSort(data,l,right);
            }
        }
    }
}

