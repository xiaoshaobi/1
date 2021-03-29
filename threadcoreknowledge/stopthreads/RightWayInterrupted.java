package threadcoreknowledge.stopthreads;

/**
 * 描述：     注意Thread.interrupted()方法的目标对象是“当前线程”，而不管本方法来自于哪个对象
 */
public class RightWayInterrupted {

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                }
            }
        });

        // 启动线程
        threadOne.start();
        //设置中断标志
        threadOne.interrupt();
        //获取中断标志
        System.out.println("isInterrupted: " + threadOne.isInterrupted()); //true  因为上面就是 中断了
        //获取中断标志并重置
        System.out.println("isInterrupted: " + threadOne.interrupted());//  interrupteds把标记清除，但是目标对象是当前线程的， 所以是 false
        //获取中断标志并重直
        System.out.println("isInterrupted: " + Thread.interrupted()); // 同理，  也是当前线程，也是false
        //获取中断标志
        System.out.println("isInterrupted: " + threadOne.isInterrupted()); //这个方法才是查看运行线程的中断状态
        threadOne.join();
        System.out.println("Main thread is over.");
    }
}
