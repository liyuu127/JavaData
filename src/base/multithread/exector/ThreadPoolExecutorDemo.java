package base.multithread.exector;

import base.multithread.exector.MyRunnable;

import java.util.concurrent.*;

/**
 * @author liyu
 * @date 2019/11/24 17:06
 * @description 使用线程池的好处：
 * <p>
 * 降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的消耗。
 * 提高响应速度。当任务到达时，任务可以不需要的等到线程创建就能立即执行。
 * 提高线程的可管理性。线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一的分配，调优和监控。
 * <p>
 * 使用 ThreadPoolExecutor 构造函数自定义参数的方式来创建线程池
 * corePoolSize: 核心线程数为 。
 * maximumPoolSize ：最大线程数
 * keepAliveTime : 等待时间为 。
 * unit: 等待时间的单位为 TimeUnit.SECONDS。
 * workQueue：任务队列为 ArrayBlockingQueue,..，并且容量为 XX;
 * threadFactory :executor 创建新线程的时候会用到,一般使用默认
 * handler:饱和策略为：
 * 1>.ThreadPoolExecutor.AbortPolicy：抛出 RejectedExecutionException来拒绝新任务的处理。
 * 2>.ThreadPoolExecutor.CallerRunsPolicy：调用执行自己的线程运行任务。您不会任务请求。但是这种策略会降低对于新任务提交速度，影响程序的整体性能。另外，这个策略喜欢增加队列容量。如果您的应用程序可以承受此延迟并且你不能任务丢弃任何一个任务请求的话，你可以选择这个策略。
 * 3>.ThreadPoolExecutor.DiscardPolicy： 不处理新任务，直接丢弃掉。
 * 4>.ThreadPoolExecutor.DiscardOldestPolicy： 此策略将丢弃最早的未处理的任务请求。
 */
public class ThreadPoolExecutorDemo {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        //该方法返回一个固定线程数量的线程池。该线程池中的线程数量始终不变。当有一个新的任务提交时，线程池中若有空闲线程，则立即执行。
        // 若没有，则新的任务会被暂存在一个任务队列中，待有线程空闲时，便处理在任务队列中的任务
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        //方法返回一个只有一个线程的线程池。若多余一个任务被提交到该线程池，任务会被保存在一个任务队列中，待线程空闲，按先入先出的顺序执行队列中的任务。
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        //该方法返回一个可根据实际情况调整线程数量的线程池。线程池的线程数量不确定，但若有空闲线程可以复用，则会优先使用可复用的线程。若所有线程均在工作，又有新的任务提交，则会创建新的线程处理任务。
        // 所有线程在当前任务执行完毕后，将返回线程池进行复用。
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            Runnable worker = new MyRunnable("" + i);
            //执行Runnable
            executor.execute(worker);
        }
        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }

}
