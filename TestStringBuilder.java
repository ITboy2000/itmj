package String;
//测试StringBulider StringBuffer,可变字符序列，字符可以修改
public class TestStringBuilder {
    public static void main(String[] args) {
        String str;

        //StringBuilder和StringBuffer区别：前者效率高，线程不安全；后者效率低，线程安全，一般采用前者
        StringBuilder sb=new StringBuilder("abcdefg");
        System.out.println(Integer.toHexString(sb.hashCode()));//打印哈希地址
        System.out.println(sb);

        sb.setCharAt(2,'M');
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);
    }
}
