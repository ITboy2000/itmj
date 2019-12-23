package tree;
//二叉树的前中后序遍历

//创建节点
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;//默认为空
    private HeroNode right;//默认为空

    //构造器，目的是为了在主函数中实例化对象并且创建节点时赋值
    public HeroNode(int no,String name) {
        this.no = no;
        this.name=name;
    }

    //提供一系列get和set方法，因为成员变量都是私有的

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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    //重写toString方法，输出节点是可以打印节点中的内容，不必自己写输出格式 
    @Override
    public String toString() {
        return "heroNode[no="+no+", name"+name+"]";
    }

    //递归删除节点
    /*
    * 1.如果要删除的是叶子结点，那么就将该节点删除
    * 2.如果要删除的是非叶子节点，那么就将该子树删除
    * */

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
    //前序遍历
    public void preOrder(){
        //输出根节点
        System.out.println(this);
        //递归向左子树递归进行前序遍历
        if (this.left!=null){
            this.left.preOrder();
        }
        //递归向右子树递归进行前序遍历
        if (this.right!=null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void midOrder(){
        //递归向左子树递归进行前序遍历
        if (this.left!=null){
            this.left.preOrder();
        }
        //输出根节点
        System.out.println(this);
        //递归向右子树递归进行前序遍历
        if (this.right!=null){
            this.right.preOrder();
        }
    }

    //后序遍历
    public void postOrder(){
        //递归向左子树递归进行前序遍历
        if (this.left!=null){
            this.left.preOrder();
        }
        //递归向右子树递归进行前序遍历
        if (this.right!=null){
            this.right.preOrder();
        }
        //输出根节点
        System.out.println(this);
    }

    //前序查找
    public HeroNode  preSearch(int no){
        //判断根节点的no是否等于目标no
        if (this.no==no){//如果根节点就是目标节点直接返回
            return this;
        }
        //否则
        HeroNode resNode=null;//保存查找节点
        //向左递归查找
        if (this.left!=null){
            resNode=this.left.preSearch(no);
        }
        //在左子树找到就返回该节点
        if (resNode!=null){
            return resNode;
        }
        //否则向右递归查找
        if (this.right!=null){
            resNode=this.right.preSearch(no);
        }
        //找没找到都返回
        return resNode;
    }

    //中序查找
    public HeroNode midSearch(int no){
        HeroNode resNode=null;
        if (this.left!=null){
            resNode=this.left.midSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.no==no){
            return this;
        }
        if (this.right!=null){
            resNode=this.right.midSearch(no);
        }
        return resNode;
    }

    //后序查找
    public HeroNode postSearch(int no){
        HeroNode resNode=null;
        if (this.left!=null){
            resNode=this.left.postSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.right!=null){
            resNode=this.right.postSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.no==no){
            return this;
        }
        return resNode;
    }
}

  //创建二叉树
class BinaryTree{
    private HeroNode root;//根节点
      public void setRoot(HeroNode root) {
          this.root = root;
      }
      //根据no删除节点
      public void delNode(int no){
          //判断二叉树是否为空
          if (root!=null){
              //不为空的话就判断根节点是否为待删除节点，如果是就置空
              if (root.getNo()==no){
                  root=null;
              }else{
                  //不是就进行递归删除
                  root.delNode(no);
              }
          }else{
              //为空就提示
              System.out.println("该二叉树为空不能进行删除操作");
          }
      }


      //调用前序遍历
      public void preOrder(){
          if (this.root!=null){
              this.root.preOrder();
          }else {
              System.out.println("二叉树为空无法遍历");
          }
      }

      //调用中序遍历方法
      public void midOrder(){
          if (this.root!=null){
              this.root.midOrder();
          }else{
              System.out.println("二叉树为空无法遍历");
          }
      }

      //调用后序遍历方法
      public void postOrder(){
          if (this.root!=null){
              this.root.postOrder();
          }else{
              System.out.println("二叉树为空无法遍历");
          }
      }

      //调用前序查找
      public HeroNode  preSearch(int no){
          if (this.root!=null){
              return  this.root.preSearch(no);
          }else{
              return null;
          }
      }

      //调用中序查找
      public HeroNode midSearch(int no){
          if (this.root!=null){
              return  this.root.midSearch(no);
          }else{
              return null;
          }
      }

      //调用后序查找
      public HeroNode postSearch(int no){
          if (this.root!=null){
              return root.postSearch(no);
          }else {
              return null;
          }
      }
  }
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //实例化二叉树
        BinaryTree binaryTree=new BinaryTree();
        //创建节点
        HeroNode root=new HeroNode(1,"宋江");
        HeroNode node1=new HeroNode(2,"吴用");
        HeroNode node2=new HeroNode(3,"张飞");
        HeroNode node3=new HeroNode(4,"阿拉蕾");

        //手动创建二叉树
        root.setLeft(node1);
        root.setRight(node2);
        node2.setLeft(node3);
        binaryTree.setRoot(root);

        //测试删除操作
        binaryTree.delNode(2);

        //测试前序遍历
        System.out.println("前序遍历结果为：");
        binaryTree.preOrder();

        //测试前序遍历查找
        System.out.println("前序遍历查找结果为：");
        HeroNode node=binaryTree.preSearch(1);
        if (node!=null){
            System.out.println(node.getNo()+" "+node.getName());
        }
        System.out.println("查无此人");

    }
}
