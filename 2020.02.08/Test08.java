package holidayhomework;

import java.util.Arrays;

public class Test08 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 6, 1,9,18};
        int target = 8;
        int[] res = searchRange(nums, target);
        System.out.println(Arrays.toString(res));

    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res1 = {-1, -1};
        int[] res2 = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                    res2[0] = i;
                    break;
            }
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == target) {
                    res2[1] = i;
                    break;
            }
        }
        int flag=0;
            for (int i = 0; i <nums.length ; i++) {
                if (nums[i]==target){
                    flag=0;
                    break;
                }else {
                    flag=1;
                }
            }
            if (flag==0){
                return res2;
            }else {
                return res1;
            }
    }
}
