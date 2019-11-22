package 顺序表和链表;

public class TestSingleList5 {
    public static void main(String[] args) {
        SingleList5 singleList5=new SingleList5();
        singleList5.addFirst(1);
        singleList5.addFirst(2);
        singleList5.addFirst(3);
        singleList5.addFirst(4);
        singleList5.addFirst(5);
        singleList5.addFirst(6);
        singleList5.Del(3);
        singleList5.DisPlay();
    }
}
