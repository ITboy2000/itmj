package �ݹ���ϰ;
// �ݹ��� N �Ľ׳�
import java.util.*;
public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("������N:");
		int num=sc.nextInt();
		int sum=fun(num);
		System.out.println(sum);
	}
	public static int fun(int a) {
		// TODO Auto-generated method stub
		if(a==1) {//�˵ݹ���ֹ����Ϊnum==1
			return 1;
		}else {
			return a*fun(a-1);//�׳˹���Ϊn=n*(n-1),fun(num-1)Ϊ�ݹ��еĵ�
		}
	}
}
