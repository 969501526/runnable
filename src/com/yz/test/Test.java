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
			System.out.println("�̳߳����߳���Ŀ:"+executor.getCorePoolSize()+",�����еȴ�ִ�е�������Ŀ��"+executor.getQueue().size()+"����ִ������������Ŀ��"
					+executor.getCompletedTaskCount());	
			executor.execute(xc);
		}
		Thread.sleep(10000);
		System.out.println("�̳߳����߳���Ŀ:"+executor.getCorePoolSize()+",�����еȴ�ִ�е�������Ŀ��"+executor.getQueue().size()+"����ִ������������Ŀ��"
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
		// TODO �Զ����ɵķ������
		//System.out.println("�߳�"+x+"��ʼִ��---------------------��ʼִ��");
		try {
			 Thread.currentThread().sleep(2000);
			 System.out.println(Thread.currentThread().getName()+"run"+x);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�߳��쳣");
		}
		//System.out.println("�߳�"+x+"ִ�н���---------------------ִ�н���");
	}
	
}

/**
 * 
ThreadPoolExecutor 

int corePoolSize,
     
�����߳�����Ĭ������º����̻߳�һֱ����ʹ��������״̬Ҳ�����ܴ�keepAliveTime���ơ�����

��allowCoreThreadTimeOut����Ϊtrue��                  
 int maximumPoolSize,
    
�̳߳��������ɵ�����߳�����������������߳̽������������������Ϊû�����ô�С��

LinkedBlockingDequeʱ�����ֵ��Ч��                   
 long keepAliveTime,
  
�Ǻ����̵߳����ó�ʱʱ�䣬�������ʱ��ͻᱻ���ա�                     
 TimeUnit unit,
           
   ָ��keepAliveTime�ĵ�λ   
 BlockingQueue<Runnable> workQueue
�̳߳��е��������.

���õ������ֶ��У�SynchronousQueue,LinkedBlockingDeque,ArrayBlockingQueue��

**/
