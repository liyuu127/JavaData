package base.multithread.basic;

/**
 * @author liyu
 * @date 2019/12/18 17:25
 * @description 验证线程的内存屏障
 * <p>
 * 为什么我们调用 start() 方法时会执行 run() 方法，为什么我们不能直接调用 run() 方法？
 * 这是另一个非常经典的 java 多线程面试问题，而且在面试中会经常被问到。很简单，但是很多人都会答不上来！
 * new 一个 Thread，线程进入了新建状态;调用 start() 方法，会启动一个线程并使线程进入了就绪状态，当分配到时间片后就可以开始运行了。 start() 会执行线程的相应准备工作，然后自动执行 run() 方法的内容，这是真正的多线程工作。 而直接执行 run() 方法，会把 run 方法当成一个 main 线程下的普通方法去执行，并不会在某个线程中执行它，所以这并不是多线程工作。
 * 总结： 调用 start 方法方可启动线程并使线程进入就绪状态，而 run 方法只是 thread 的一个普通方法调用，还是在主线程里执行。
 */
public class ThreadTest {

    //    static volatile boolean flag = false;
    static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!flag) {
            }
            System.out.println("flag = " + flag);
        });

        thread.start();
        thread.sleep(2000);
        flag = true;
        System.out.println("flag1 = " + flag);

    }

}
