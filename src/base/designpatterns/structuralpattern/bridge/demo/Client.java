package base.designpatterns.structuralpattern.bridge.demo;

/**
 * @author liyu
 * @date 2019/12/4 15:04
 * @description
 */
public class Client {
    public static void main(String a[]) {
        Color color=new Blue();
        Pen pen=new BigPen();

        pen.setColor(color);
        pen.draw("œ ª®");
    }
}
