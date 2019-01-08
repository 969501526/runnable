package com.yz.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5,11,200,TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>());
		for(int i=0;i<11;i++) {
			Xc xc = new Xc(i);
			System.out.println("线程池中线程数目:"+executor.getCorePoolSize()+",队列中等待执行的任务数目："+executor.getQueue().size()+"，已执行完别的任务数目："
					+executor.getCompletedTaskCount());	
			executor.execute(xc);
		}
		Thread.sleep(10000);
		System.out.println("线程池中线程数目:"+executor.getCorePoolSize()+",队列中等待执行的任务数目："+executor.getQueue().size()+"，已执行完别的任务数目："
				+executor.getCompletedTaskCount());
		 executor.shutdown();
	}
									
}
class Xc implements Runnable{
	
	private Integer x;
	
	
	public Xc() {
		super();
	}


	public Xc(Integer x) {
		super();
		this.x = x;
	}


	@Override
	public void run() {
		// TODO 自动生成的方法存根
		//System.out.println("线程"+x+"开始执行---------------------开始执行");
		try {
			 Thread.currentThread().sleep(2000);
			 System.out.println(Thread.currentThread().getName()+"run"+x);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("线程异常");
		}
		//System.out.println("线程"+x+"执行结束---------------------执行结束");
	}
	
}

/**
 * 
ThreadPoolExecutor 

int corePoolSize,
     
核心线程数，默认情况下核心线程会一直存活，即使处于闲置状态也不会受存keepAliveTime限制。除非

将allowCoreThreadTimeOut设置为true。                  
 int maximumPoolSize,
    
线程池所能容纳的最大线程数。超过这个数的线程将被阻塞。当任务队列为没有设置大小的

LinkedBlockingDeque时，这个值无效。                   
 long keepAliveTime,
  
非核心线程的闲置超时时间，超过这个时间就会被回收。                     
 TimeUnit unit,
           
   指定keepAliveTime的单位   
 BlockingQueue<Runnable> workQueue
线程池中的任务队列.

常用的有三种队列，SynchronousQueue,LinkedBlockingDeque,ArrayBlockingQueue。

**/
