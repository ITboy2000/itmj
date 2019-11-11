package 力扣刷题;

import java.util.Arrays;
//编写一个函数来查找字符串数组中的最长公共前缀。
//如果不存在公共前缀，返回空字符串 ""。
public class FindTheSameLongestStr {
    public static void main(String[] args) {
        String[] array=new String[]{"abcdef","abcdefg","abcde","abc"};
        longestCommonPrefix(array);
    }

    public static void longestCommonPrefix(String[] array) {
        if(array.length == 0){
            System.out.println("字符串数组为空！");;
        }else {
            String temp;
            //进行冒泡排序
            for(int i =0;i<array.length-1;i++) {//排序趟数
                for(int j=0;j<array.length-i-1;j++) {
                    if(array[j+1].length()<array[j].length()) {
                        temp = array[j];
                        array[j]=array[j+1];
                        array[j+1]=temp;
                    }
                }
            }
            String str=array[0];
            for(int i = 1; i < array.length; i++){
                while(array[i].indexOf(str) != 0){
                    str=str.substring(0, str.length() - 1);
                }
            }
            System.out.println(str);
        }

    }
}
