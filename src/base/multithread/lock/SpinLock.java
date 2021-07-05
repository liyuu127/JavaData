package base.multithread.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liyu
 * @date 2019/11/25 13:37
 * @description ������
 * TASLock TTASLock
 */
public class SpinLock {
    private AtomicReference<Thread> cas = new AtomicReference<Thread>();
    public void lock() {
        Thread current = Thread.currentThread();
        // �����δ��ռ�ã������õ�ǰ�߳�Ϊ����ӵ����
        while (!cas.compareAndSet(null, current)) {
            // DO nothing
        }
    }
    public void unlock() {
        Thread current = Thread.currentThread();
        // ֻ������ӵ���߲����ͷ���
        cas.compareAndSet(current, null);
    }
}
