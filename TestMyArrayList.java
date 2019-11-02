package 顺序表和链表;

public class TestMyArrayList {
    public static void main(String[] args) {
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(0,1);
        myArrayList.add(0,2);
        myArrayList.add(0,3);
        myArrayList.add(0,4);
        myArrayList.add(0,5);
        myArrayList.display();
        myArrayList.contains(6);
        System.out.println(myArrayList.contains(6));

    }
}
