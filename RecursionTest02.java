package recursion;

public class RecursionTest02 {
    public static void main(String[] args) {
        //递归实现阶乘6!=6*5*4*3*2*1
        int n=5;//5!=120
        int res=test(n);
        System.out.println(res);
    }
    public static int test(int n){
        if (n==1){
            return 1;
        }
        return n*test(n-1);
    }
}
