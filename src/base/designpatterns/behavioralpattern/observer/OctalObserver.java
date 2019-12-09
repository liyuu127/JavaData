package base.designpatterns.behavioralpattern.observer;

/**
 * @author liyu
 * @date 2019/12/8 16:39
 * @description
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: "
                + Integer.toOctalString(subject.getState()));
    }
}
