package base.multithread.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liyu
 * @date 2019/11/25 13:37
 * @description 自旋锁
 * TASLock TTASLock
 */
public class SpinLock {
    private AtomicReference<Thread> cas = new AtomicReference<Thread>();
    public void lock() {
        Thread current = Thread.currentThread();
        // 如果锁未被占用，则设置当前线程为锁的拥有者
        while (!cas.compareAndSet(null, current)) {
            // DO nothing
        }
    }
    public void unlock() {
        Thread current = Thread.currentThread();
        // 只有锁的拥有者才能释放锁
        cas.compareAndSet(current, null);
    }
}
