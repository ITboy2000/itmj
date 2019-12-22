package hashTablePackage;

import java.util.Scanner;

public class HashTableDemoTest {
    public static void main(String[] args) {
        //创建hash表
        HashTable hashTable=new HashTable(7);

        String key="";
        Scanner sc=new Scanner(System.in);
        boolean loop=true;
        while (loop){
            //菜单
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("exit:退出程序");
            key=sc.next();
        switch (key){
            case "add":
                System.out.println("输入id");
                int id=sc.nextInt();
                System.out.println("输入name:");
                String name=sc.next();
                EmployeeNode employeeNode=new EmployeeNode(id,name);
                hashTable.addEmployee(employeeNode);
                break;
            case "list":
                hashTable.list();
                break;
            case "exit":
                loop=false;
                sc.close();
                System.out.println("退出程序");
            default:
                break;
        }
        }
    }
}

