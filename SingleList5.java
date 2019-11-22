package 顺序表和链表;
//节点类
class ListNode6{
    public int data;
    public ListNode6 next;

    public ListNode6(int data) {
        this.data = data;
        this.next = null;
    }
}

//链表类
public  class SingleList5{
    public ListNode6 head;

    public SingleList5() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data){
        ListNode6 node6=new ListNode6(data);
        //判断是否为第一次插入
        if (head==null){
            this.head=node6;
        }else {
            node6.next=this.head;
            this.head=node6;
        }
    }

    //删除倒数第n个节点
    public ListNode6 Del(int n){
        ListNode6 fast=this.head;
        ListNode6 slow=this.head;

        //如果链表为空或者链表只有一个节点，返回null
        if (this.head==null||this.head.next==null){
            return null;
        }
        //先让fast走n步
        for (int i = 0; i <n ; i++) {
            fast=fast.next;
        }
        //如果待删除节点为第一个节点，那么fast走了n步之后就为空
        if (fast==null){
//            this.head=this.head.next;
//            return  this.head;
            return this.head.next;
        }

        //如果待删除节点为第二个节点，那么fast走了n步之后fast的next就为空
        if (fast.next==null){
            slow.next=slow.next.next;
            return slow;
        }

        //若果待删除节点不是特殊节点，那么让fast多走一步，为了使slow指向待删除节点的前一个节点
        fast=fast.next;
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return this.head;

    }

    public void DisPlay(){
        ListNode6 cur=this.head;
        while (cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
    }
}