package base.designpatterns.structuralpattern.proxy.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author liyu
 * @date 2019/12/5 17:58
 * @description
 */
public class CglibProxyExample implements MethodInterceptor {
    /**
     * 代理逻辑方法
     * @param o 代理对象
     * @param method 方法
     * @param objects 方法参数
     * @param methodProxy 方法代理
     * @return 代理逻辑返回
     * @throws Throwable 异常
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用真实对象前");
        //CGLIB反射调用真实对象方法
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("反射调用对象之后");
        return invoke;
    }

    /**
     * 生成CGLIB代理对象
     * @param cls Class类
     * @return Class类的CGLIB代理对象
     */
    public Object getProxy(Class cls,Class[] argumentTypes, Object[] arguments){
        //CGLIB enhancer 增强对象
        Enhancer enhancer = new Enhancer();
        //设置增强类型
        enhancer.setSuperclass(cls);
        //定义代理逻辑对象为当前对象，要求当前对象实现 MethodInterceptor 方法
        enhancer.setCallback(this);
        //生成并返回代理对象
        return enhancer.create(argumentTypes,arguments);
    }
}
