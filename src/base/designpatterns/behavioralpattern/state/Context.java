package base.designpatterns.behavioralpattern.state;

/**
 * @author liyu
 * @date 2019/12/8 17:23
 * @description
 */
public class Context {
    private State state;

    public Context(){
        state = null;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }
}
