package base.designpatterns.creationalpattern.factory.factorymethod;

import base.designpatterns.creationalpattern.factory.simplefactory.Shape;
import base.designpatterns.creationalpattern.factory.simplefactory.Square;

/**
 * @author liyu
 * @date 2019/12/3 14:08
 * @description
 */
public class SquareFactory implements Factory{

    @Override
    public Shape getShape() {
        // TODO Auto-generated method stub
        return new Square();
    }

}

