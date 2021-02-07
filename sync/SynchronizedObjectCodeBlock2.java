package sync;

public class SynchronizedObjectCodeBlock2 implements Runnable {
    private static SynchronizedObjectCodeBlock2 instance = new SynchronizedObjectCodeBlock2();
    Object lock1 = new Object();
    Object lock2 = new Object();

    /**
     * 这里run方法里面用到了两个锁对象，
     * 外面如果多线程调用这里，就会出现并行情况
     * 线程0 释放lock1解锁后，去获取lock2; 线程1 就会获取lock1.
     *
     */
    @Override
    public void run() {

        synchronized (lock1) {
            try {
                System.out.println("我是lock1， i name is:" + Thread.currentThread().getName());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "。lock1 部分 运行结束");
        }
        synchronized (lock2) {
            try {
                System.out.println("我是lock2， i name is:" + Thread.currentThread().getName());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ".lock2 部分 运行结束");
        }
    }
    public static void main(String[] args) throws Exception {

        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        while(thread1.isAlive()||thread2.isAlive()){

        }
        System.out.println("finished");
    }
}
