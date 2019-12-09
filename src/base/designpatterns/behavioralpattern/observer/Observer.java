package base.designpatterns.behavioralpattern.observer;

/**
 * @author liyu
 * @date 2019/12/8 16:29
 * @description
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
