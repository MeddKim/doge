package com.doge.fileupload.demo.thread;

import java.util.concurrent.*;

/**
 * Created by Meddkim on 2017/8/13.
 */

class RunnableTest implements Runnable{
    @Override
    public void run() {
        for(int i=1;i < 20;i++)
            System.out.println("线程"+Thread.currentThread().getId()+"输出："+i);
    }
}

class CallableTest implements Callable<String>{

    @Override
    public String call() throws Exception {
        for(int i=1;i < 10;i++)
            System.out.println("线程"+Thread.currentThread().getId()+"输出："+i);

        return "执行完毕";
    }
}



public class ThreadTest3 {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable runnable = new RunnableTest();
        Callable callable = new CallableTest();

        executorService.submit(runnable);
        Future<String> future = executorService.submit(callable);
        try {
            System.out.println(future.get());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
