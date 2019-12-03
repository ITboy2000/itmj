/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-12-01
 * Time: 17:10
 */
public class TestDemo5 {

    public static MyLinkedList.Node mergeList(MyLinkedList.Node headA
            ,MyLinkedList.Node headB) {
        /*MyLinkedList myLinkedList = new MyLinkedList();
        MyLinkedList.Node newHead = myLinkedList.new Node(-1);*/
        MyLinkedList.Node newHead =
                new MyLinkedList.Node(-1);
        MyLinkedList.Node tmp = newHead;
        while (headA != null && headB != null) {
            if(headA.data < headB.data) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if(headA != null) {
            tmp.next = headA;
        }
        if(headB != null) {
            tmp.next = headB;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insertTail(1);
        myLinkedList.insertTail(2);
        myLinkedList.insertTail(3);
        myLinkedList.insertTail(4);
        myLinkedList.display();
        MyLinkedList myLinkedList2 = new MyLinkedList();
        myLinkedList2.insertTail(1);
        myLinkedList2.insertTail(2);
        myLinkedList2.insertTail(3);
        myLinkedList2.insertTail(4);
        myLinkedList2.display();

        MyLinkedList.Node ret =
                mergeList(myLinkedList.head,myLinkedList2.head);
        myLinkedList.display2(ret);

    }
}
