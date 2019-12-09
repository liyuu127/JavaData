package base.designpatterns.behavioralpattern.strategy;

/**
 * @author liyu
 * @date 2019/12/9 10:36
 * @description 策略接口
 */
public interface Strategy {
    // 定义计算recharge的方法
    Double calRecharge(Double charge);
}
