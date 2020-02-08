package holidayhomework;

import java.util.Arrays;

public class Test09 {
    public static void main(String[] args) {
        String str="   4193 with words";

    }
    public static int myAtoi(String str) {
        String[] s1=str.trim().split(" ");
        String s2="";
        for (int i = 0; i <s1.length ; i++) {
            s2+=s1[i];
        }
        char[] s3=s2.toCharArray();
        String temp="";
        if (s3[0]==43||s3[0]==45||s3[0]>=48&&s3[0]<=57){
            temp+=s3[0];
            for (int i = 1; i <s3.length ; i++) {
                if (s3[i]>=48&&s3[i]<=57){
                    temp+=s3[i];
                }else {
                    break;
                }
            }
            System.out.println(temp);
        }else{
            System.out.println("不符合规定");
        }
        return 1;
    }
}
