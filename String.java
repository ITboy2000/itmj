数据基本类型哪8种？

认识string类
·认识String类
·了解String类的基本用法
·熟练掌握String类的常规操作
·认识字符串常量池
·认识StringBuffer和StringBuilder

1.String类被称作不可变序列，不能被继承，底层为数组
2.String位于java.lang包中，Java程序默认导入java.lang包中的所有类

字符串能直接赋值就直接赋值

创建字符串
1.直接赋值
String str="bit";
2.
String str=new String("bit");
3.
char[] array={'a','b'};
String str=new String(array);

在String中==比较的是地址是否相等！
比较内容相等使用equals（）

池的出现解决效率问题

字符串常量池：
1.全局字符串常量池（String pool）

intern（）方法：

类的信息放在方法区

字符串的长度是方法 length（），数组的长度是属性length