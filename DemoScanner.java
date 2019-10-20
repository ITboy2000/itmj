package 程序逻辑控制课件代码练习;
import java.util.*;
//使用 Scanner 读取字符串/整数/浮点数
public class DemoScanner {
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);//从键盘输入
		System.out.println("请输入你的姓名：");
		String name=sc.nextLine();
		System.out.println("请输入你的年龄:");
		int age=sc.nextInt();
		System.out.println("请输入你的工资:");
		float salary=sc.nextFloat();
		System.out.println("你的信息如下:");
		System.out.println("姓名："+name+"\n"+"年龄："+age+"\n"+"工资："+salary);
		sc.close();//注意，要记得调用关闭方法
	}
}
