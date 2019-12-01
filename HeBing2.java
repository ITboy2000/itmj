package 力扣刷题;

import java.util.Arrays;

public class HeBing2 {
    public static void main(String[] args) {
        int[] nums1={0,1,3,5,7,9};
        int[] nums2={0,2,4,6,8,10};
        int length=nums1.length+nums2.length;
        int[] nums3=new int[length];
        int k=0;
        int l=0;
        while (k<length){
            while (k<nums1.length){
                nums3[k]=nums1[k];
                k++;
            }
            while (l<nums2.length){
                nums3[k]=nums2[l];
                k++;
                l++;
            }
        }
        Arrays.sort(nums3);
        System.out.println(Arrays.toString(nums3));
        }
    }
