package µ›πÈ¡∑œ∞;
//µ›πÈ«Û 1 + 2 + 3 + ... + 10
public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=10;
		int sum=fun(num);
		System.out.println(sum);
	}
	public static int fun(int a) {
		if(a==1) {
			return 1;
		}else {
			return a+fun(a-1);
		}
	}
}
