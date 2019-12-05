package base.designpatterns.structuralpattern.decorator;

/**
 * @author liyu
 * @date 2019/12/5 11:10
 * @description Decorator（装饰者抽象类）
 * 维持一个指向Component实例的引用，并定义一个与Component接口一致的接口
 */
public abstract class Decorator implements Person {

    protected Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    public void eat() {
        person.eat();
    }
}
