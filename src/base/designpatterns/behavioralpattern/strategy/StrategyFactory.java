package base.designpatterns.behavioralpattern.strategy;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author liyu
 * @date 2019/12/9 10:38
 * @description ²ßÂÔ¹¤³§
 */
public class StrategyFactory {
    private static StrategyFactory factory = new StrategyFactory();
    private static Map<ReChargeTypeEnum, Supplier<Strategy>> map = new HashMap<>();

    static {
        map.put(ReChargeTypeEnum.E_BANK, EBankStrategy::new);
        map.put(ReChargeTypeEnum.BUSI_ACCOUNTS, BusiAcctStrategy::new);
        map.put(ReChargeTypeEnum.MOBILE, MobileStrategy::new);
        map.put(ReChargeTypeEnum.CARD_RECHARGE, CardStrategy::new);
    }

    public static StrategyFactory getInstance() {
        return factory;
    }

    public Strategy creator(ReChargeTypeEnum type) {
        return Optional.ofNullable(map.get(type))
                .orElseThrow(() -> new IllegalArgumentException("no such type"))
                .get();
    }

}
