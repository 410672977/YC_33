package com.yc.bean.test;

import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolExecutor extends AbstractExecutorService {

	//private final BlockingQueue<Runnable> workQueue; // ���񻺴���У�������ŵȴ�ִ�е�����
	private final ReentrantLock mainLock = new ReentrantLock(); // �̳߳ص���Ҫ״̬�������̳߳�״̬�������̳߳ش�С
	// ��runState�ȣ��ĸı䶼Ҫʹ�������
	private final HashSet<Worker> workers = new HashSet<Worker>(); // ������Ź�����
	private volatile long keepAliveTime; // �̴߳��ʱ��
	private volatile boolean allowCoreThreadTimeOut; // �Ƿ�����Ϊ�����߳����ô��ʱ��
	private volatile int corePoolSize; // ���ĳصĴ�С�����̳߳��е��߳���Ŀ�����������ʱ���ύ������ᱻ�Ž����񻺴���У�
	private volatile int maximumPoolSize; // �̳߳���������̵��߳���
	private volatile int poolSize; // �̳߳��е�ǰ���߳���
	private volatile RejectedExecutionHandler handler; // ����ܾ�����
	private volatile ThreadFactory threadFactory; // �̹߳��������������߳�
	private int largestPoolSize; // ������¼�̳߳����������ֹ�������߳���
	private long completedTaskCount; // ������¼�Ѿ�ִ����ϵ��������

//	public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,BlockingQueue<Runnable> workQueue) {
//	
//	}
//
//	public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
//
//			BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
//	}
//
//	public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
//
//			BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
//	}
//
//	public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
//
//			BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
//	}

	@Override
	public void shutdown() {

	}

	@Override
	public boolean isShutdown() {
		return false;
	}

	@Override
	public boolean isTerminated() {
		return false;
	}

	@Override
	public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
		return false;
	}

	@Override
	public void execute(Runnable command) {

	}

}