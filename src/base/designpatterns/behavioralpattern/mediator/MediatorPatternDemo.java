package base.designpatterns.behavioralpattern.mediator;

/**
 * @author liyu
 * @date 2019/12/8 15:35
 * @description
 */
public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
