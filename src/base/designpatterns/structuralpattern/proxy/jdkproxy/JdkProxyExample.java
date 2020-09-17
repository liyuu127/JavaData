package base.designpatterns.structuralpattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liyu
 * @date 2019/12/5 16:47
 * @description 第 1 步，建立代理对象和真实对象的关系。这里是使用了 bind 方法去完成的 ， 方法里面首先用类的属性 target 保存了真实对象 ， 然后通过如下代码建立并生成代理对象。
 * 第 2 步，实现代理逻辑方法。 invoke 方法可 以实现代理逻辑，
 */
public class JdkProxyExample implements InvocationHandler {
    //真实对象
    private Object target = null;


    /**
     * 代理方法逻辑
     *
     * @param proxy  代理对象，就是 bind 方法生成的对象
     * @param method 当前调度方法
     * @param args   当前方法返回参数
     * @return 代理结果返回
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("-----------");
        Object invoke = method.invoke(target, args);
        System.out.println("--------------");
        return invoke;
    }

    /**
     * 建立真实对象与代理对象的关系
     *
     * @param target 真实对象
     * @return 代理对象
     */
    public Object bind(Object target) {
        this.target = target;
        /**
         *  newProxyInstance 方法包含 3 个参数
         *  第 1 个是类加载器，我们采用了 target 本身 的类加载器
         *  第 2 个是把生成的动态代理对象下挂在哪些接口下 ，这个写法就是放在 target 实现的接口下。 HelloWorldImpl 对象的接口显然就是 HelloWorld，代理对象可以这样声明： HelloWorld proxy = xxxx ；
         *  第 3 个是定义实现方法逻辑的代理类， this 表示当前对象，它必须实现InvocationHandler 接口的 invoke 方法 ，它就是代理逻辑方法的现实方法。
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
