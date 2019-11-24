package base.multithread;

import java.util.concurrent.Callable;

/**
 * @author liyu
 * @date 2019/11/24 17:43
 * @description
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        //返回执行当前 Callable 的线程名字
        return Thread.currentThread().getName();
    }
}