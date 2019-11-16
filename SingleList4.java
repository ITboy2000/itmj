package 顺序表和链表;
//节点类
class ListNode4{
    public int data;
    public ListNode4 next;
    public ListNode4(int data){
        this.data=data;
        this.next=null;
    }
}
//链表类
public class SingleList4 {
    public ListNode4 head;
    public SingleList4(){
        this.head=null;
    }
    //头插法
    public void addFirst(int data){
        ListNode4 node4=new ListNode4(data);
        //判断链表是否为空
        if (this.head==null){
            this.head=node4;
        }else{
            node4.next=this.head;
            this.head=node4;
        }
    }
    //尾插法
    public void addLast(int data){
        ListNode4 node4=new ListNode4(data);
        ListNode4 cur=this.head;
        if (this.head==null){
            this.head=node4;
        }else{
            while (cur.next!=null){
                cur=cur.next;
            }
            cur.next=node4;
        }
    }
    //得到链表长度
    public int getLength(){
        ListNode4 cur=this.head;
        int length=0;
        while (cur!=null){
            cur=cur.next;
            length++;
        }
        return length;
    }
    //任意插入
    //1.找到所插位置的前驱index-1
    private ListNode4 searchIndex(int index){
        ListNode4 cur=this.head;
        while (index-1>0){
            cur=cur.next;
            index--;
        }
        return cur;
    }
    //2.插入
    public boolean addIndex(int index,int data){
        ListNode4 node4=new ListNode4(data);
        if (index<0||index>getLength()){
            System.out.println("插入位置不合法");
            return false;
        }
        if (index==0){
         addFirst(data);
         return true;
        }else{
            ListNode4 cur=searchIndex(index);
            node4.next=cur.next;
            cur.next=node4;
        }
        return true;
    }
    //显示链表
    public void disPlay4(){
        ListNode4 cur=this.head;
        while (cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    //反转链表
    public ListNode4 reverseList(){
        ListNode4 cur=this.head;
        ListNode4 pre=null;
        ListNode4 newHead=null;
        while (cur!=null){
            ListNode4 curNext=cur.next;
            if (curNext==null){
                newHead=cur;
            }
                cur.next=pre;
                pre=cur;
                cur=curNext;
            }
        return newHead;
    }
    //显示反转链表
    public void newDisPlay(ListNode4 newHead){
        ListNode4 cur=newHead;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    //找到中间节点
    public ListNode4 middleNode(){
        //定义快慢指针，形象比喻为和女朋友跑道跑步
        ListNode4 fast=this.head;
        ListNode4 slow=this.head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    //找到倒数第k个节点
    public ListNode4 findKthToTail(int k) {
        ListNode4 fast = this.head;
        ListNode4 slow = this.head;
        //判断k合法性
        if (k < 1 || k > getLength()) {
            System.out.println("不存在");
        } else {
            while (k - 1 > 0) {
                fast = fast.next;
                k--;
            }
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }
    // 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public ListNode4 partition(int x) {
        ListNode4 cur = this.head;
        ListNode4 beforeStrat = null;
        ListNode4 beforeEnd = null;
        ListNode4 afterStrat = null;
        ListNode4 afterEnd = null;
        while (cur != null) {
            if (cur.data < x) {
                if (beforeStrat == null) {
                    beforeStrat = cur;
                    beforeEnd = beforeStrat;
                } else {
                    beforeEnd.next = cur;
                    beforeEnd = beforeEnd.next;
                }
            } else {
                if (afterStrat == null) {
                    afterStrat = cur;
                    afterEnd = afterStrat;
                } else {
                    afterEnd.next = cur;
                    afterEnd = afterEnd.next;
                }
            }
            cur = cur.next;
        }
        if (beforeStrat == null) {
            return afterStrat;
        }
        beforeEnd.next = afterStrat;
        if (afterStrat == null) {
            beforeEnd.next = null;
        }
        return beforeStrat;
    }
    //合并两个有序单链表
    public static ListNode4 mergeTwoLists(ListNode1 headA,ListNode1 headB){
        ListNode4 node4=new ListNode4(-1);
        ListNode4 temp=node4;
        while (headA!=null&&headB!=null){
            if (headA.data<headB.data){
                temp.next=headA;
                headA=headA.next;
                temp=temp.next;
            }else {
                temp.next=headB;
                headB=headB.next;
                temp=temp.next;
            }
            if (headA==null){
                temp.next=headB;
            }
            if (headB==null){
                temp.next=headA;
            }
        }
        return node4.next;
    }
}
