import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-12-01
 * Time: 9:03
 */
public class TestDemo1 {




    public static String reverse(String str) {
        char[] value = str.toCharArray();
        int left = 0;
        int right = value.length-1;
        while (left < right) {
            char tmp = value[left];
            value[left] = value[right];
            value[right] = tmp;
            left++;
            right--;
        }
        return String.copyValueOf(value);
    }

    public static void main5(String[] args) {
        String str = "abcdefg";
        System.out.println(reverse(str));
    }

    public static void main3(String[] args) {

        String str = null;
        String str2 = "";
        if(str2.isEmpty()) {
            System.out.println("abcd");
        }

       /* String str = "ABCDEF";
        str = str.concat("HELLO");
        System.out.println(str);*/

        //String string = str.substring(0,3);
        //KMP算法-》查找子串在主串当中的位置
        //System.out.println(string);
    }

    public static void main2(String[] args) {
        String str = "abc ad ab";
        String[] strings = str.split(" ",2);
        System.out.println(Arrays.toString(strings));

        String str2 = "192*168*1*1";
        String[] strings2 = str2.split("\\*");//
        System.out.println(Arrays.toString(strings2));


        String str3 = "abc=def ght=gb";
        String[] strings3 = str3.split(" ");
        System.out.println(Arrays.toString(strings3));

        for (String s : strings3  ) {
            String[] ss = s.split("=");
            System.out.println(Arrays.toString(ss));
        }

        /*String str = "abcadab";
        //str = str.replaceAll("ab","ly");
        str = str.replaceFirst("ab","py");
        System.out.println(str);*/
    }


    public static void main1(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = {97,98,99,100};
        String str = new String(bytes,1,2);
        System.out.println(str);
        String str2 = "DE";
        byte[] bytes1 = str2.getBytes();
        System.out.println(Arrays.toString(bytes1));
        String str3 = "高";
        byte[] bytes2 = str3.getBytes("utf8");
        System.out.println(Arrays.toString(bytes2));

        String str4 = "ABCDEFDE";

        System.out.println(str2.equals(str4));
        System.out.println(str2.equalsIgnoreCase(str4));

        System.out.println(str2.compareTo(str4));//str2   和 str4进行比较

        System.out.println(str4.contains(str2));
        System.out.println(str4.indexOf(str2,4));
        //fromindex:从后边的这个位置开始往前面找
        System.out.println(str4.lastIndexOf(str2,5));
        System.out.println(str4.startsWith("CD",2));
        System.out.println(str4.endsWith("DE"));
    }
}
