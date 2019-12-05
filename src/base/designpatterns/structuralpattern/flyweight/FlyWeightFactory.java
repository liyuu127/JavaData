package base.designpatterns.structuralpattern.flyweight;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liyu
 * @date 2019/12/5 13:45
 * @description 享元模式中，最关键的享元工厂。
 * 它将维护已创建的享元实例，并通过实例标记（一般用内部状态）去索引对应的实例。
 * 当目标对象未创建时，享元工厂负责创建实例并将其加入标记-对象映射。
 * 当目标对象已创建时，享元工厂直接返回已有实例，实现对象的复用
 */
public class FlyWeightFactory {
    private static ConcurrentHashMap<String, FlyWeight> allFlyWeight = new ConcurrentHashMap<String, FlyWeight>();

    public static FlyWeight getFlyWeight(String name) {
        if (allFlyWeight.get(name) == null) {
            synchronized (allFlyWeight) {
                if (allFlyWeight.get(name) == null) {
                    System.out.println("Instance of name = {} does not exist, creating it");
                    FlyWeight flyWeight = new ConcreteFlyWeight(name);
                    System.out.println("Instance of name = {} created");
                    allFlyWeight.put(name, flyWeight);
                }
            }
        }
        return allFlyWeight.get(name);
    }
}
