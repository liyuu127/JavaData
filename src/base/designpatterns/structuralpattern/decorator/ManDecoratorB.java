package base.designpatterns.structuralpattern.decorator;

/**
 * @author liyu
 * @date 2019/12/5 11:18
 * @description
 */
public class ManDecoratorB extends Decorator {

    public void eat() {
        super.eat();
        System.out.println("===============");
        System.out.println("ManDecoratorB¿‡");
    }
}
