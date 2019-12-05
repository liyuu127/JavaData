package base.designpatterns.structuralpattern.bridge;

/**
 * @author liyu
 * @date 2019/12/4 14:12
 * @description 修正抽象化(Refined Abstraction)角色：扩展抽象化角色，改变和修正父类对抽象化的定义。
 */

public class RefinedAbstraction extends Abstraction {
    public void operation() {
        System.out.println("\"impl\" = " + "impl");
        //代码
        impl.operationImpl();
        //代码
    }
}
