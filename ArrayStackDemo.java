package stack;

import java.util.Scanner;

//定义一个ArrayStack表示栈
class ArrayStack{
    private int maxSize;//栈的大小
    private int[] stack;//栈的数据存在该数组中
    private int top=-1;//top表示栈顶，没有数据时为-1

    //构造器
    public ArrayStack(int maxSize){
        this.maxSize=maxSize;
        stack=new int[this.maxSize];
    }

    //判断栈是否为满
    public boolean isFull(){
        return top==maxSize-1;
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return top==-1;
    }

    //入栈
    public void Push(int value){
        //判断栈是否未满
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;
    }

    //出栈,将栈顶的数据返回
    public int Pop(){
        //判断栈是否空
        if (isEmpty()){
            //抛出异常
           throw new RuntimeException("栈空");
           //return;//不需要return，抛出异常本身就带有终止程序
        }
        int value=stack[top];
        top--;
        return value;
    }

    //显示栈的情况
    public void disPlay(){
        //遍历时需要从栈顶开始显示数据
        if (isEmpty()){
            System.out.println("栈空，没有数据");
            return;
        }
        for (int i = top; i>=0 ; i--) {//从栈顶开始遍历
            System.out.println("第"+i+"个数据为"+stack[top]+" ");
        }

    }
}

public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试数组模拟栈
        //创建一个ArrayStack对象表示栈
        ArrayStack arrayStack=new ArrayStack(4);
        String key=" ";
        Boolean loop=true;
        Scanner sc=new Scanner(System.in);
        while(loop){
            System.out.println("show: 显示栈");
            System.out.println("exit: 退出");
            System.out.println("push: 向栈添加数据");
            System.out.println("pop: 数据出栈");
            System.out.println("请输入你的选择");
            key=sc.next();
            switch (key){
                case "show":
                    arrayStack.disPlay();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value=sc.nextInt();
                    arrayStack.Push(value);
                    break;
                case "pop"://出栈时有可能有异常，这里检测一下异常
                        try{
                            int res=arrayStack.Pop();
                            System.out.println("出栈的数据为"+res);
                        }catch (Exception e){
                            e.getMessage();
                        }
                        break;
                case "exit":
                    sc.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("退出程序！");
    }
}
