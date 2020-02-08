package holidayhomework;

import java.util.Arrays;

public class Test10 {
    public static void main(String[] args) {
       int[] nums={2,1,1,1,1,1};
        int length=findUnsortedSubarray(nums);
        System.out.println(length);
    }
    public static int findUnsortedSubarray(int[] nums) {
        int[] nums2=Arrays.copyOf(nums,nums.length);
        String s1="";
        String s2="";
        String s3="";
        String s4="";
        if (nums.length==2){
            for (int i = 0; i <nums.length ; i++) {
                s3+=nums[i];
            }
            System.out.println("s3-->"+s3);
            Arrays.sort(nums);
            for (int i = 0; i <nums.length ; i++) {
                s4+=nums[i];
            }
            System.out.println("s4-->"+s4);
            if (s3.equals(s4)){
                return 0;
            }
            return 2;
        }
        for(int i=0;i<nums2.length;i++){
            s1+=nums2[i];
        }
        Arrays.sort(nums2);
        for(int i=0;i<nums2.length;i++){
            s2+=nums2[i];
        }
        if(s1.equals(s2)){
            return 0;
        }
        int temp1=0;
        int temp2=0;
        int flag1=0;
        for (int i = nums.length-1; i >0 ; i--) {
            for (int j = nums.length-2; j >0 ; j--) {
                if (nums[i]<nums[j]){
                    temp2=i;
                    flag1=1;
                    break;
                }
            }
            if (flag1==1){
                break;
            }
        }
        System.out.println("temp2-->"+temp2);
        int flag=0;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 1; j <nums.length ; j++) {
                if (nums[i]>nums[j]){
                    temp1=i;
                    flag=1;
                    break;
                }
            }
            if (flag==1){
                break;
            }
        }
        System.out.println("temp1-->"+temp1);
        int temp3=temp2-temp1+1;
        return temp3;

    }
}
