package �����߼�������ҵ;
// ���0��999֮������С�ˮ�ɻ������������(��ˮ�ɻ�������ָһ����λ�������λ���ֵ�������ȷ�õ��ڸ�����
//���磻153��1��5��3?����153��һ����ˮ�ɻ�������)
public class FindTheNumberCalledShuiXianHuaBetween0And999 {
	public static void main(String []args) {
			for(int i=100;i<=999;i++) {
				int a=i%10;
				int b=((i-a)/10)%10;
				int c=i/100;
				 int sum=(int) (Math.pow(a, 3)+Math.pow(b, 3)+Math.pow(c, 3));
				 if(sum==i) {
					 System.out.println(i);
				 }
			}
			
	}
}
