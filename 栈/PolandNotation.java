package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //中缀表达式转后缀表达式：1+（（2+3）*4）-5——》1 2 3 + 4 * + 5 -
        //1.将中缀表达式转化成中缀表达式对应的list
        //2.将中缀表达式对应的list转化成后缀表达式对应的list
        // [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]-》[1,2,3,+,4,*,+,5,-],消除括号
        String expression="1+((2+3)*4)-5";
        List<String> infixExpressionList=toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的list="+infixExpressionList);
        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应的list="+suffixExpressionList);
        System.out.println(expression+"="+calculate(suffixExpressionList));
        //先定义一个逆波兰表达式
        //(3+4)*5-6-->3 4+ 5 * 6 -
        //String suffixExpression="3 4 + 5 * 6 - ";//后缀表达式
        //思路:
        //1.先将表达式放在ArrayList当中，便于快速扫描
        //2.将ArrayList传递给一个方法，配合栈完成计算
        /*List<String> list=getListString(suffixExpression);
        System.out.println("rpnList: "+list);
        int res=calculate(list);
        System.out.println(res);*/
    }

    // [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]-》[1,2,3,+,4,*,+,5,-],消除括号
    //方法：
    public static List<String> parseSuffixExpressionList(List<String> ls){
        //定义两个栈
        Stack<String> s1=new Stack<String>();//符号栈
        //因为s2这个栈，在整转换过程中，没有pop操作，我们后面要逆序输出后缀表达式
        //因此我们不用 Stack<String>，只接使用List<String> s2
        //Stack<String> s2=new Stack<String>();//存储中间结果栈
        List<String> s2=new ArrayList<String>();//用于存储中间结果的ArrayList s2
        //遍历ls
        for(String item:ls){
            //如果是一个数就入加入到s2
            if (item.matches("\\d+")){//使用正则表达式
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                //如果是“）”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时这一对括号将丢弃
                while (!s1.peek().equals("(")){//peek()查看栈顶的内容，并不改变
                    s2.add(s1.pop());//把s1内容弹出加入到s2中，知道遇到）结束
                }
                s1.pop();//将（弹出s1栈，就是消除小括号
            }else{
                //考虑优先级,当item的优先级小于等于s1栈顶的运算符优先级
                // 将s1栈顶的运算符弹出并加入到s2中，再次转到4.1与s1中新的栈顶运算符相比较
                //缺少比较优先级高低的方法
                while (s1.size()!=0&&
                        Operation.getValue(s1.peek()) >=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //还需要将item压入s2栈中
                s1.push(item);
            }
        }
        //将s1中剩余的运算符依次弹出并加入到s2中
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;//因为是存放到list中，因此按顺序输出就是后缀表达式对应的list
    }

    //将中缀表达式转成对应的list
    public static List<String> toInfixExpressionList(String s){
        //定义一个List存放中缀表达式对应的内容
        List<String> ls=new ArrayList<String>();
        int i=0;//用于扫描中缀表达式字符串
        String str;//用于对多位数进行拼接
        char c;//每遍历一个字符，就放入到c
        do {
            //如果c是非数字，那么加到ls中
            if ((c=s.charAt(i))<48||(c=s.charAt(i))>57){
                ls.add(""+c);
                i++;//需要后移
            }else{//如果是数字,需要考虑多位数的问题
                str="";//先将str置成空串
                while (i<s.length()&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57){
                    str+=c;//拼接
                    i++;
                }
                ls.add(str);
            }
        }while (i<s.length());
        return ls;
    }

    //将逆波兰表达式，将数据和运算符放入到ArrayList中
   /* public static List<String> getListString(String suffixExpression){
        //将suffixExpression分割
        String[] split=suffixExpression.split(" ");
        List<String> list=new ArrayList<String>();
        for(String ele:split ){
            list.add(ele);
        }
        return list;
    }*/
    //完成对逆波兰表达式的计算
    /*
    * 1.从左向右扫描，将3和4压入堆栈
    * 2.遇到+运算符，弹出4和3（4是栈顶元素，3是次栈顶元素），计算3+4，将结果7入栈
    * 3.将5入栈
    * 4.接下来扫描到*运算符，弹出5和7，计算5*7，将结果34入栈
    * 5.将6入栈
    * 6.扫描到-运算符弹出6和35，计算35-6，将结果29入栈，得到最终结果
    * */

    public static int calculate(List<String> ls){
        //创建一个栈即可
        Stack<String> stack=new Stack<String>();
        //遍历ls
        for (String item:ls){
            //使用正则表达式取出数
            if (item.matches("\\d+")){//匹配的是多位数
                //入栈
                stack.push(item);
            }else{
                //弹出两个数并运算,再入栈
                int num2=Integer.parseInt(stack.pop());//栈顶
                int num1=Integer.parseInt(stack.pop());//次栈顶
                int res=0;//存放结果
                if (item.equals("+")){
                    res=num1+num2;
                }else if(item.equals("-")){
                    res=num1-num2;
                }else if (item.equals("*")){
                    res=num1*num2;
                }else if (item.equals("/")){
                    res=num1/num2;
                }else{
                    throw new RuntimeException("运算符有误");
                }
                //将res入栈
                stack.push(""+res);
            }
        }
        //最后留在Stack中的数据就是运算结果
        return Integer.parseInt(stack.pop());
    }
}
//编一个比较运算符优先级的类
class Operation{
    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=2;
    private static int DIV=2;
    //写一个方法，返回对应的优先级数字
    public static int getValue(String Operation){
        int result=0;
        switch (Operation){
            case "+":
                result=ADD;
                break;
            case "-":
                result=SUB;
                break;
            case "*":
                result=MUL;
                break;
            case "/":
                result=DIV;
                break;
                default:
                    System.out.println("不存在该运算符！");
                    break;
        }
        return result;
    }

}