package base.designpatterns.creationalpattern.factory.simplefactory;

/**
 * @author liyu
 * @date 2019/12/3 13:45
 * @description 测试方法
 */

public class Test {

    public static void main(String[] args) {

        // 获取 Circle 的对象，并调用它的 draw 方法
        Shape circle = ShapeFactory.getShape("CIRCLE");
        circle.draw();

        // 获取 Rectangle 的对象，并调用它的 draw 方法
        Shape rectangle = ShapeFactory.getShape("RECTANGLE");
        rectangle.draw();

        // 获取 Square 的对象，并调用它的 draw 方法
        Shape square = ShapeFactory.getShape("SQUARE");
        square.draw();

        //使用重构后的进行测试
        Shape circle1 = ShapeFactory.CreateShape("CIRCLE");
        circle1.draw();

        //使用反射后的测试
        Circle aClass = (Circle) ShapeFactory2.getClass(Circle.class);//建议配置全路径
        aClass.draw();
    }
}
