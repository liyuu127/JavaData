package base.designpatterns.structuralpattern.proxy.jdkproxy;

/**
 * @author liyu
 * @date 2019/12/5 16:45
 * @description
 */
public class HelloWorldImpl implements HelloWorld {
    @Override
    public void sayHelloWorld(String name) {
        System.out.println("Hello " + name);
    }
}
