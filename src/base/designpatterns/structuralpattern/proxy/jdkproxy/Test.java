package base.designpatterns.structuralpattern.proxy.jdkproxy;

/**
 * @author liyu
 * @date 2019/12/5 17:21
 * @description JDK 动态代理必须提供接口才能使用
 */
public class Test {
    public static void main(String[] args) {
        JdkProxyExample jdk = new JdkProxyExample();
        //绑定关系，因为挂在接口 HelloWorld 下，所以声明代理对象 HelloWorld proxy
        HelloWorld proxy = (HelloWorld) jdk.bind(new HelloWorldImpl());
        //注意 ，此时 HelloWorld 对象己经是一个代理对象，它会进入代理的逻辑方法 invoke 里
        proxy.sayHelloWorld("liyu");
    }
}
