package huffmancode;
import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        String content="i like like like java do you like a java";
        byte[] contentBytes= content.getBytes();//得到字符串的byte数组
        System.out.println(content.length());//编码前的长度
        List<Node> nodes=getNodes(contentBytes);
        System.out.println(nodes);
        //显示创建的二叉树
        System.out.println("对应权值的哈夫曼树：");
        Node huffmanTreeRoot=createHuffmanTree(nodes);
        huffmanTreeRoot.preOrder();
        Map<Byte,String> huffmanCodes=getCodes(huffmanTreeRoot);
        System.out.println("生成的哈弗曼编码表："+huffmanCodes);
    }

    //生成的哈夫曼树对应的哈弗曼编码
    //思路
    //1.将哈弗曼编码表存放在Map中Map<Byte,String>
    //形如：
    //o:1000 u:10010 d:100110 y:100111 i:101
    //a:110 k:1110 e:1111 j:0000 v:0001 l:001  :01
    private static Map<Byte,String> huffmanCodes=new HashMap<Byte,String>();
    //2.在生成字符哈弗曼编时，需要拼接路径，定义一个StringBuilder，存储叶子节点的路径，不用String的原因是。
    // 会造成大量对象的生成，浪费空间
    //将传入的Node节点的所有叶子节点的哈弗曼编码得到，放入到huffmanCodes中
    private static  StringBuilder stringBuilder=new StringBuilder();

    //为了调用方便，重载getCodes
    private static Map<Byte,String> getCodes(Node root){
        if (root==null){
            return null;
        }
         //处理root左子树
        getCodes(root.left,"0",stringBuilder);
        //处理右子树
        getCodes(root.right,"1",stringBuilder);
        return huffmanCodes;
    }

    private static void getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder2=new StringBuilder(stringBuilder);

        /*
        * node传入的节点
        * code代表路径 左子节点是0，右子节点是1
        * StringBuilder用以拼接路径
        *
        * */
        //将code加入到stringBuilder2中
        stringBuilder2.append(code);
        if (node!=null){//如果node等于空不处理
            //判断当前节点是叶子节点还是非叶子节点
            if (node.data==null){//非叶子节点
                //递归处理
                //向左递归
                getCodes(node.left,"0",stringBuilder2);
                //向右递归
                getCodes(node.right,"1",stringBuilder2);
            }else {//叶子结点
                //找到了某个叶子节点的最后
                huffmanCodes.put(node.data,stringBuilder2.toString());
            }
        }
    }

    //调用前序遍历
    private static void preOrder(Node root){
        if (root!=null){
            preOrder(root);
        }else {
            System.out.println("哈夫曼树为空");
        }
    }

    //将节点存放在List中,接受字节数组，返回的就是List，形如：[Node[data=97,weight=5],Node[data=32,weight=9]..]
    private static List<Node> getNodes(byte[] bytes){
        //创建一个ArrayList
        ArrayList<Node> nodes=new ArrayList<Node>();
        HashMap<Byte,Integer> counts=new HashMap<>();
        //遍历bytes，统计存储每一个byte出现的次数，使用一个接口来完成，map接口，通过键对值[key,value]来的到次数
        for (byte b:bytes){
            Integer count=counts.get(b);
            if (count==null){//Map中还没有这个字符数据,第一次接收
                counts.put(b,1);
            }else {
                counts.put(b,count+1);
            }
        }
        //把每个键值对转成一个Node对象，并加入到nodes集合
        //遍历Map
        for (Map.Entry<Byte,Integer> entry:counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }
    //通过List创建哈夫曼树
    private static Node createHuffmanTree(List<Node> nodes){
        //循环处理
        //当nodes中只有一个节点就相当于哈夫曼树构建完成了
        while (nodes.size()>1){
            //排序，从小到大
            Collections.sort(nodes);
            System.out.println("nodes="+nodes);
            //取出根节点最小的两颗二叉树
            //(1)取出权值最小的节点
            Node leftNode=nodes.get(0);
            //(2)取出权值第二小的节点
            Node rightNode=nodes.get(1);
            //(3)构建一颗新的二叉树,它的根节点没有data只有weight
            Node parent=new Node(null,leftNode.weight+rightNode.weight);
            parent.left=leftNode;
            parent.right=rightNode;
            //(4)从ArrayList中删除处理过的节点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //(5)将parent加入到nodes
            nodes.add(parent);
        }
        //返回哈夫曼树的根节点
        return nodes.get(0);
    }
}

//创建节点类，节点所包含的属性有data：数据，weight：权值，left，right创建哈夫曼树时使用,因为创建哈夫曼树时
//要进行权值的比较，所以要实现comparable接口
class Node implements Comparable<Node>{
    Byte data;//存放数据，比如'a'=>97
    int weight;//权值，表示字符出现的次数
    Node left;
    Node right;

    public Node(Byte data,int wight) {
        this.data = data;
        this.weight=wight;
    }


    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "Node[data="+data+","+"weight"+weight+"]";
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
}