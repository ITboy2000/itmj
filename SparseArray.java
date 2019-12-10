package sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        //创建原始数组，11*11
        //0:没有棋子 1：黑子  2：蓝子
        int[][] chessAry1=new int[11][11];
        chessAry1[1][2]=1;
        chessAry1[5][3]=2;
        chessAry1[6][6]=1;
        //输出原始二维数组
        System.out.println("输出原始的二维数组：");
        for (int[] row:chessAry1){
            for (int data:row){
                System.out.print(" "+data+" ");
            }
            System.out.println();
        }

        //二维数组转稀疏数组步骤：

        //1.先遍历数组得到非零数据个数
        int sum=0;
        for (int i = 0; i <chessAry1.length ; i++) {
            for (int j = 0; j <chessAry1.length ; j++) {
                if (chessAry1[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println("非零数据个数"+sum);
        //创建稀疏数组:稀疏数组第一行表示原始数组有多少行多少列，非零数据个数
        int[][] sparseAry=new int[sum+1][3];
        //给稀疏数组赋值
        sparseAry[0][0]=chessAry1.length;
        sparseAry[0][1]=chessAry1.length;
        sparseAry[0][2]=sum;

        //遍历二维数组,将非零的值存放在稀疏数组中

        int count=0;//用来记录第几个非零数据
        for (int i = 0; i <chessAry1.length ; i++) {
            for (int j = 0; j <chessAry1.length ; j++) {
                if (chessAry1[i][j]!=0){
                    count++;
                    sparseAry[count][0]=i;
                    sparseAry[count][1]=j;
                    sparseAry[count][2]=chessAry1[i][j];
                }
            }
        }
        //输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组");
        for (int i = 0; i <sparseAry.length ; i++) {
            System.out.println(sparseAry[i][0]+" "+sparseAry[i][1]+" "+sparseAry[i][2]);
        }
        System.out.println();
        //将稀疏数组恢复成二维数组
        //1.先读取稀疏数组第一行,根据第一行创建原始数组
        int[][] chessAry2=new int[sparseAry[0][0]][sparseAry[0][1]];

        //2.在读取后后几行数据并赋值给原始二维数组
        for (int i=1;i<sparseAry.length;i++){
            chessAry2[sparseAry[i][0]][sparseAry[i][1]]=sparseAry[i][2];
        }
        //输出恢复后的二维数组
        for (int[] row:chessAry2){
            for (int data:row){
                System.out.print(" "+data+" ");
            }
            System.out.println();
        }
    }
}
