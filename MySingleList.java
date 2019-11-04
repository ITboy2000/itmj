package 顺序表和链表;

// 1、无头单向非循环链表实现


     class MySingleList{
         class ListNode{
             public int data;
             public ListNode next;
             public ListNode(int data){
                 this.data=data;
                 this.next=null;
             }
         }

         public ListNode head;
         public MySingleList(){

             this.head=null;
         }
         //头插法
         public void addFirst(int data){
             ListNode node=new ListNode(data);
             if (this.head==null){
                 this.head=node;
             }else{
                 node.next=this.head;
                 this.head=node;
             }
         }
         //尾插法
         public void addLast(int data){
             ListNode node=new ListNode(data);
             ListNode cur=this.head;
             if (this.head==null){
                 this.head=node;
             }else {
                 while(cur.next!=null){
                     cur=cur.next;
                 }
                 cur.next=node;
             }
         }
         private  ListNode searchIndex(int index){
             ListNode cur=this.head;
             //cur-->index-1
             int count=0;
             while (count<index-1){
                 count++;
                 cur=cur.next;
             }
             return cur;
         }
         public ListNode reverseList(){
             ListNode cur=this.head;
             ListNode prev=null;
             ListNode newHead=null;
             while(cur!=null){
                 ListNode curNext=cur.next;
                 cur.next =prev;
                 prev=cur;
                 cur=curNext;
                 curNext=cur.next;
                 if(curNext==null){
                    newHead=cur;
                 }
             }
             return newHead;
         }
         //任意位置插入,第一个数据节点为0号下标
         public boolean addIndex(int index,int data) {
             if (index < 0 || index > size()) {
                 System.out.println("index不合法!");
                 return false;
             }
             if (index == 0) {
                 addFirst(data);
                 return true;
             }
             //找到index-1的位置
             ListNode cur=searchIndex(index);
             ListNode node=new ListNode(data);
             node.next=cur.next;
             cur.next=node;
             return true;
         }
         //查找是否包含关键字key是否在单链表当中
         public boolean contains(int key){
             ListNode cur=this.head;
             while(cur!=null){
                 if (cur.data==key){
                     return true;
                 }
                 cur=cur.next;
             }
             return false;
         }
         //找到待删除节点的前驱
         private ListNode searchPre(int key){
             ListNode pre=this.head;
             while (pre.next!=null){
                 if (pre.next.data==key){
                     return pre;
                 }
                 pre=pre.next;
             }
             return null;
         }
         //删除第一次出现关键字为key的节点
         public void remove(int key){
             //判断链表是否为空
             if(this.head==null){
                 System.out.println("单链表为空");
                 return;
             }
             //判断待删除节点是否为第一个节点
             if (this.head.data==key){
                 this.head=this.head.next;
             }
             //找到待删除节点的前驱
             ListNode pre=searchPre( key);
             if (pre==null){
                 return;
             }
             ListNode del=pre.next;
             pre.next=del.next;
         }
         //删除所有值为key的节点
         public void removeAllKey(int key){
             ListNode cur=this.head;
             ListNode pre=this.head;
             while(cur!=null){
                 if (pre.next.data==key){
                     pre.next=cur.next;
                     cur=cur.next;
                 }
                 else{
                     pre=cur;
                     cur=cur.next;
                 }
             }
             if (this.head.data==key){
                 this.head=this.head.next;
             }
         }
         //得到单链表的长度
         public int size(){
             int count=0;
             ListNode cur=this.head;
             while (cur!=null){
                 count++;
                 cur=cur.next;
             }
             return  count;
         }
         public void display(){
             ListNode cur=this.head;
             while(cur!=null){
                 System.out.print(cur.data+" ");
                 cur=cur.next;
             }
             System.out.println();
         }
         public void clear(){
//             ListNode cur=this.head;
//             cur.next=null;
             this.head=null;
         }


     }
