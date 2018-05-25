package com.wt.algorithm4.concurrent;

import ch.qos.logback.core.util.TimeUtil;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @Author WuTian
 * @Date 2018-04-23 19:16
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 1000L, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>(8), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
        BoundedHashSet<String> set = new BoundedHashSet<>(5);
        for (int i = 0; i < 10; i++) {
            final int j = i;
            executor.submit(() -> {
                try {
                    set.add("String"+j);
                    System.out.println("String"+j+" added");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }
}


class BoundedHashSet<T> {
    private final Set<T> objects;
    private final Semaphore sem;

    public BoundedHashSet(int bound) {
        this.objects = Collections.synchronizedSet(new HashSet<T>());
        sem = new Semaphore(bound);
    }

    public boolean add(T item) throws InterruptedException {
        sem.acquire();
        boolean added = false;
        try {
            added = objects.add(item);
            return added;
        } finally {
            if (!added) {
                sem.release();
            }
        }
    }

    public boolean remove(T item) {
        boolean removed = objects.remove(item);
        if (removed) {
            sem.release();
        }
        return removed;
    }

}