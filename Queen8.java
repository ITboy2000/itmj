package recursion;

public class Queen8 {
    //先定义一个max表是有多少个皇后
    int max=8;
    //定义一个array，保存皇后放置位置结果
    int[] array=new int[max];
    static int count=0;
    public static void main(String[] args) {
        //测试八皇后是否正确
        Queen8 queen8=new Queen8();
        queen8.check(0);
        System.out.println("一共有"+count+"种解法" );
    }
    //写一个放置第n个皇后的方法
    //注意：check 每一次递归时进入到check中都有for (int i = 0; i <max ; i++)    ，因此会有回溯
    private void check(int n){
        if (n==max){//n==8，说明已经放到了第九个皇后，前八个皇后已经放好了，n从0开始
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i <max ; i++) {
            //先把当前皇后放到该行的第一列
            array[n]=i;
            //判断当放置第n皇后到i列时，是否冲突
            if (judge(n)){//不冲突
                //接着放n+1个皇后，开始递归
                check(n+1);//产生回溯
            }
            //如果冲突，就继续执行array[n]=i;，i在变化，将第n个皇后放在本行的后移的一个位置
        }
    }

    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放好的皇后位置产生冲突
    /*
    * n表示第n个皇后
    * */
    private boolean judge(int n){
        for (int i = 0; i <n ; i++) {
            /*
            * 1.array[i]==array[n]判断第n个皇后是否和第n-1个皇后在同一列
            * 2.Math.abs(n-i)==Math.abs(array[n]-array[i])判断第n个皇后是否和第n-1个皇后在同一斜线
            * 3.比如：n=1，代表第二个皇后，放在第二行第二列 n=1 array[1]=1;
            * Math.abs(1-0)==1 Math.abs(array[n]-array[i])=Math.abs(1-0)==1;Math.abs()求绝对值
            * 3.不必判断是否在同一行，因为n在变化
            * */
            if (array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){//如果相等说明在同一列,同一斜线(斜率相同)
                return false;
            }
        }
        return true;
    }
    //写一个可将皇后摆放最后结果输出的方法
    private void print(){
        count++;
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

}
