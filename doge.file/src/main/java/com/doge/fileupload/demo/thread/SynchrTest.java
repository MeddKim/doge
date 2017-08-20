package com.doge.fileupload.demo.thread;

/**
 * 测试线程同步，使用syncr
 * Created by Meddkim on 2017/8/13.
 */

class MyThread3 extends Thread{

    public synchronized static void say(){

    }

    @Override
    public void run(){
        for(int i=1;i < 10;i++)
            System.out.println("线程"+Thread.currentThread().getId()+"输出："+i);
    }
}




public class SynchrTest {


    public static void main(String[] args) {
        Thread thread1 = new MyThread1();
        Thread thread2 = new MyThread1();

        thread1.start();
        thread2.start();
    }
}