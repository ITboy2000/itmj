package �����߼�������ҵ;
import java.util.*;
/**ϵͳ�Զ�����һ���������(1-100), Ȼ�����û�����һ���²������. �����������ֱȸ������С, ��ʾ "��
��", �����������ֱȸ��������, ��ʾ "����" , �����������ֺ���������, ����ʾ "�¶���" .*/
public class GuessNumber {
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("��������²�����֣�");
		int toGuess =(int) (Math.random()*(100-1+1)+1);
		while(true) {
			int num=sc.nextInt();
		if(num<toGuess) {
			System.out.println("��С��");
		}else if(num>toGuess) {
			System.out.println("�´���");
		}else {
			System.out.println("�¶��ˣ�������");
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
			System.out.println("�����Ϲ涨");
		}
		}catch(Exception e) {
			System.out.println("������1-100������");//��׽�쳣������Ĳ�������������쳣
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
				System.out.println("��С��");
			}else if(a>toGuess) {
				System.out.println("�´���");
			}else {
				System.out.println("�¶��ˣ�������");
		}
			flag=true;
		}
		return flag;
	}
}*/
