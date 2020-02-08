package holidayhomework;

import java.util.Arrays;

public class Test06 {
    public static void main(String[] args) {
        int[] nums={3,-1,-1};
        int res=thirdMax(nums);
        System.out.println(res);
    }
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int temp=0;
        int count=0;
        for (int i = nums.length-1; i >0 ; i--) {
            if (nums[i-1]<nums[i]){
                 temp=nums[i-1];
                count++;
            }
            if (count==2){
                break;
            }
        }
        if (count==2){
            return temp;
        }
        return nums[nums.length-1];
    }
}
