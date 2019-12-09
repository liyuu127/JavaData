package base.designpatterns.behavioralpattern.strategy;

/**
 * @author liyu
 * @date 2019/12/9 11:01
 * @description
 */
public class MobileStrategy implements Strategy {

    @Override
    public Double calRecharge(Double charge) {
        return charge;
    }
}
