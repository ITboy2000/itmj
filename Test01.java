package 递归练习;
// 递归求 N 的阶乘
import java.util.*;
public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入N:");
		int num=sc.nextInt();
		int sum=fun(num);
		System.out.println(sum);
	}
	public static int fun(int a) {
		// TODO Auto-generated method stub
		if(a==1) {//此递归终止条件为num==1
			return 1;
		}else {
			return a*fun(a-1);//阶乘规律为n=n*(n-1),fun(num-1)为递归中的递
		}
	}
}
