package base.multithread.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liyu
 * @date 2019/11/25 13:37
 * @description ×ÔĞıËø
 */
public class SpinLock {
    private AtomicReference<Thread> cas = new AtomicReference<Thread>();
    public void lock() {
        Thread current = Thread.currentThread();
        // ÀûÓÃCAS
        while (!cas.compareAndSet(null, current)) {
            // DO nothing
        }
    }
    public void unlock() {
        Thread current = Thread.currentThread();
        cas.compareAndSet(current, null);
    }
}
