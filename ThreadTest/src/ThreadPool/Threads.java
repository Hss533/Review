package ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 *
 * 批量获取多条线程的执行结果
 *      自己维护返回结果
 *      使用ExecutorService的invokeAll函数
 *      使用CompletionService
 *
 */
public class Threads {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(10);//创建线程池
        //ThreadPoolExecutor a=new ThreadPoolExecutor(10,);
        List<Future<String>> futures=new ArrayList<Future<String>>();
        for(int i=0;i<10;i++){
            int finalI = i;
            Future<String>  result=executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {

                    int sleepTime = new Random().nextInt(1000);
                    Thread.sleep(sleepTime);
                    return "线程"+finalI+"睡了"+sleepTime+"秒";
                }
            });
            futures.add(result);
        }
        //获取10个任务的返回结果
        for(int i=0;i<10;i++){
            Future<String> future=futures.get(i);
            String result=future.get();
            System.out.println(result);
        }
    }
}
