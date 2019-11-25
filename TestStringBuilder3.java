package String;

public class TestStringBuilder3 {
    public static void main(String[] args) {

        //循环累加字符串一定要用StringBuilder
        StringBuilder sb=new StringBuilder();
        String str="";
        for (int i = 0; i <5000 ; i++) {
            sb.append(i);
        }
        System.out.print(sb+" ");
    }
}
