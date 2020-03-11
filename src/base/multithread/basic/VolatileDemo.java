package base.multithread.basic;

/**
 * @author liyu
 * @date 2020/3/5 11:45
 * @description volatile[?v?l?tl]关键字
 * synchronized关键字和volatile关键字比较
 * 1.volatile关键字是线程同步的轻量级实现，所以volatile性能肯定比synchronized关键字要好。但是volatile关键字只能用于变量而synchronized关键字可以修饰方法以及代码块。synchronized关键字在JavaSE1.6之后进行了主要包括为了减少获得锁和释放锁带来的性能消耗而引入的偏向锁和轻量级锁以及其它各种优化之后执行效率有了显著提升，实际开发中使用 synchronized 关键字的场景还是更多一些。
 * 2.多线程访问volatile关键字不会发生阻塞，而synchronized关键字可能会发生阻塞
 * 3.volatile关键字能保证数据的可见性，但不能保证数据的原子性。synchronized关键字两者都能保证。
 * 4.volatile关键字主要用于解决变量在多个线程之间的可见性，而 synchronized关键字解决的是多个线程之间访问资源的同步性。
 */
public class VolatileDemo {

}