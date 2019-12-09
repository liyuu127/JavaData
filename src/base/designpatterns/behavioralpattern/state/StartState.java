package base.designpatterns.behavioralpattern.state;

/**
 * @author liyu
 * @date 2019/12/8 17:23
 * @description
 */
public class StartState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    public String toString() {
        return "Start State";
    }
}