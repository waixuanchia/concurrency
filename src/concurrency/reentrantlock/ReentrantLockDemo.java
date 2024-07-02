package concurrency.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
				methodA();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
        
        Thread thread1 = new Thread(() -> {
            try {
				methodA();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
        thread1.start();
        thread1.setName("thread 1");
        thread.setName("thread");
        //Thread.sleep(1000);
        thread.start();
        //Thread.sleep(1000);
    }

    public static void methodA() throws InterruptedException {
        boolean status = lock.tryLock(1,TimeUnit.SECONDS);
        System.out.println(status);
        if(status) {
        	try {
            	
                System.out.println("Lock acquired in methodA "+Thread.currentThread().getName());
                Thread.sleep(5000);
                //methodB();
            } finally {
                lock.unlock();
                System.out.println("Lock released in methodA " + Thread.currentThread().getName());
            }
        }
        
    }

    public static void methodB() {
        lock.lock();
        try {
            System.out.println("Lock acquired in methodB");
        } finally {
            lock.unlock();
            System.out.println("Lock released in methodB");
        }
    }
}
