package base.designpatterns.structuralpattern.proxy;

/**
 * @author liyu
 * @date 2019/12/5 14:37
 * @description 主题接口，定义代理类和真实类需要对外提供的服务
 */
public interface IDBQuery {
    String request();
}
