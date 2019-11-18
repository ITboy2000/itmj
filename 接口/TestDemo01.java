package 面向对象编程.接口;

class Rect implements Shape,Shape2{//
    @Override
    public void draw() {
        System.out.println("画矩形");
    }

    @Override
    public void func() {

    }
}
class Cycle implements Shape{
    @Override
    public void draw() {
        System.out.println("画圆圈");
    }
}
public class TestDemo01 {

    public static void drawMap(Shape shape){
        shape.draw();
    }

    public static void main(String[] args) {
        //接口的向上转型
        Shape shape=new Rect();
        Shape shape1=new Cycle();
        drawMap(shape);
        drawMap(shape1);

    }
}
