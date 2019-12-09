package base.designpatterns.behavioralpattern.templatemethod;

/**
 * @author liyu
 * @date 2019/12/9 14:45
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();

    }
}
