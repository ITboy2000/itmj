package huffmantree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//哈夫曼树
//创建哈夫曼树中的节点类
class Nodes implements Comparable<Nodes>{
    public int value;//节点的权值
    public Nodes left;//指向左子节点
    public Nodes right;//指向右子节点

    public Nodes(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Nodes{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Nodes o) {
        //表示从小到大排序
        return this.value-o.value;
    }

    //前序遍历
     public  void preOrder(){
        //首先输出根节点
         System.out.println(this);
         //向左遍历
         if (this.left!=null){
             this.left.preOrder();
         }
         //向右遍历
         if (this.right!=null){
             this.right.preOrder();
         }
     }
}

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr={13,7,8,3,29,6,1};
        Nodes root=creatHuffmanTree(arr);
        preOrder(root);
    }
    //调用前序遍历
    public static void preOrder(Nodes root){
        if (root!=null){
            root.preOrder();
        }else{
            System.out.println("哈夫曼树为空，无法遍历");
        }
    }
    //创建哈夫曼树
    //此方法的返回值是根节点
    public static Nodes creatHuffmanTree(int[] arr){
        //第一步：为了操作方便
        //1.b遍历数组
        //2.将数组中的每个元素构建成一个Node节点
        //3.将每个Node放入ArrayList中：为了添加和删除的方便
        List<Nodes> nodes=new ArrayList<Nodes>();
        for (int value:arr){
            nodes.add(new Nodes(value));
        }

        //循环处理
        //当nodes中只有一个节点就相当于哈夫曼树构建完成了
        while (nodes.size()>1){
        //排序，从小到大
        Collections.sort(nodes);
        System.out.println("nodes="+nodes);
        //取出根节点最小的两颗二叉树
        //(1)取出权值最小的节点
        Nodes leftNode=nodes.get(0);
        //(2)取出权值第二小的节点
        Nodes rightNode=nodes.get(1);
        //(3)构建一颗新的二叉树
        Nodes parent=new Nodes(leftNode.value+rightNode.value);
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
