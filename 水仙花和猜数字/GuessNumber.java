package 程序逻辑控制作业;
import java.util.*;
/**系统自动生成一个随机整数(1-100), 然后由用户输入一个猜测的数字. 如果输入的数字比该随机数小, 提示 "低
了", 如果输入的数字比该随机数大, 提示 "高了" , 如果输入的数字和随机数相等, 则提示 "猜对了" .*/
public class GuessNumber {
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入你猜测的数字：");
		int toGuess =(int) (Math.random()*(100-1+1)+1);
		while(true) {
			int num=sc.nextInt();
		if(num<toGuess) {
			System.out.println("猜小了");
		}else if(num>toGuess) {
			System.out.println("猜大了");
		}else {
			System.out.println("猜对了，好厉害");
			break;
		}
		}
		sc.close();
		}
	}
		/**try {
			int num=sc.nextInt();
		if(isGuiDing(num)) {	
		}else {
			System.out.println("不符合规定");
		}
		}catch(Exception e) {
			System.out.println("请输入1-100整数：");//捕捉异常，输入的不是整数；输出异常
		}
	}

	private static boolean isGuiDing(int a) {
		// TODO Auto-generated method stub
		boolean flag=true;
		int toGuess =(int) (Math.random()*(100-1+1)+1);
		if(a<1||a>100) {
			return false;
		}else {
			if(a<toGuess) {
				System.out.println("猜小了");
			}else if(a>toGuess) {
				System.out.println("猜大了");
			}else {
				System.out.println("猜对了，好厉害");
		}
			flag=true;
		}
		return flag;
	}
}*/
