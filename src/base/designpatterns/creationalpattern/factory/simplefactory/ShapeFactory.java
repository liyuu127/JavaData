package base.designpatterns.creationalpattern.factory.simplefactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author liyu
 * @date 2019/12/3 12:15
 * @description 工厂类
 * 这样的实现有个问题，如果我们新增产品类的话，就需要修改工厂类中的getShape（）方法，这很明显不符合 开放-封闭原则
 */

public class ShapeFactory {

    // 使用 getShape 方法获取形状类型的对象
    public static Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }


    //使用函数式编程进行重构
    private final static Map<String, Supplier<Shape>> map=new HashMap<>();
    static {
        map.put("CIRCLE",Circle::new);
        map.put("RECTANGLE",Rectangle::new);
        map.put("SQUARE",Square::new);
    }
    public static Shape CreateShape(String name){
        Supplier<Shape> shapeSupplier = map.get(name);
        if (shapeSupplier==null) {
            throw new IllegalArgumentException("no such shape name :"+name);
        }
        return shapeSupplier.get();
    }
}
