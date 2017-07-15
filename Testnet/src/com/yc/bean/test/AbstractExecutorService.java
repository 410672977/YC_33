package com.yc.bean.test;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class AbstractExecutorService implements ExecutorService {

	protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
		return null; };

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
		return null; };

    public Future<?> submit(Runnable task) {
		return null;};

    public <T> Future<T> submit(Runnable task, T result) {
		return null; };

    public <T> Future<T> submit(Callable<T> task) {
		return null; };

    @SuppressWarnings("unused")
	private <T> T doInvokeAny(Collection<? extends Callable<T>> tasks,boolean timed, long nanos)

        throws InterruptedException, ExecutionException, TimeoutException {
			return null;

    };

    public <T> T invokeAny(Collection<? extends Callable<T>> tasks)

        throws InterruptedException, ExecutionException {
			return null;

    };

    public <T> T invokeAny(Collection<? extends Callable<T>> tasks,

                           long timeout, TimeUnit unit)

        throws InterruptedException, ExecutionException, TimeoutException {
			return null;

    };

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)

        throws InterruptedException {
			return null;

    };

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,

                                         long timeout, TimeUnit unit)

        throws InterruptedException {
			return null;

    };

}
