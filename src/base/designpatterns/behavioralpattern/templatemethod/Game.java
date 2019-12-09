package base.designpatterns.behavioralpattern.templatemethod;

/**
 * @author liyu
 * @date 2019/12/9 14:36
 * @description
 */
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模板
    public final void play(){

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
