package base.designpatterns.creationalpattern.factory.simplefactory;

/**
 * @author liyu
 * @date 2019/12/3 12:14
 * @description Բ
 */

public class Circle implements Shape {
    public Circle() {
        System.out.println("Circle");
    }

    @Override
    public void draw() {
        System.out.println("Draw Circle");
    }
}