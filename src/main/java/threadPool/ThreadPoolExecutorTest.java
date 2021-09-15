package threadPool;

import java.util.concurrent.*;

/**
 * 线程池的核心参数是
 * 1、池子里核心线程数
 * 2、池子里最大线程数
 * 3、任务队列(需要执行的任务)
 *
 * 线程池工作原理
 * 线程5个状态: new -> ready -> running -> blocking -> finish
 * 启动的时候，将任务放入任务队列中，如果线程数低于核心线程数，则重启一个worker, worker 放入线程队列 workers 中
 * 运行 running 中的线程，然后把最近的 ready 至成 running, 并且继续运行
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {

        /**
         * 自定义线程池，核心线程数，最大线程数，线程队列
         */
        int coreSize = 10;
        int maximumPoolSize = 100;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> queue = new SynchronousQueue<>();
        queue.add(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 1");
            }
        });
        queue.add(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 2");
            }
        });

        ThreadPoolExecutor selfDefinedExecutor = new ThreadPoolExecutor(coreSize, maximumPoolSize, 10L, TimeUnit.SECONDS, queue);
        selfDefinedExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 3");
            }
        });


        selfDefinedExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        });

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(() -> {

        });

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        });
    }
}
