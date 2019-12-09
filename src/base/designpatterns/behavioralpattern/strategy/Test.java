package base.designpatterns.behavioralpattern.strategy;

/**
 * @author liyu
 * @date 2019/12/9 11:17
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Context context = new Context();

        /**
         * 计算四种计算方式
         */
        Double aDouble = context.calRecharge(100D, ReChargeTypeEnum.E_BANK.getValue());
        Double bDouble = context.calRecharge(100D, ReChargeTypeEnum.BUSI_ACCOUNTS.getValue());
        Double cDouble = context.calRecharge(100D, ReChargeTypeEnum.MOBILE.getValue());
        Double dDouble = context.calRecharge(100D, ReChargeTypeEnum.CARD_RECHARGE.getValue());

        System.out.println(aDouble + "\t" + bDouble + "\t" + cDouble + "\t" + dDouble);
    }
}
