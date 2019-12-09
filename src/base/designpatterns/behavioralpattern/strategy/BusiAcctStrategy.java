package base.designpatterns.behavioralpattern.strategy;

/**
 * @author liyu
 * @date 2019/12/9 11:00
 * @description
 */
public class BusiAcctStrategy implements Strategy {

    @Override
    public Double calRecharge(Double charge) {
        return charge * 0.9;
    }
}
