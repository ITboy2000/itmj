package holidayhomework;

import java.util.Arrays;

public class Test07 {
    public static void main(String[] args) {
        String a = "1";
        String b = "11";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        if (a.length()<b.length()){
            String temp=a;
            a=b;
            b=temp;
        }
        String[] str1 = a.split("");
        String[] str2 = b.split("");
        String[] str3 =new String[str1.length+1];
        int flag=0;//记录需不需要进位，0不需要进位，1需要进位
        for (int i = str1.length-1; i >0 ; i--) {
            if (!str1[i].equals(str2[i])&&flag==0){//如果字符串内容相同并且为"0",那么str[i]-->"0",flag-->0
                str1[i]="1";
                flag=0;
                continue;
            }
            if (!str1[i].equals(str2[i])&&flag==1){
                str1[i]="0";
                flag=0;
                continue;
            }
            if (str1[i].equals(str2[i])&&flag==0){
                str1[i]="0";
                flag=1;
                continue;
            }
            if (str1[i].equals(str2[i])&&flag==1){
                str1[i]="1";
                flag=1;
                continue;
            }
        }
        if (flag == 0) {
        return Arrays.toString(str1);
        }else if (flag==1){
            str3[0]="1";
            str3[1]="0";
            str3[2]=str1[1];
            str3[3]=str1[2];
            str3[4]=str1[3];
        }
        return Arrays.toString(str3);
    }
}
