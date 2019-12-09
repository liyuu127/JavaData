package base.designpatterns.behavioralpattern.strategy;

import lombok.*;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2019/12/9 10:43
 * @description 策略枚举类
 */

@AllArgsConstructor
@Getter
public enum ReChargeTypeEnum {
    E_BANK(1, "网银"),

    BUSI_ACCOUNTS(2, "商户账号"),

    MOBILE(3, "手机充值"),

    CARD_RECHARGE(4, "充值卡");
    private int value;
    private String description;

    public static ReChargeTypeEnum from(int value) {
        return Arrays.stream(values())
                .filter(element -> element.getValue() == (value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("no type for this value"));
    }

}
