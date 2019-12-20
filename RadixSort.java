package Sort;

import java.util.Arrays;

//基数排序,这段代码只适用于元素都为整数的数组排序，若有负数会出现数组越界异常
/*
* 如要实现含有负数的基数排序
* 基本思想：
* 1.将原始数组分割为两个模块，一个模块都是负数，一个模块都是正数。将负数模块全部转为正数，两个模块分别进行基数排序
*2.将基数排序后的负数数组（之前先进行了转正）,转为负数，然后使用Arrays.sort()按顺序排列;
* 3.两个数组进行合并
* */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr={-53,3,542,748,14,-214};
        //如果数组中含有负数，那么就分割，正数放在一个数组，负数放在一个数组
        //1.提取负数
        int count=0;//记录负数个数
        for (int i = 0; i <arr.length ; i++) {//循环遍历原始数组计算负数个数
            if (arr[i]<0){
                count++;
            }
        }
        int[] arr1=new int[count];//定义负数数组
        int count1=0;
        while (count1<count){//将原始数组中负数放入负数数组
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]<0){
                arr1[count1]=arr[i];
                count1++;
            }
        }
        }

        //2.提取正数
        int[] arr2=new int[arr.length-count];//定义正数数组
        int count2=0;
        while (count2<arr2.length){//将原始数据中的正数放在整数数组
            for (int i = 0; i <arr.length ; i++) {
                if (arr[i]>=0){
                    arr2[count2]=arr[i];
                    count2++;
                }
            }
        }

        //3.将负数数组中的元素转为正数,为基数排序做准备
        for (int i = 0; i <arr1.length ; i++) {
            arr1[i]*=-1;
        }
        radixSort(arr1);
        radixSort(arr2);
        System.out.println("正数数组基数排序后："+Arrays.toString(arr2));

        //4.将负数数组基数排序后的数组元素转为负数
        for (int i = 0; i <arr1.length ; i++) {
            arr1[i]*=-1;
        }
        //5.将转化后的负数数组顺序排列
        Arrays.sort(arr1);
        System.out.println("负数数组基数排序后："+Arrays.toString(arr1));

        //6.将正数数组与负数数组合并,即将正数数组与负数数组重元素填充到原始数组以到达目的
        int count3=0;
        while (count3<arr.length){
            for (int i = 0; i <arr1.length ; i++) {//提取负数
                arr[count3]=arr1[i];
                count3++;
            }
            for (int i = 0; i <arr2.length ; i++) {//提取正数
                arr[count3]=arr2[i];
                count3++;
            }
        }

        //输出合并后的数组
        System.out.println("基数排列后原始数组变化为"+Arrays.toString(arr));


    }
    public static void radixSort(int[] arr){
        //（一）得到数组中最大数的位数确定进行多少轮排序
        //1.得到数组中最大的数
        int max=arr[0];
        for (int i =1 ; i <arr.length ; i++) {
            if (arr[i]>max){
                max=arr[i];
            }
        }
        //2.得到最大数的位数
        int maxLength=(max+"").length();

        //(二)
        // 1.定义一个二维数组表示十个桶，每一个桶就是一个一维数组，即二维数组的每一行就是一个桶
        int[][] bucket=new int[10][arr.length];//10：就代表二维数组有10行；arr.length：代表一个桶最多10个元素
        //2.定义一个一位数组记录每一个桶每次放入数据的个数
        int[] bucketElementCounts=new int[10];//数组长度大小为10，表示一个桶最多每次放入10个元素

        //(三)
        //循环处理
       /* 说明：因为每次要按照元素各各位元素大小进行放置，举例：
        * 对于123取各个位的数字：
        * 1.123%10
        * 2.123/10%10
        * 3.123/100%10
        * 所以说这里的变量n就代表需要对元素进行对应的取整
        * */
        for (int i = 0, n=1; i <maxLength ; i++,n*=10) {//排序趟数
            //对出数组中的元素进行取各个位上的数
            for (int j = 0; j <arr.length ; j++) {
                int digitOfElement=arr[j]/n%10;//取出来的数也代表当前元素应该放在那个桶中
                //每对一个元素进行取数后就放进对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];

               /* * bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];这句话不好理解，在此解释一下
                * [digitOfElement]:和每次对元素取余的数有关，代表当前元素在哪一个桶，即在二维数组的哪一行
                * [bucketElementCounts[digitOfElement]：表示当前元素在哪一列，即在当前轮排序中一个桶中有几个元素
                * */
                bucketElementCounts[digitOfElement]++;
            }
            //一轮排序完成后将各个桶中的元素按顺序放入原始数组中
            int index=0;//定义从原始数组的0号下标开始放置
            //遍历每一个桶，即遍历二维数组每一行
            for (int k = 0; k < bucketElementCounts.length; k++) {//bucketElementCounts.length:代表一共几个桶
                //不做无用功，只有当前桶中有数据我们才进行放置
                if (bucketElementCounts[k]!=0){//每个桶中的元素个数！=0就代表当前桶中有元素
                    for (int l = 0; l <bucketElementCounts[k] ; l++) {
                        arr[index]=bucket[k][l];
                        index++;
                    }
                }
                //每将一个桶中的元素放回原始数组后就将当前桶中元素个数清零，为下一次排序做准备
                bucketElementCounts[k]=0;
            }
        }
    }
}
