package holidayhomework;

import java.util.Arrays;

//j-Ih-gfE-dCba
//abcdefghi
public class Test04 {
    public static void main(String[] args) {
        String S="a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(S));
    }
    public static String reverseOnlyLetters(String S) {
        char[] str1=S.toCharArray();
        char[] str2=new char[str1.length];
        StringBuilder s=new StringBuilder(S);
        s.reverse();
        char[] str3=s.toString().toCharArray();
        int k=0;
        for (int i = 0; i <str3.length ; i++) {
            if(str3[i]>=65&&str3[i]<=90 ||str3[i]>=97 &&str3[i]<=122){
                str2[k]=str3[i];
                k++;
            }
        }
        for (int i = 0; i <str1.length ; i++) {
            if (str1[i]<65||str1[i]>90&&str1[i]<97||str1[i]>122){
                char temp=str1[i];
                int index=i;
                for (int j = str2.length-1; j >index ; j--) {
                    str2[j]=str2[j-1];
                }
                str2[index]=temp;
            }
        }
        String str4="";
        for (int i = 0; i <str2.length ; i++) {
            str4+=str2[i];
        }
        return str4;
    }
}
