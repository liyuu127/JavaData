package base.designpatterns.behavioralpattern.command;

/**
 * @author liyu
 * @date 2019/12/8 13:57
 * @description
 */
public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}
