package 程序逻辑控制课件代码练习;
//求5的阶乘
public class Demo01求阶乘 {
	public static void main(String []args) {
		int num=1;
		int res=1;
		while(num<=5) {
			res*=num;
			num++;
		}
		System.out.println(res);
	}
}
