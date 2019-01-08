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
			System.out.println("�̳߳����߳���Ŀ:"+executor.getCorePoolSize()+",�����еȴ�ִ�е�������Ŀ��"+executor.getQueue().size()+"����ִ������������Ŀ��"
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
		// TODO �Զ����ɵķ������
		System.out.println("�߳�"+x+"��ʼִ��---------------------��ʼִ��");
		try {
			 Thread.currentThread().sleep(4000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�߳��쳣");
		}
		System.out.println("�߳�"+x+"ִ�н���---------------------ִ�н���");
	}
	
}
