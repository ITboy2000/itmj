package hashTablePackage;

import java.util.Scanner;

//雇员节点类
class EmployeeNode{
    public int id;
    public String name;
    public EmployeeNode next;

    public EmployeeNode(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
//雇员链表类
class EmployeeLinkedList{
    private EmployeeNode head;
    //添加雇员（尾插法）
    public void addEmployee(EmployeeNode employeeNode){
        //判断链表是否为空，如果为空就是第一次添加
        if (head==null){
            head=employeeNode;
            return;
        }
        //不为空就找到链表最后一个位置进行插入
            EmployeeNode cur=head;
            while (true){
                if (cur.next==null){
                    break;
                }
                cur=cur.next;
            }
            //退出循环说明找到插入位置
            cur.next=employeeNode;
    }

    //显示链表信息
    public void list(int i){
        //判断链表是否为空
        if (head==null){
            System.out.println("第"+(i+1)+"链表为空");
            return;
        }
        System.out.println("第"+(i+1)+"条链表信息为：");
        //显示当前链表信息
        EmployeeNode cur=head;
        while (true){
            System.out.print("雇员信息："+"id:"+cur.id+" "+"name:"+cur.name);
            if (cur.next==null){
                break;
            }
            cur=cur.next;
        }
        System.out.println();
    }
}

//创建HashTable管理链表
class HashTable{
    private   EmployeeLinkedList[] employeeLinkedListArray;
    private int size;//表示共有多少条链表

    public HashTable(int size) {
        this.size = size;
        employeeLinkedListArray=new EmployeeLinkedList[size];
        //初始化每一条链表
        for (int i = 0; i <size ; i++) {
            employeeLinkedListArray[i]=new EmployeeLinkedList();
        }
    }

    //添加雇员
    public void addEmployee(EmployeeNode employeeNode){
        //根据雇员id确定雇员应该放在哪个链表
        int employeeLinkedListNo=hashFun(employeeNode.id);
        //加入到对应的链表中
        employeeLinkedListArray[employeeLinkedListNo].addEmployee(employeeNode);
    }

    //编写散列函数，取模
    public int hashFun(int id){
        return id%size;
    }

    //遍历哈希表
        public void list(){
            for (int i = 0; i <size ; i++) {
                employeeLinkedListArray[i].list(i);
            }
        }
}
