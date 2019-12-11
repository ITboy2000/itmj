package stack;

//中缀表达式使用栈实现计算器
import java.util.Scanner;

//定义一个ArrayStack2表示栈
class ArrayStack2{
    private int maxSize;//栈的大小
    private int[] stack;//栈的数据存在该数组中
    private int top=-1;//top表示栈顶，没有数据时为-1
    private int num1;
    private int num2;
    private int oper;

    //构造器
    public ArrayStack2(int maxSize){
        this.maxSize=maxSize;
        stack=new int[this.maxSize];
    }

    //返回当前栈顶的值
    public int peek(){
        return stack[top];
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
    //返回运算符的优先级，优先级使用数字表示，数字越大优先级越高,假定表达式中只含有+-*/
    public int priority(int oper){
        if (oper=='*'||oper=='/'){
            return 1;
        }else if (oper=='+'||oper=='-'){
            return 0;
        }else{
            return -1;
        }
    }
    //判断是不是一个运算符
    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }
    //计算方法
    public int cal(int num1, int num2, int oper){
        this.num1 = num1;
        this.num2 = num2;
        this.oper = oper;
        int res=0;//用于存放计算结果
        switch(oper){
            case '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res=num2/num1;
                break;
                default:
                    break;
        }
        return res;
    }
}
public class Calculator {
    public static void main(String[] args) {
        //根据思路完成表达式的计算
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入计算表达式：");
        String expression=sc.next();
        //创建两个栈，数栈和符号栈
        ArrayStack2 numStack=new ArrayStack2(10);
        ArrayStack2 operStack=new ArrayStack2(10);

        //定义相关变量
        int index=0;//用于扫描
        int num1=0;
        int num2=0;
        int oper=0;
        int res=0;
        char ch=' ';//将每次扫描得到的char保存在ch中

        //定义一个字符串变量用于拼接多位数
        String keepNum="";

        //开始用while循环扫描expression
        while (true){
            //依次得到expression的每一个字符
            ch=expression.subSequence(index,index+1).charAt(0);
            //判断ch是什么，按照相应的方式处理
            if (operStack.isOper(ch)){//如果是运算符
                //判断当前栈是否为空
                if (!operStack.isEmpty()){
                    //处理
                    if (operStack.priority(ch)<=operStack.priority(operStack.peek())){
                        num1=numStack.Pop();
                        num2=numStack.Pop();
                        oper=operStack.Pop();
                        res=numStack.cal(num1,num2,oper);
                        //把运算结果入数栈
                        numStack.Push(res);
                        //然后把当前符号入符号栈
                        operStack.Push(ch);
                    }else {//如果当前操作符大于栈中栈中的操作符优先级那就直接入栈
                        operStack.Push(ch);
                    }
                }else{//如果为空
                    //直接入栈
                    operStack.Push(ch);
                }
            }else{//如果是数字，直接入数栈
                //numStack.Push(ch-48);//从字符转换为数字
                //分析多位数入栈情况
                //1.当处理多位数时，不能发现是数字就入栈，因为可能是多位数
                //2.在处理数时，需要向表达式的index再往后看一位来判断它是不是多位数，如果是就继续扫描，否则入栈
                //3.需要定义一个字符串变量用于拼接

                //处理多位数
                keepNum+=ch;
                //如果ch已经是表达式的最后一位就直接入栈
                if (index==expression.length()-1){
                    numStack.Push(Integer.parseInt(keepNum));
                }else{
                //判断下一个字符是不是数字，是数字继续扫描，如果是运算符就入数栈
                //只是向后再看一位不是index++
                if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                    //如果条件满足那么后一位就是运算符，那么就入数栈,keep="1","123"
                    numStack.Push(Integer.parseInt(keepNum));//要将keepNum转化为数字入数栈，此方法就可以
                    //入数栈后记得将keepNum清空，不然下一次会在原来基础上拼接
                    keepNum="";
                }
                }
            }
            //让index++，并判断是否扫描到最后
            index++;
            if (index>=expression.length()){
                break;
            }
        }
        //做扫描完毕后的处理
        while (true){
            //如果符号栈为空计算结束，数占中只有一个数值就是结果
            if (operStack.isEmpty()){
                break;
            }
            num1=numStack.Pop();
            num2=numStack.Pop();
            oper=operStack.Pop();
            res=numStack.cal(num1,num2,oper);
            numStack.Push(res);//入栈
        }
        int res2=numStack.Pop();
        System.out.println("结果为：");
        System.out.println(res2);
    }
}
