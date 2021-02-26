package sync;

/**
 * 可重入粒度测试，递归调用本方法
 */
public class SynchronizedRecursion10 {

    int a;

    public static void main(String[] args) {
        SynchronizedRecursion10 synchronizedRecursion10=new SynchronizedRecursion10();
        synchronizedRecursion10.method1();
    }

    private synchronized void method1() {
        System.out.println("a=="+a);
        if(a==0){
            a++;
            method1();
            method2();
        }
    }

    private synchronized void  method2(){

    }
}
