package base.designpatterns.structuralpattern.facade;

/**
 * @author liyu
 * @date 2019/12/5 11:40
 * @description cpu子系统类
 * 实现了子系统的功能。它对客户角色和Facade时未知的。它内部可以有系统内的相互交互，也可以由供外界调用的接口
 */
public class CPU {

    public void start() {
        System.out.println("cpu is start...");
    }

    public void shutDown() {
        System.out.println("CPU is shutDown...");
    }
}
