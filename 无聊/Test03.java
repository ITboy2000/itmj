package holidayhomework;

import java.util.Arrays;

public class Test03 {
    public static void main(String[] args) {
        String name="saeed";
        String typed="saaeeedd";
        System.out.println(isLongPressedName(name,typed));
    }
    public static boolean isLongPressedName(String name, String typed) {
        String[] str1=name.split("");
        String[] str2=typed.split("");
        boolean flag=true;
        int i=0;
        int j=0;
        while (flag){
        while (i<str1.length-1){
            while (j<str2.length-1){
                if (str2[j].equals(str1[i])){
                    j++;
                }
                if (!str2[j].equals(str1[i])){
                    i++;
                    if (!str2[j].equals(str1[i])){
                        flag=false;
                    }
                }
            }
        }
        }
        return flag;
    }
}
