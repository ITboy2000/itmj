package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdges;//表示边的数目
    private boolean[] isVisited;//记录某个节点是否被访问过
    public static void main(String[] args) {
        int n=5;//顶点个数
        String Vertexs[]={"A","B","C","D","E"};
        //创建图对象
        Graph graph=new Graph(n);
        //循环添加顶点
        for (String vertex:Vertexs) {
            graph.insertVertex(vertex);
        }
        //添加边
        //A-B A-C B-C B-D B-E
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        //显示邻接矩阵
        graph.showGraph();
        int a=graph.getNumOfVertex();
        System.out.println(a);
        //深度遍历
       /* System.out.println("深度遍历");
        graph.dfs();*/
        System.out.println();
        //广度遍历
        System.out.println("广度优先遍历");
        graph.bfs();
    }
    //构造器
    /*
    * n:顶点个数
    * */
    public Graph(int n){
        //初始化矩阵vertexList
        edges=new int[n][n];
        vertexList=new ArrayList<>(n);
        numOfEdges=0;
        isVisited=new boolean[5];
    }
    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    //添加边
    /*
    *v1表示第几个顶点的下标
    *v2表示第二个顶点的下标
    *weight表示1或0
     *  */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }
    //返回节点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //得到边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //返回节点i对应的数据0-->"A" 1-->"B"
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    //返回v1和v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    //显示图对应的矩阵
    public void showGraph(){
        for (int[] link: edges) {
            System.out.println(Arrays.toString(link));
        }
    }
    //得到当前节点的第一个邻接节点的下标w
    /*
    * 如果存在就返回对应的下标否则返回-1
    * */
    public int getFirstNeighbor(int index){
        for (int i = 0; i <vertexList.size() ; i++) {
            if (edges[index][i]>0){
                return i;
            }
        }
        return -1;
    }
    //根据前一个邻接节点的下标获取下一个邻接节点
    public int getNextNeighbor(int v1,int v2){
        for (int i = v2+1; i <vertexList.size() ; i++) {
            if (edges[v1][i]>0){
                return i;
            }
        }
        return -1;
    }
    //深度优先遍历算法
    //i第一次为0
    public void dfs(boolean[] isVisited,int i){
        System.out.print(getValueByIndex(i)+"-->");
        //将该节点设置为已经访问过
        isVisited[i]=true;
        //查找节点i的第一个邻接节点w
        int w=getFirstNeighbor(i);
        while (w!=-1){//说明有邻接节点
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            //如果w已经被访问过去查找邻接节点的下一个节点
            w=getNextNeighbor(i,w);
        }
    }

    //对dfs进行重载,遍历所有的节点，进行dfs
    public void dfs(){
        //遍历所有节点进行dfs
        for (int i = 0; i <getNumOfVertex() ; i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }
    //对一个节点进行广度优先遍历的方法
    public void bfs(boolean[] isVisited,int i){
        int u;//队列头节点对应下标
        int w;//邻接节点的下标
        //队列,记录节点访问顺序
        LinkedList queue =new LinkedList();
        //访问节点
        System.out.print(getValueByIndex(i)+"-->");
        //标记为已访问
        isVisited[i]=true;
        //将节点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()){
            //取出队列头节点下标
            u=(Integer) queue.removeFirst();
            //得到第一个邻接点下标
            w=getFirstNeighbor(u);
            while (w!=-1){//找到
                //是否访问过
                if (!isVisited[w]){
                    System.out.println(getValueByIndex(w)+"-->");
                    //标记已经访问
                    isVisited[w]=true;
                    //加入队列
                    queue.addLast(w);
                }
                //以u为前驱点找w后面的下一个邻接点
                w=getNextNeighbor(u,w);//体现出广度优先
            }
        }
    }
    //遍历所有的节点，都进行广度优先遍历
    public void bfs(){
        for (int i = 0; i <getNumOfVertex() ; i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }
}
