package base.designpatterns.structuralpattern.adapter;

/**
 * @author liyu
 * @date 2019/12/4 10:57
 * @description 已经存在的接口，这个接口需要配置
 */
public class Adaptee {
    public void specificRequest() {
        //原本存在的方法
        System.out.println("adaptee");
    }
}
