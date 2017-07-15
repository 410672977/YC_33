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
            beforeExecute(thread, task);   //beforeExecute方法是ThreadPoolExecutor类的一个方法，没有具体实现，用户可以根据
            //自己需要重载这个方法和后面的afterExecute方法来进行一些统计信息，比如某个任务的执行时间等            
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
            workerDone(this);   //当任务队列中没有任务时，进行清理工作        
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
