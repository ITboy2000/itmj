package 顺序表和链表;
//复杂链表的节点由三个域组成：data(数据域);next(后继);random(随机);
//将带有随机random的链表进行深拷贝
class OldListNode{
    public int data;
    public OldListNode next;
    public OldListNode random;
    public OldListNode(int data){//一个参数的构造方法
        this.data=data;
        this.next=null;
        this.random=null;
    }
    //复杂链表
    public OldListNode(int data,OldListNode next,OldListNode random){//三个参数的构造方法
        this.data=data;
        this.next=next;
        this.random=random;
    }
}
class ComplexList {
    public OldListNode head;
    public ComplexList() {
        this.head = null;
    }
    public OldListNode addLast1(int data) {
        OldListNode cur = this.head;
        OldListNode node = new OldListNode(data);//初始化一个节点
        if (head == null) {//单链表是空
            this.head = node;
        } else {
            while (cur.next != null) {//cur.next==null 说明是最后一个节点
                cur = cur.next;
            }
            cur.next = node;
        }
        cur=head;
        return cur;
    }
    //复杂链表的复制分为三步
    //1：将新老节点串起来
    //2：解决random中的域的问题
    //3：拆分两个单链表
    public OldListNode copyRandomList(OldListNode oldHead){
        if(oldHead==null){
            return null;//当单链表传过来的时候为空，就返回一个null表示无法进行copy
        }
        OldListNode cur=oldHead;
        //1：创建一个个的新的节点将其串起来
        while(cur!=null){
            OldListNode newNode=new OldListNode(cur.data,cur.next,null);//新的节点保存老节点的data中的值
            OldListNode temp=cur.next;
            cur.next=newNode;
            cur=temp;
        }
        //退出循环后将cur重置即可，弄random
        //2：解决random指针即可
        cur=oldHead;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }else {
                //当cur.random==null
                cur.next.random=null;//将新节点的random也置空，也就是将其不变的赋值即可
            }
            cur=cur.next.next;//判断老节点的下一个
        }
        //3：进行拆分单链表
        cur=oldHead;
        OldListNode newHead=cur.next;
        while(cur.next!=null){//到串联后的单链表的最后一个节点
            OldListNode temp=cur.next;
            cur.next=temp.next;
            cur=temp;
        }
        return newHead;
    }
    public void disPlay(OldListNode head){
        OldListNode cur=head;
        System.out.println("复制后的单链表为：");
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
    }
}