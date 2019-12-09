package base.designpatterns.behavioralpattern.observer;

/**
 * @author liyu
 * @date 2019/12/8 16:41
 * @description
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: "
                + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
