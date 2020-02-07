package holidayhomework;

public class Test05 {
    public static void main(String[] args) {
        int nums[] = {-1,0,-1,0,1,1};
        int index = pivotIndex(nums);
        if (index == -1) {
            System.out.println("不存在中心索引");
        } else {
            System.out.println("中心索引为：" + index);
        }
    }

    public static int pivotIndex(int[] nums) {
        if (nums.length == 0 || nums.length == 1 ||
                nums.length == 2 || nums.length == 3) {
            return -1;
        }
        int index=0;
        int sum1=0;
        int sum2=0;
        for (int i = 0; i <nums.length ; i++) {
            index=i;
            for (int j = 0; j <index+1 ; j++) {
                sum1+=nums[j];
            }
            System.out.println("sum1:"+sum1);
            for (int k = index+1; k <nums.length ; k++) {
                sum2+=nums[k];
            }
            System.out.println("sum2:"+sum2);
            if (sum1==sum2){
                break;
            }else if (index==nums.length-1&&sum1!=sum2){
                index=-1;
                break;
            }
            sum1=0;
            sum2=0;
        }
        return index;
    }
}
