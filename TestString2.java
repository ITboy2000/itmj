package String;
//测试String类的常用方法
public class TestString2 {
    public static void main(String[] args) {
       /* String str1="ma jian ma jian";
        String str2="Majian";
        System.out.println(str1.charAt(3));//提取下标为3的字符,从0开始
        System.out.println(str2.length());//字符串长度
        System.out.println(str1.equals(str2));//比较字符串内容是否相等，区分大小写
        System.out.println(str1.equalsIgnoreCase(str2));//忽略大小写
        System.out.println(str1.indexOf("jian3"));//返回第一次出现jian的索引值，查不到返回-1
        String s=str1.replace(" ","&");//将字符串中的空格替换为指定字符
        System.out.println(s);*/
       String s="";
       String s1="how are you";
        System.out.println(s1.startsWith("how"));//字符串是否以指定字符开始
        System.out.println(s1.endsWith("you"));//字符串是否以指定字符结尾
        s=s1.substring(4);//提取字符串；从下标为4的开始直到字符结尾
        System.out.println(s);
        s=s1.substring(4,7);//提取字符串，[4,7)，不包括7
        System.out.println(s);
        s=s1.toLowerCase();//转小写
        System.out.println(s);
        s=s1.toUpperCase();//转大写
        System.out.println(s);
        String s2=" how are you! ";
        s=s2.trim();//去除字符串首尾空格，中间空格不能去
        System.out.println(s);
        System.out.println(s2);//s2不变

    }
}
