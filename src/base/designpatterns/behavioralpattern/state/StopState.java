package base.designpatterns.behavioralpattern.state;

/**
 * @author liyu
 * @date 2019/12/8 17:24
 * @description
 */
public class StopState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    public String toString() {
        return "Stop State";
    }

}