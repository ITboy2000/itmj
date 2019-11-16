package 顺序表和链表;

public class TestSingleList4 {
    //合并两个有序的单链表
//    public static ListNode mergeTwoLists(ListNode headA, ListNode headB) {
//        ListNode curA=headA;
//        ListNode curB=headB;
//        ListNode node = new ListNode(-1);
//        ListNode tmp = node;
//
//        while (headA != null && headB != null) {
//            if (headA.data < headB.data) {
//                tmp.next = headA;
//                headA = headA.next;
//                tmp = tmp.next;
//            } else {
//                tmp.next = headB;
//                headB = headB.next;
//                tmp = tmp.next;
//            }
//        }
//        if (headA != null) {
//            tmp.next = headA;
//        }
//        if (headB != null) {
//            tmp.next = headB;
//        }
//        return node.next;
//    }
    public static void main(String[] args) {
        SingleList4 singleList4=new SingleList4();
        singleList4.addLast(1);
        singleList4.addLast(5);
        singleList4.addLast(3);
        singleList4.addLast(4);
        singleList4.addLast(2);
        singleList4.addLast(3);
        singleList4.addLast(7);
//        singleList4.disPlay4();
//        ListNode4 node4=singleList4.reverseList();
//        singleList4.newDisPlay(node4);
        ListNode4 node=singleList4.middleNode();
        System.out.println(node.data);
        ListNode4 node1=singleList4.findKthToTail(8);
        ListNode4 node4=singleList4.partition(4);
        singleList4.newDisPlay(node4);
    }
}
