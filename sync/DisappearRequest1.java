package sync;

public class DisappearRequest1 implements Runnable {

    private static DisappearRequest1 instance = new DisappearRequest1();


   static int a=0;

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            a++;
        }
        
    }

    public static void main(String[] args) throws Exception{

        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        System.out.println(a);

    }


}
