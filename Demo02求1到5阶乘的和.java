package 程序逻辑控制课件代码练习;
//计算 1! + 2! + 3! + 4! + 5!
public class Demo02求1到5阶乘的和 {
	public static void main(String []args) {
		int sum=0;
		int res=1;
			for(int i=1;i<=5;i++) {
				res*=i;
				sum+=res;
				System.out.println(res);
			}
			System.out.println(sum);

			
	}
}
