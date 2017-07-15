package com.yc.bean.test;

import java.util.concurrent.locks.ReentrantLock;

final class Worker implements Runnable {
    private static final int STOP = 0;
	private final ReentrantLock runLock = new ReentrantLock();
    private Runnable firstTask;
    volatile long completedTasks;
    Thread thread;
    Worker(Runnable firstTask) {
        this.firstTask = firstTask;
    }
    boolean isActive() {
        return runLock.isLocked();
    }
    void interruptIfIdle() {
        final ReentrantLock runLock = this.runLock;
        if (runLock.tryLock()) {
            try {
        if (thread != Thread.currentThread())
        thread.interrupt();
            } finally {
                runLock.unlock();
            }
        }
    }
    void interruptNow() {
        thread.interrupt();
    }
    private void runTask(Runnable task, boolean ran) {
        final ReentrantLock runLock = this.runLock;
        runLock.lock();
        try {
            int runState = 0;
			if (runState < STOP &&  Thread.interrupted() && runState >= STOP)
            ran = false;
            beforeExecute(thread, task);   //beforeExecute������ThreadPoolExecutor���һ��������û�о���ʵ�֣��û����Ը���
            //�Լ���Ҫ������������ͺ����afterExecute����������һЩͳ����Ϣ������ĳ�������ִ��ʱ���            
            try {
                task.run();
                ran = true;
                afterExecute(task, null);
                ++completedTasks;
            } catch (RuntimeException ex) {
                if (!ran)
                    afterExecute(task, ex);
                throw ex;
            }
        } finally {
            runLock.unlock();
        }
    }
    private void beforeExecute(Thread thread2, Runnable task) {
		// TODO Auto-generated method stub
		
	}
	private void afterExecute(Runnable task, RuntimeException ex) {
		
	}
	public void run() {
        try {
            Runnable task = firstTask;
            firstTask = null;
            while (task != null || (task = getTask()) != null) {
                runTask(task);
                task = null;
            }
        } finally {
            workerDone(this);   //�����������û������ʱ������������        
        }
    }
	private void runTask(Runnable task) {
		
	}
	private Runnable getTask() {
		return null;
	}
	private void workerDone(Worker worker) {
		
	}
}
