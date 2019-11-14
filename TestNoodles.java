package 面向对象编程.Extends.多态2;

public class TestNoodles {

    public static void main(String[] args) {
     Noodles noodles=new ZhaJiangMian();
     noodles.shape();
//     abc(noodles);
     Noodles noodles1=new DaoXiaoMian();
//     abc(noodles1);
    }
    /*public static void abc(Noodles c){
        c.shape();
    }*/
}
