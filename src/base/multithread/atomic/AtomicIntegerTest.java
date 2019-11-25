package base.multithread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liyu
 * @date 2019/11/25 15:53
 * @description AtomicInteger 常见方法使用
 * AtomicInteger：整型原子类
 * AtomicLong：长整型原子类
 * AtomicBoolean ：布尔型原子类
 * public final int get() //获取当前的值
 * public final int getAndSet(int newValue)//获取当前的值，并设置新的值
 * public final int getAndIncrement()//获取当前的值，并自增
 * public final int getAndDecrement() //获取当前的值，并自减
 * public final int getAndAdd(int delta) //获取当前的值，并加上预期的值
 * boolean compareAndSet(int expect, int update) //如果输入的数值等于预期值，则以原子方式将该值设置为输入值（update）
 * public final void lazySet(int newValue)//最终设置为newValue,使用 lazySet 设置之后可能导致其他线程在之后的一小段时间内还是可以读到旧的值。
 */
public class AtomicIntegerTest {

    public static void main(String[] args) {
        int temvalue = 0;
        AtomicInteger i = new AtomicInteger(0);

        temvalue = i.getAndSet(3);
        System.out.println("temvalue = " + temvalue);
        System.out.println("i = " + i);

        boolean b = i.compareAndSet(3, 4);
        System.out.println("b = " + b);
        System.out.println("i = " + i);
    }
}
