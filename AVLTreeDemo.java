package AVL;

public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] nums={10,11,7,6,8,9};
        AVLTree avlTree=new AVLTree();
        for (int i = 0; i <nums.length ; i++) {
            avlTree.add(new Node(nums[i]));
        }
        avlTree.infixOrder();
        System.out.println("在没有平衡处理前");
        System.out.println("树的高度为："+avlTree.getRoot().height());
        System.out.println("树的左子树高度："+avlTree.getRoot().leftHeight());
        System.out.println("树的右子树高度："+avlTree.getRoot().rightHeight());

    }
}

//节点类
class Node {
    int value;
    Node left;
    Node right;
    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //返回以该节点为根节点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    //返回右子树高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }
    //左旋转方法
    public void leftRotate(){
        //1.创建一个新的节点
        Node newNode =new Node(value);
        //2.把新节点的左子树设置成当前节点的左子树
        newNode.left=left;
        //3.把新节点的右子树设置为当前节点右子树的左子树
        newNode.right=right.left;
        //4.把当前节点的值换成右子节点的值
        value=right.value;
        //5.把当前节点的右子树设置成右子树的右子树
        right=right.right;
        //6.把当前节点的左子树设置为新节点
        left=newNode;
    }
    //右旋转方法
    public void rightRotate(){
        //1.创建一个新节点
        Node newNode=new Node(value);
        //2.把新节点的右子树设置为当前节点的右子树
        newNode.right=right;
        //3.把新节点的左子树设置为当前节点左子树的右子树
        newNode.left=left.right;
        //4.把当前结点的值换成左子节点的值
        value=left.value;
        //5.把当前节点的左子树设置成左子树的左子树
        left=left.left;
        //6.把当前节点的右子树设置成新节点
        right=newNode;
    }
    //查找删除节点的方法
    /*
     * 如果找到就返回该节点，找不到就返回null
     *
     * */
    public Node search(int value) {
        if (value == this.value) {
            //该节点就是目标节点
            return this;
        } else if (value < this.value) {
            //从左边查找
            //判断左子树是否为空
            if (this.left == null) {
                return null;
            } else {
                return this.left.search(value);
            }
        } else {
            //从右边查找
            //判断右子树是否为空
            if (this.right == null) {
                return null;
            } else {
                return this.right.search(value);
            }
        }
    }

    //查找待删除节点的父节点
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                //向左递归查找
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                //向右递归查找
                return this.right.searchParent(value);
            } else {
                return null;//没有找到
            }
        }
    }

    //添加节点,递归形式添加
    public void add(Node node) {
        if (node == null) {//如果传入的节点为空，无法进行添加，直接返回
            return;
        }
        //不为空的话可以进行添加操作
        //判断传入的节点的值和当前子树跟结点值的大小关系
        if (node.value < this.value) {
            //如果小于当前子树根节点的值，那么就向左添加
            //判断左子树是否为空
            if (this.left == null) {
                //如果为空直接让node加在左子树位置
                this.left = node;
            } else {
                //如果不为空，递归向左添加
                this.left.add(node);
            }
        } else {//如果传入节点的值大于等于当前子树根节点的值，那么就向右添加
            //判断右子树是否为空
            if (this.right == null) {
                //为空直接添加在右子树位置
                this.right = node;
            } else {
                //不为空，向右递归添加
                this.right.add(node);
            }
        }
        //当添加完一个节点后发现：右子树高度-左子树高度>1，左旋转
        if (rightHeight()-leftHeight()>1){
            //如果他的右子树的左子树高度大于他的右子树的右子树的高度，
            // 先对右子节点进行右旋转
            // 在对当前节点进行左旋转
            if (right!=null&&right.leftHeight()>right.rightHeight()) {
                right.rightRotate();
                leftRotate();//左旋转
            }else {
                leftRotate();//左旋转
            }
            return;//千万不能丢！！！！！！防止出现BUG
        }
        if (leftHeight()-rightHeight()>1){
            //如果他的左子树的右子树的高度大于他的左子树的左子树高度
            if (left!=null&&left.rightHeight()>left.leftHeight()){
            //先对当前节点的左子树进行左旋转
            left.leftRotate();
            rightRotate(); //右旋转
            } else {
                rightRotate();
            }
        }
    }

    //中序遍历,left-->mid-->right
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}

//创建AVLTree
class AVLTree {
    private Node root;
    public Node getRoot(){
        return root;
    }
    //查找待删除节点
    public Node search(int value) {
        if (root != null) {
            return root.search(value);
        } else {
            return null;
        }
    }

    //查找待删除节点的父节点
    public Node searchParent(int value) {
        if (root != null) {
            return root.searchParent(value);
        } else {
            return null;
        }
    }

    //为第三种情况编写需要的方法
    /*
     * 1.返回以node为根节点的二叉排序树中节点值最小的节点的值
     * 2.删除以node为根节点值最小的节点
     * */
    public int delRightTreeMin(Node node) {
        Node temp = node;//临时变量存储最小值
        //循环查找左节点就会找到最小值
        while (temp.left != null) {
            temp = temp.left;
        }
        //退出循环说明找到最小值所在节点
        //删除最小值所在节点
        delNode(temp.value);
        return temp.value;
    }

    //删除节点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //1.先找到待删除节点
            Node targetNode = root.search(value);
            //2.如果没有找到待删除节点就return
            if (targetNode == null) {
                return;
            }
            //3.如果当前二叉排序树只有一个节点
            if (root.left == null && root.right == null) {//能进行到这一步说明该根节点就是待删除节点，不然上一步就已经返回退出了
                root = null;
                return;
            }
            //4.找到targetNode的父节点
            Node parent = searchParent(value);
            //如果要删除的节点是叶子结点
            if (targetNode.left == null && targetNode.right == null) {
                //说明为叶子结点
                //判断targetNode是parent的左子节点还是右子节点
                if (parent.left != null && parent.left.value == value) {//是左子节点
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {//是右子节点
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {//删除有两个子树的节点
                int minValue = delRightTreeMin(targetNode.right);
                targetNode.value = minValue;
            } else {//删除只有一颗子树的节点
                //如果要删除的节点有左子节点
                if (targetNode.left != null) {
                    if (parent != null) {
                        //如果targetNode是parent的左子节点
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            //如果targetNode是parent的右子节点
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else {//如果要删除节点右右子节点
                    if (parent != null) {
                        //如果targetNode是parent的左子节点
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {
                            //如果targetNode是parent的右子节点
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

    //添加节点的方法
    public void add(Node node) {
        //判断根节点是否为空
        if (root == null) {
            root = node;
        } else {//根节点不为空，调用节点类的添加方法
            root.add(node);
        }
    }
    //当添加完一个节点后发现：右子树高度-左子树高度>1，左旋转

    //中序遍历
    public void infixOrder() {
        //判断根节点是否为空
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空无法遍历");
        }
    }
}