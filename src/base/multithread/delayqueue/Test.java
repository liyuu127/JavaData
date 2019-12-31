package base.multithread.delayqueue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.DelayQueue;

/**
 * @author liyu
 * @date 2019/12/25 8:52
 * @description
 */
public class Test {
    static DelayQueue<OrderDelay> queue = new DelayQueue<>();

    public static void main(String[] args) {

        //测试DelayQueue的顺序
//        demo1();

        Thread productThread = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                produce(i);
            }
        });
        productThread.start();


        Thread consumThread = new Thread(() -> {
            consum();
        });
        consumThread.start();
    }

    private static void demo1() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);

        Date time1 = c.getTime();
        OrderDelay orderDelay1 = new OrderDelay();
        orderDelay1.setOrderId(1);
        orderDelay1.setOrderTime(time1);
        queue.put(orderDelay1);
        System.out.println("1： " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(time1));

        c.add(Calendar.DATE, -15);
        Date time2 = c.getTime();
        OrderDelay orderDelay2 = new OrderDelay();
        orderDelay2.setOrderId(2);
        orderDelay2.setOrderTime(time2);
        queue.put(orderDelay2);

        System.out.println("2： " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(time2));
        int a = 0;
    }

    /**
     * 生产者方法
     *
     * @param orderId
     */
    private static void produce(int orderId) {
        OrderDelay delay = new OrderDelay();
        delay.setOrderId(orderId);
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        delay.setOrderTime(currentTime);
        System.out.printf("现在时间是%s;订单%d加入队列%n", dateString, orderId);
        queue.put(delay);
    }

    /**
     * 消费者方法
     */
    private static void consum() {
        while (true) {
            try {
                OrderDelay orderDelay = queue.take();//
                Date currentTime = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = formatter.format(currentTime);
                System.out.printf("现在时间是%s;订单%d过期%n", dateString, orderDelay.getOrderId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
