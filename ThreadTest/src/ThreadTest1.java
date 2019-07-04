/**
 * 使用多线程交替打印
 */

class TestThread implements Runnable {
    int i = 1;
    @Override
    public void run() {
        while (true) {
            /*指代的为TestThread,因为使用的是implements方式。若使用继承Thread类的方式，慎用this*/
            synchronized (this) {
                /*唤醒另外一个线程，注意是this的方法，而不是Thread*/
                notify();
                try {
                    /*使其休眠100毫秒，放大线程差异*/
                    Thread.currentThread();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i>0){
                    System.out.println("ali----"+Thread.currentThread().getName()+"----i="+i);
                    i++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(i==100) System.exit(0);
                //不能使用while就会卡住
               /* if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;
                    try {
                        *//*放弃资源，等待*//*
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/
            }
        }
    }
}
class MyThread implements Runnable{
    int i=0;
    synchronized  void a(){
        i++;
    }
    @Override
    public void run() {

        while (true) {
            synchronized (this){
                a();
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i + "-----" + Thread.currentThread().getName());

            }
        }
    }
}
public class ThreadTest1 {
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        Thread b=new Thread(myThread);
        Thread a=new Thread(myThread);
        a.start();
        b.start();

        TestThread testThread=new TestThread();
        System.out.println("ah");
//        TestThread testThread1=new TestThread();
        Thread t1=new Thread(testThread);
        Thread t2=new Thread(testThread);
//        Thread t3=new Thread(testThread);
//        t1.start();
//        t2.start();
//        t3.start();
    }
}
