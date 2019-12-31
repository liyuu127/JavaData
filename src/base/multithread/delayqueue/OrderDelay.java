package base.multithread.delayqueue;

import lombok.Getter;
import lombok.Setter;
import lombok.var;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author liyu
 * @date 2019/12/25 8:43
 * @description
 */
public class OrderDelay implements Delayed {

    private static final int expireTime = 15000;

    @Getter
    @Setter
    private int orderId;
    @Getter
    @Setter
    private Date orderTime;

    /**
     * 消息是否到期（是否可以被读取出来）判断的依据。当返回负数，说明消息已到期，此时消息就可以被读取出来了
     *
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return orderTime.getTime() + expireTime - new Date().getTime();
    }

    /**
     * 往DelayQueue里面塞入数据会执行这个方法，是数据应该排在哪个位置的判断依据。
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        return this.orderTime.getTime() - ((OrderDelay) o).orderTime.getTime() > 0 ? 1 : -1;
    }
}
