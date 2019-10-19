package 程序逻辑控制作业;
// 求出0～999之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本
//身，如；153＝1＋5＋3?，则153是一个“水仙花数”。)
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
