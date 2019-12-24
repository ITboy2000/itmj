package tree;

//线索化二叉树
/*
1.含有n个节点的二叉链表含有n+1个空指针域，
利用二叉链表中的空指针域来存放该节点在某种遍历次序下前驱和后继结点的指针（这种附加的指针称为线索）
2.这种加上了线索的二叉链表称为线索链表，
相应的二叉树称为线索二叉树（Threaded BinaryTree），
根据线索性质的不同，线索二叉树可以分为前序线索二叉树，中序线索二叉树，后序线索二叉树
3.一个节点的前一个节点称为前驱节点
  一个节点的后一个节点称为后继节点
* */

//创建节点
class HeroNode2{
    //设置节点属性
    private int no;
    private String name;
    private HeroNode2 left;//默认为空
    private HeroNode2 right;//默认为空
    //跟二叉树不同的是，要知道节点的的left和right指向的是前驱节点和后继节点或指向的是左子树和右子树
    private int leftType;//默认为空
    private int rightType;//默认为空

    //构造器为属性赋值

    public HeroNode2(int no,String namae) {
        this.no=no;
        this.name=namae;
    }

    //设置get和set方法

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode2 getLeft() {
        return left;
    }

    public void setLeft(HeroNode2 left) {
        this.left = left;
    }

    public HeroNode2 getRight() {
        return right;
    }

    public void setRight(HeroNode2 right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    //前序遍历
    public void preOrder(int no){
        //首先输出根节点
        System.out.println(this);
        //向左递归遍历
        if (this.left!=null){//如果左子树不为空就向左递归遍历
            this.left.preOrder(no);
        }
        //向右递归遍历
        if (this.right!=null){//如果右子树不为空就向右递归遍历
            this.right.preOrder(no);
        }
    }

    //中序遍历
    public void midOrder(int no){
        //先向左递归遍历
        if (this.left!=null){
            this.left.midOrder(no);
        }
        //左递归遍历完成后，输出根节点
        System.out.println(this);
        //向右递归遍历
        if (this.right!=null){
            this.right.midOrder(no);
        }
    }

    //后序遍历
    public void postOrder(int no){
        //先向左递归遍历
        if (this.left!=null){
            this.left.postOrder(no);
        }
        //向右递归遍历
        if (this.right!=null){
            this.right.postOrder(no);
        }
        //输出根节点
        System.out.println(this);
    }

    //前序查找
    public HeroNode2 preSearch(int no){
        //判断根节点是否为目标节点,是就返回
        if (this.no==no){
            return this;
        }
        //根节点不是目标节点就向左递归查找
        HeroNode2 resNode=null;//记录找到的节点
        if (this.left!=null){
            resNode =this.left.preSearch(no);
        }
        //如果resNode不为空说明找到了
        if (resNode!=null){
            return resNode;
        }
        //向左递归查找没找到就向右递归查找
        if (this.right!=null){
            resNode=this.right.preSearch(no);
        }
        //此时不管向右递归找到没都需要返回resNode,找到就不为空，没找到就为空
        return resNode;
    }

    //中序查找
    public HeroNode2 midSearch(int no){
        HeroNode2 resNode=null;//记录找到的节点情况
        //先向左递归查找
        if (this.left!=null){
            resNode=this.left.midSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        //判断根节点是否为目标节点
        if (this.no==no){
            return this;
        }
        //向右递归查找
        if (this.right!=null){
            resNode=this.right.midSearch(no);
        }
        return resNode;
    }

    //后序查找
    public HeroNode2 postSearch(int no){
        HeroNode2 resNode=null;
        //向左递归查找
        if (this.left!=null){
            resNode=this.left.postSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        //向右递归查找
        if (this.right!=null){
            resNode=this.right.postSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        //判断根节点是否为目标节点
        if (this.no==no){
            return this;
        }
        //前面都没找到就返回初始resNode
        return resNode;
    }

    //删除节点
    public void delNode(int no){
        //进入代码说明根节点不为空，不为空才会调用这段代码，在二叉树中调用此方法
        /*
         * 删除思路
         * 1.如果该二叉树是空树，那么无法进行删除操作，如果该二叉树只有一个根节点，并且是待删除节点就将二叉树置空
         * 2.因为二叉树是单向的所以我们在寻找待删除节点时是找一个节点的子节点是否为待删除节点，并不是寻找该节点是否为待删除节点
         * 3.如果当前节点左子节点不为空并且左子节点就是待删除节点，那么：this.left=null;并且返回（结束递归删除）
         * 4.如果当前节点的右子节点不为空并且右子节点就是待删除节点，那么：this.right=null;并且返回（结束递归删除）
         * 5.如果第3,4步没有删除节点，那么我们就需要向左子树进行递归删除
         * 6.如果第五步也没有删除节点那么我们就要向，右子树进行递归删除
         * */

        //如果当前节点左子节点不为空并且左子节点就是待删除节点，那么：this.left=null;并且返回（结束递归删除）
        if (this.left!=null&&this.left.no==no){
            this.left=null;
            return;
        }
        //如果当前节点的右子节点不为空并且右子节点就是待删除节点，那么：this.right=null;并且返回（结束递归删除）
        if (this.right!=null&&this.right.no==no){
            this.right=null;
            return;
        }
        //如果第3,4步没有删除节点，那么我们就需要向左子树进行递归删除
        if (this.left!=null){
            this.left.delNode(no);
        }
        //如果第五步也没有删除节点那么我们就要向，右子树进行递归删除
        if (this.right!=null){
            this.right.delNode(no);
        }
}
}

//创建线索二叉树
class ThreadedBinaryTree{
    private HeroNode2 root;
    //为了实现线索化，需要创建指向当前节点的前驱节点的指针
    //在递归实现线索化时，pre总是保留前一个节点
    private HeroNode2 pre=null;
    //创建根节点
    public void setRoot(HeroNode2 root) {
        this.root = root;
    }
    //编写对二叉树的中序线索化
    /*
     * node2就是当前需要线索化的节点
     * */
    public void threadedNodes(HeroNode2 node){
        //如果node==null，就不能进行线索化
        if (node==null){
            return;
        }
        //中序线索化的步骤
        //一.先线索化左子树
        threadedNodes(node.getLeft());
        //二.线索化当前节点
        //1.处理当前节点的前驱节点
        if (node.getLeft()==null){
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针类型
            node.setLeftType(1);
        }
        //2.处理当前节点的后继节点
        if (pre!=null&&pre.getRight()==null){
            //让前驱节点的右指针指向当前节点
            pre.setRight(node);
            //修改前驱节点的右指针类型
            pre.setRightType(1);
        }
        //!!!!!!!每处理一个节点后让当前节点是下一个节点的前驱
        pre=node;
        //三.线索化右子树
        threadedNodes(node.getRight());

    }

    //调用前序遍历
    public void preOrder(int no){
        //判断根节点是否为空
        if (root!=null){
            root.preOrder(no);
        }else {
            System.out.println("二叉树为空不能遍历");
        }
    }

    //调用中序遍历
    public void midOrder(int no){
        if (root!=null){
            root.midOrder(no);
        }else{
            System.out.println("二叉树为空不能遍历");
        }
    }

    //调用后序遍历
    public void postOrder(int no){
        if (root!=null){
            root.postOrder(no);
        }else{
            System.out.println("二叉树为空不能遍历");
        }
    }

    //调用前序查找
    public HeroNode2 preSearch(int no){
        if (root!=null){
            return root.preSearch(no);
        }else {
            return null;
        }
    }

    //调用中序查找
    public HeroNode2 midSearch(int no){
        if (this.root!=null){
            return  this.root.midSearch(no);
        }else{
            return null;
        }
    }

    //调用后序查找
    public HeroNode2 postSearch(int no){
        if (this.root!=null){
            return root.postSearch(no);
        }else {
            return null;
        }
    }

    //调用删除
    public void delNode(int no){
        if (root!=null){
            if (root.getNo()==no){
                root=null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("二叉树为空，无法进行删除操作");
        }
    }
}
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //测试线索二叉树
        HeroNode2 root=new HeroNode2(1,"保尔");
        HeroNode2 node1=new HeroNode2(3,"查克拉");
        HeroNode2 node2=new HeroNode2(6,"波多");
        HeroNode2 node3=new HeroNode2(8,"小泽");
        HeroNode2 node4=new HeroNode2(10,"川岛");
        HeroNode2 node5=new HeroNode2(14,"村上");
        //手动创建二叉树
        root.setLeft(node1);
        root.setRight(node2);
        node2.setLeft(node3);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setRight(node5);
        //测试中序线索化
        ThreadedBinaryTree threadedBinaryTree=new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes(node4);

        //以10号节点测试node4
        HeroNode2 leftNode=node4.getLeft();
        System.out.println(leftNode);
        HeroNode2 rightNode=node4.getRight();
        System.out.println(rightNode);
    }
}
