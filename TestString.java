package String;

public class TestString {
    public static void main(String[] args) {
        //创建字符串
        //1.
        String str="abc";//这种字符串常量会被放在常量池中
        //2.
        String str2="def";
        //3.拼接，左右两边只要有一个是字符类型那么拼接后就是字符类型
        String str3="abc"+"def";
        String str4="18"+19;//不是加法
        System.out.println(str4);
        System.out.println("***********************");

        String str5="majian";
        String str6="majian";
        String str7=new String("majian");
        System.out.println(str5==str6);
        System.out.println(str5==str7);//显示为false，因为是新建的，跟其他字符串相比是不同的对象
        //当TestString被加载之后，我们定义的被双引号引起来的
        // 如str,str2,str3,str4,5,6对自动放在常量池里面，放的是引用地址
        //通常比较字符串内容是否相同使用的是equals
        System.out.println(str6.equals(str7));

    }
}
