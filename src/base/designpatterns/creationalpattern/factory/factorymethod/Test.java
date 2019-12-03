package base.designpatterns.creationalpattern.factory.factorymethod;

import base.designpatterns.creationalpattern.factory.simplefactory.Shape;

/**
 * @author liyu
 * @date 2019/12/3 14:09
 * @description
 */
public class Test {

    public static void main(String[] args) {
        Factory circlefactory = new CircleFactory();
        Shape circle = circlefactory.getShape();
        circle.draw();
    }

}

