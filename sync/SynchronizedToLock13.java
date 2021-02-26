package sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedToLock13 {

    Lock lock = new ReentrantLock();

    public synchronized void method1() {
        System.out.println("我是 synchronized形式的锁");
    }

    public void method2() {
        lock.lock();
        try{
            System.out.println("我是 lock 锁");
        }finally {
            lock.unlock();
        }
    }

}
