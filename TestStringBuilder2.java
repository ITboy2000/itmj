package String;

public class TestStringBuilder2 {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <26 ; i++) {
            char temp=(char)('a'+i);
            sb.append(temp);
        }
        System.out.println(sb);
        sb.reverse();//倒序
        System.out.println(sb);
        sb.setCharAt(3,'马');
        System.out.println(sb);
        sb.insert(3,'我').insert(4,'爱').insert(5,'你');
        //链式调用，该方法调用了return this，把自己返回了
        System.out.println(sb);

        sb.delete(20,23);
        System.out.println(sb);
    }
}
