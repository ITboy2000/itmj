package 类和对象;
import java.util.*;
public class Demo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请设置初始密码：");
        String mima1 = sc.nextLine();
        int count = 3;
        while (count != 0) {
            System.out.println("请输入密码：");
             String mima2 = sc.nextLine();
            if (mima2.equals(mima1)) {
                System.out.println("登录成功！");
                sc.close();
                break;
            } else {
                count--;
                System.out.println("你还要有" + count + "次机会!");
            }
        }
        if (count == 0) {
            System.out.println("登录失败");
        }
    }
}


