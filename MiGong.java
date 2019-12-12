package recursion;
//迷宫问题
public class MiGong {
    public static void main(String[] args) {
        //创建二维数组表示地图
        int[][] map=new int[8][7];
        //模拟墙,1表示墙
        for (int i = 0; i <7 ; i++) {//将第一行和最后一行数组元素设为1表示墙
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int i = 0; i <8 ; i++) {//将第一列和最后一列数组元素设为1
            map[i][0]=1;
            map[i][6]=1;
        }
        //设置挡板
        map[3][1]=1;
        map[3][2]=1;
        //输出地图
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <7 ; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        //使用递归回溯找路径
        /*setWay(map,1,1);
        System.out.println("下-》右-》上-》左找到路径后的迷宫情况:");
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <7 ; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }*/
        //按照策略走 上-》右-》下-》左后的找迷宫路径情况
        setWay2(map,1,1);
        System.out.println("上-》右-》下-》左找到路径后的迷宫情况:");
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <7 ; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    //使用递归回溯找路
    //说明：
    /*
    * 1.map表示地图
    * 2.i，j表示从哪个位置出发，从(1,1)出发
    * 3.如果小球能到（6,5）说明通路找到
    * 4.约定：map[i,j]=0表示该点没有走过，=1表示墙，=2表示通路可以走，=3走过却不通
    * 5.走迷宫策略：下-》右-》上-》左，如果该点走不通再回溯
    * */
    /*
    * map表示地图
    * i,j表示从哪个位置开始找
    * 如果找到路返回true，没找到返回false
    * */
    public static boolean setWay(int[][]map,int i,int j){

        //此方法只能找到一条路，因为如何走已经在下方规定好了策略

        if (map[6][5]==2){//说明通路找到
            return true;
        }else{
            if (map[i][j]==0){//如果当前这个点没有走过
                //按照策略走下-》右-》上-》左
                map[i][j]=2;//假定该点可以走通
                if (setWay(map,i+1,j)){//向下走
                    return true;//能走通返回true
                }else if (setWay(map, i, j+1)){//向右走
                    return true;
                }else if (setWay(map, i-1, j)){//向上走
                    return true;
                }else if (setWay(map, i, j-1)){//向左走
                    return true;
                } else{//说明该点走不通，是死路
                map[i][j]=3;
                return false;//代表这条路不再走
            }
        }else {//如果map[i][j]!=0,map[i][j]=1/2/3,这个点不再走
                return false;
        }
    }
    }
    //修改找路策略
    //上-》右-》下-》左
    public static boolean setWay2(int[][]map,int i,int j){

        //此方法只能找到一条路，因为如何走已经在下方规定好了策略

        if (map[6][5]==2){//说明通路找到
            return true;
        }else{
            if (map[i][j]==0){//如果当前这个点没有走过
                //按照策略走上-》右-》下-》左
                map[i][j]=2;//假定该点可以走通
                if (setWay2(map,i-1,j)){//向上走
                    return true;//能走通返回true
                }else if (setWay2(map, i, j+1)){//向右走
                    return true;
                }else if (setWay2(map, i+1, j)){//向下走
                    return true;
                }else if (setWay2(map, i, j-1)){//向左走
                    return true;
                } else{//说明该点走不通，是死路
                    map[i][j]=3;
                    return false;//代表这条路不再走
                }
            }else {//如果map[i][j]!=0,map[i][j]=1/2/3,这个点不再走
                return false;
            }
        }
    }
}
