package holidayhomework;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
      int[] nums={1,2,3,4,5,6,7};
      int[] nums2=rotate(nums,3);
        System.out.println(Arrays.toString(nums2));
    }
    private static int[] rotate(int[] nums, int k){
        for (int i = k; i>0 ; i--) {
            int temp=nums[nums.length-1];
            for (int j =nums.length-1; j>0 ; j--) {
                nums[j]=nums[j-1];
            }
            nums[0]=temp;
        }
        return nums;
    }
}
