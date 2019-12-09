package base.designpatterns.behavioralpattern.observer;

/**
 * @author liyu
 * @date 2019/12/8 16:37
 * @description
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: "
                + Integer.toBinaryString(subject.getState()));
    }

}