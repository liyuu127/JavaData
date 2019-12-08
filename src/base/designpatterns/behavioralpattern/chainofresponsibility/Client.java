package base.designpatterns.behavioralpattern.chainofresponsibility;

/**
 * @author liyu
 * @date 2019/12/6 9:55
 * @description
 */
public class Client {

    public static void main(String[] args) {
        //组装责任链
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        handler1.setSuccessor(handler2);
        //提交请求
        handler1.handleRequest();
    }

}
