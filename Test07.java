package 蓝桥杯习题.蓝桥杯习题练习;

import java.util.Arrays;

public class Test07 {
    public static void main(String[] args) {
        char[] s=new char[]{'a','b','c','d','e'};
        int slow=0;
        int fast=s.length-1;
        while (slow<=fast){
            char temp=s[slow];
            s[slow]=s[fast];
            s[fast]=temp;
            slow++;
            fast--;
        }
        System.out.println(Arrays.toString(s));
    }
}
