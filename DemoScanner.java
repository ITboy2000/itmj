package �����߼����ƿμ�������ϰ;
import java.util.*;
//ʹ�� Scanner ��ȡ�ַ���/����/������
public class DemoScanner {
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);//�Ӽ�������
		System.out.println("���������������");
		String name=sc.nextLine();
		System.out.println("�������������:");
		int age=sc.nextInt();
		System.out.println("��������Ĺ���:");
		float salary=sc.nextFloat();
		System.out.println("�����Ϣ����:");
		System.out.println("������"+name+"\n"+"���䣺"+age+"\n"+"���ʣ�"+salary);
		sc.close();//ע�⣬Ҫ�ǵõ��ùرշ���
	}
}
