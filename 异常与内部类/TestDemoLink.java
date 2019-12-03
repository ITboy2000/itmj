import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-12-01
 * Time: 17:04
 */

class MyLinkedList {
     static class Node {
        public int data;
        public Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    public Node head;

    public void insert(int data) {
         Node node = new Node(data);
         if(this.head == null) {
             this.head = node;
         }else {
             node.next = this.head;
             this.head = node;
         }
    }


    public void insertTail(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
        }else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public void display( ) {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void display2(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}

