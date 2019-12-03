package base.designpatterns.creationalpattern.factory.factorymethod;

import base.designpatterns.creationalpattern.factory.simplefactory.Rectangle;
import base.designpatterns.creationalpattern.factory.simplefactory.Shape;

/**
 * @author liyu
 * @date 2019/12/3 14:07
 * @description
 */
public class RectangleFactory implements Factory{

    @Override
    public Shape getShape() {
        // TODO Auto-generated method stub
        return new Rectangle();
    }

}

