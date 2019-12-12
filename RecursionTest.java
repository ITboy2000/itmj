package recursion;
//递归问题:方法自己调用自己，每次调用传入不同的值
public class RecursionTest {
    public static void main(String[] args) {
        //打印问题
        int n=10;
        test(n);
    }
    public static void test(int n){
        if (n>1){
            test(n-1);
        }
        System.out.println("n="+n);
    }
}
