package base.designpatterns.behavioralpattern.strategy;

/**
 * @author liyu
 * @date 2019/12/9 10:37
 * @description 环境角色
 */
public class Context {
    private Strategy strategy;
    public Double calRecharge(Double charge, Integer type) {
        // 利用一个工厂去生成对应的策略
        strategy = StrategyFactory.getInstance().creator(ReChargeTypeEnum.from(type));
        if (strategy == null) {
            throw new RuntimeException("策略生成错误");
        }
        return strategy.calRecharge(charge);
    }
}
