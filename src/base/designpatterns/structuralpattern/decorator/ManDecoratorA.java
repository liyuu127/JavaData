package base.designpatterns.structuralpattern.decorator;

/**
 * @author liyu
 * @date 2019/12/5 11:17
 * @description ConcreteDecorator（具体装饰者）
 * 具体的装饰对象，给内部持有的具体被装饰对象，增加具体的职责
 */
public class ManDecoratorA extends Decorator {

    public void eat() {
        super.eat();
        reEat();
        System.out.println("ManDecoratorA类");
    }

    public void reEat() {
        System.out.println("再吃一顿饭");
    }
}

