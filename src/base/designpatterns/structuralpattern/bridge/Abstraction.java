package base.designpatterns.structuralpattern.bridge;

/**
 * @author liyu
 * @date 2019/12/4 14:11
 * @description 抽象化(Abstraction)角色：
 * 抽象化给出的定义，并保存一个对实现化对象的引用。
 */

public abstract class Abstraction {
    protected Implementor impl;

    public void setImpl(Implementor impl) {
        this.impl = impl;
    }

    public abstract void operation();
}

