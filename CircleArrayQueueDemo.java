package queue;

import java.util.Scanner;

class CiecleArray{
    /*
    * 1.front变量做一个调整：front指向对列的第一个元素，front初始值为零，rear初始值为零
     * 2.rear变量做一个调整： rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定
     * 3.当队列满时：(rear+1)%maxSize==front
     * 4.当队列为空的条件：rear==front
     * 5.队列中有效的数据个数：（rear+maxSize-front）%maxSize
     * */
    private int maxSize;//队列最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//用于存放数据，模拟队列

    public CiecleArray(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        front=0;
        rear=0;
    }
    //判断队列是否为空
    public boolean isFull(){
        return (rear+1)%maxSize==front;
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
        //直接将数据加入，因为环形队列中rear指向的是最后一个元素的后一个位置
        arr[rear]=n;
        //添加完数据后，rear需要后移，必须考虑取模
        rear=(rear+1)%maxSize;
    }

    //出队列
    public int getQueue(){
        //判断队列是否空
        if (isEmpty()){
            //通过抛出异常来处理
            throw new RuntimeException("队列空，不能取数据");
        }
        //front指向的是队列的第一个元素
        //1.先把front对应的值保存到一个临时变量
        //2.将front后移,考虑取模,不然可能越界
        //3.将临时保存的变量返回
        int value=arr[front];
        front=(front+1)%maxSize;
        return value;
    }

    //求出当前队列有效数据的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    //显示队列所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        //从front开始遍历，遍历多少个元素
        for (int i = front; i<front+size() ; i++) {
            System.out.println("第"+i%maxSize+"数据为："+arr[i%maxSize]);
        }
    }

    //显示队列的头数据,不是取数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front];//front指向对列的第一个元素
    }

}
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //测试数组模拟环形队列
        //创建环形队列
        CiecleArray ciecleArray=new CiecleArray(4);//设为4说队列有效数据最多为3个，因为有一个空间作为约定
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
                    ciecleArray.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数据");
                    int value=sc.nextInt();
                    ciecleArray.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res=ciecleArray.getQueue();
                        System.out.println("取出的数据是："+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res=ciecleArray.headQueue();
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
    }
}
