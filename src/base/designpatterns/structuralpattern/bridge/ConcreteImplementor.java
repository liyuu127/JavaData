package base.designpatterns.structuralpattern.bridge;

/**
 * @author liyu
 * @date 2019/12/4 14:10
 * @description 具体实现化(Concrete Implementor)角色：
 * 这个角色给出实现化角色接口的具体实现。
 */

public class ConcreteImplementor implements Implementor {
    public void operationImpl() {
        //具体实现
        System.out.println("ConcreteImplementor.class.getName() = " + ConcreteImplementor.class.getName());
    }
}
