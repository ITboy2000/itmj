package 顺序表和链表;

public class TestMySingleList {
    public static void main(String[]args){
        MySingleList mySignalList = new MySingleList();
        mySignalList.addLast(1);
        mySignalList.addLast(2);
        mySignalList.addLast(3);
        mySignalList.addLast(4);
        mySignalList.addLast(3);
        mySignalList.addLast(4);
        mySignalList.addLast(3);
        mySignalList.addLast(4);
//        mySignalList.addFirst(6);
//        mySignalList.addLast(4);
//        mySignalList.remove(2);
        mySignalList.removeAllKey(6);
        mySignalList.display();
//        int size = mySignalList.size();
//        System.out.println(size);
//        mySignalList.addIndex(4,15);
//        mySignalList.display();
//        mySignalList.contains(20);
//        System.out.println(mySignalList.contains(20));
        mySignalList.clear();
        mySignalList.display();
//        mySignalList.addIndex(0,19);
//        mySignalList.display();
//        mySignalList.addIndex(5,29);
//        mySignalList.display();
//        mySignalList.addIndex(1,99);
//        mySignalList.display();
        /*System.out.println(mySignalList.contains(3));
        System.out.println(mySignalList.contains(13));

        System.out.println(mySignalList.getLength());*/

    }
}
