/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-12-01
 * Time: 11:39
 */
public class TestDemo2 {


    public static void main(String[] args) {
        String str = "abc";
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb);
    }

    public static void main3(String[] args) {
        StringBuilder sb = new StringBuilder("ab");
        sb.append("gaobo");
        StringBuffer sb2 = new StringBuffer("cd");
        sb2.append("Java13");
        sb.reverse();
        System.out.println(sb);//
        System.out.println(sb2);
    }

    public static void main2(String[] args) {

        //String str = "ab";
        StringBuilder sb = new StringBuilder("ab");
        for (int i = 0; i < 1000; i++) {
            //str += i;
            //str = str+i;
            sb.append(i);
        }
        System.out.println(sb);


        /*String str = "abcdef";
        str = str + "gh";
        System.out.println(str);*/
        /*StringBuilder sb = new StringBuilder();
        sb.append("abcdef");
        sb.append("gh");
        String str = sb.toString();
        System.out.println(str);*/
    }
    /**
     * 字符串String的+的 拼接 底层被优化为StringBuilder
     * append();
     * toString();
     * @param args
     */
    public static void main1(String[] args) {
        String str = "abcdef";
        str = str + "gh";
        System.out.println(str);


        /*StringBuilder sb = new StringBuilder("abcdef");
        System.out.println(sb);
        sb.append("Java13666");
        System.out.println(sb);*/
    }
}
