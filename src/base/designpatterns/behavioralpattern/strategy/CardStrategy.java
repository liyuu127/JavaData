package base.designpatterns.behavioralpattern.strategy;

/**
 * @author liyu
 * @date 2019/12/9 11:00
 * @description
 */

public class CardStrategy implements Strategy {

    @Override
    public Double calRecharge(Double charge) {
        return charge + charge * 0.01;
    }
}
