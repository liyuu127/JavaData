package base.designpatterns.behavioralpattern.command;

/**
 * @author liyu
 * @date 2019/12/8 13:55
 * @description 创建实现了 Order 接口的实体类
 */
public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}
