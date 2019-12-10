package queue;

import java.util.Scanner;

//使用数组模拟队列，创建ArrayQueue类
class ArrayQueue{
    private int maxSize;//队列最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//用于存放数据，模拟队列

    //创建队列的构造器
    public  ArrayQueue(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        front=-1;//指向队列头部， 指向队列头前一个位置
        rear=-1;//指向队列尾部，指向队列尾部具体数据
    }
    //判断队列是否为满
    public boolean isFull(){
        return rear==maxSize-1;//等于就是满的，否则不满
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //往队列添加数据
    public void addQueue(int n){
        //判断队列是否满
        if (isFull()){
            System.out.println("队列满，不能添加数据");
            return;
        }
        rear++;//rear后移
        arr[rear]=n;
    }
    //出队列
    public int getQueue(){
        //判断队列是否空
        if (isEmpty()){
            //通过抛出异常来处理
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;//front后移
        return arr[front];
    }
    //显示队列所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i<arr.length ; i++) {
            System.out.println("第"+i+"数据为："+arr[i]);
        }
    }
    //显示队列的头数据,不是取数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front+1];//因为front指向的是队列头数据的前一个位置
    }
}
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建队列
        ArrayQueue arrayQueue=new ArrayQueue(3);
        char key=' ';//接收用户输入
        Scanner sc=new Scanner(System.in);
        //创建一个菜单
        Boolean loop=true;
        //输入一个菜单
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取数据");
            System.out.println("h(head):查看队列头数据");
            key=sc.next().charAt(0);//接收用户输入字符
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数据");
                    int value=sc.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try{
                    int res=arrayQueue.getQueue();
                    System.out.println("取出的数据是："+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res=arrayQueue.headQueue();
                        System.out.println("队列头的数据是"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e'://代表退出
                    sc.close();
                    loop=false;//true会进入while循环，false不会进入while循环
                    break;
                    default:
                        break;
            }
        }
        System.out.println("程序退出！");
        /*
        * 此程序有个弊端，队列只能用一次，就不能再使用,因为不是环形队列
        * 优化：使用算法改进为环形队列,取模%方式完成
        * 思路如下：
        * 1.front变量做一个调整：front指向对列的第一个元素，front初始值为零，rear初始值为零
        * 2.rear变量做一个调整： rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定
        * 3.当队列满时：(rear+1)%maxSize=front
        * 4.当队列为空的条件：rear==front
        * 5.队列中有效的数据个数：（rear+maxSize-front）%maxSize
        * 6.修改原来代码
        * */
    }
}
