package base.designpatterns.structuralpattern.decorator;

/**
 * @author liyu
 * @date 2019/12/5 11:09
 * @description ConcreteComponent（具体被装饰对象）
 * 定义一个对象，可以给这个对象添加一些职责
 */
public class Man implements Person {

    public void eat() {
        System.out.println("男人在吃");
    }
}