package base.designpatterns.behavioralpattern.templatemethod;

/**
 * @author liyu
 * @date 2019/12/9 14:45
 * @description
 */
public class Football extends Game {

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}
