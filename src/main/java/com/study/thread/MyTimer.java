package com.study.thread;

import java.util.Date;

public class MyTimer extends Thread {
    private Long time ;

    public MyTimer(Long time) {
        this.time = time;
    }
    @Override
    public void  run(){
        while(true){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            doSomeThing();
        }
    }
    /**
     *  开始执行任务
     */
    public void execute(){
        this.start();
    }

    public void  doSomeThing(){
        System.out.println("现在时间"+new Date());
    }

    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer(2000L) ;
        myTimer.execute();
    }
}
