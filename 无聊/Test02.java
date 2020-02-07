package holidayhomework;

import java.util.Arrays;

public class Test02 {
    public static void main(String[] args) {
        String ransom = "love";
        String magazine = "iloveyou";
        System.out.println(canConstruct(ransom, magazine));
    }
    private static boolean canConstruct(String ransomNote, String magazine) {
        String[] str1=ransomNote.split("");
        String[] str2=magazine.split("");
        String str3="";
        for (int i = 0; i <str1.length ; i++) {
            for (int j = 0; j <str2.length ; j++) {
                if (str1[i].equals(str2[j])){
                    str3=str3+str2[j];
                    str2[j]="";
                    break;
                }
            }
        }
        if (str3.equals(ransomNote)){
            return true;
        }
        return false;
    }
}
