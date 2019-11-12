package 力扣刷题;

public class MaoPaoSort {
    public static void main(String[] args) {
        int[] array=new int[]{3,5,1,8,7,4,6,2,9};
        maopao(array);
    }

    public static void maopao(int[] array) {
        for (int i = 0; i <array.length-1 ; i++) {
            for (int j = 0; j <array.length-1-i ; j++) {
                if (array[j+1]<array[j]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        for (int a:array){
            System.out.println(a);
        }
    }
}
