package base.multithread.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author liyu
 * @date 2019/11/25 16:16
 * @description AtomicIntegerArray 类常用方法
 * AtomicIntegerArray：整形数组原子类
 * AtomicLongArray：长整形数组原子类
 * AtomicReferenceArray ：引用类型数组原子类
 * public final int get(int i) //获取 index=i 位置元素的值
 * public final int getAndSet(int i, int newValue)//返回 index=i 位置的当前的值，并将其设置为新值：newValue
 * public final int getAndIncrement(int i)//获取 index=i 位置元素的值，并让该位置的元素自增
 * public final int getAndDecrement(int i) //获取 index=i 位置元素的值，并让该位置的元素自减
 * public final int getAndAdd(int delta) //获取 index=i 位置元素的值，并加上预期的值
 * boolean compareAndSet(int i, int expect, int update) //如果输入的数值等于预期值，则以原子方式将 index=i 位置的元素值设置为输入值（update）
 * public final void lazySet(int i, int newValue)//最终 将index=i 位置的元素设置为newValue,使用 lazySet 设置之后可能导致其他线程在之后的一小段时间内还是可以读到旧的值。
 */
public class AtomicIntegerArrayTest {

    public static void main(String[] args) {
        int temvalue = 0;
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        AtomicIntegerArray i = new AtomicIntegerArray(nums);
        for (int j = 0; j < nums.length; j++) {
            System.out.println(i.get(j));
        }
        temvalue = i.getAndSet(0, 2);
        System.out.println("temvalue:" + temvalue + ";  i:" + i);
        temvalue = i.getAndIncrement(0);
        System.out.println("temvalue:" + temvalue + ";  i:" + i);
        temvalue = i.getAndAdd(0, 5);
        System.out.println("temvalue:" + temvalue + ";  i:" + i);
    }

}
