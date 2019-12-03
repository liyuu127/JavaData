package base.designpatterns.creationalpattern.factory.factorymethod;

import base.designpatterns.creationalpattern.factory.simplefactory.Circle;
import base.designpatterns.creationalpattern.factory.simplefactory.Shape;

/**
 * @author liyu
 * @date 2019/12/3 14:06
 * @description
 */
public class CircleFactory implements Factory {

    @Override
    public Shape getShape() {
        // TODO Auto-generated method stub
        return new Circle();
    }

}

