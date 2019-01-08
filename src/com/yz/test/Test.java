package com.yz.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,200,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(5));
		for(int i=0;i<15;i++) {
			Xc xc = new Xc(i);
			executor.execute(xc);
			System.out.println("线程池中线程数目:"+executor.getCorePoolSize()+",队列中等待执行的任务数目："+executor.getQueue().size()+"，已执行完别的任务数目："
					+executor.getCompletedTaskCount());
			
		}
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
		System.out.println("线程"+x+"开始执行---------------------开始执行");
		try {
			 Thread.currentThread().sleep(4000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("线程异常");
		}
		System.out.println("线程"+x+"执行结束---------------------执行结束");
	}
	
}
