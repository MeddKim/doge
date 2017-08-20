package com.doge.fileupload.demo.thread;

/**
 * Created by Meddkim on 2017/8/13.
 */
public class ThreadTest2 {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i < 10;i++)
                    System.out.println("线程"+Thread.currentThread().getId()+"输出："+i);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i < 10;i++)
                    System.out.println("线程"+Thread.currentThread().getId()+"输出："+i);
            }
        });

        thread1.start();
        thread2.start();
    }


}
