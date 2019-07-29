import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

class User{
    public User(){
        System.out.println("user 构造方法被调用");
    }
    private String name;
    private int age;
    private static String id="USER_ID";

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +'\'' +
                ", id=" + id +'\'' +
                '}';
    }
}
public class CASTest {
    public static void main(String[] args) throws NoSuchFieldException {
        Field field= Unsafe.class.getField("theUnsafe");


        AtomicInteger a=new AtomicInteger(1);
        a.incrementAndGet();//当前值+1 返回新值

        AtomicIntegerArray atomicIntegerArray=new AtomicIntegerArray(10);
//        atomicIntegerArray.getAndAccumulate();

    }
}
class AtomicIntegerArrayDemo {
    static AtomicIntegerArray arr = new AtomicIntegerArray(10);

    public static class AddThread implements Runnable{
        public void run(){
            for(int k=0;k<10000;k++)
                //执行数组中元素自增操作,参数为index,即数组下标
                arr.getAndIncrement(k%arr.length());

        }
    }
    public static void main(String[] args) throws InterruptedException {

        Thread[] ts=new Thread[10];
        //创建10条线程
        for(int k=0;k<10;k++){
            ts[k]=new Thread(new AddThread());
        }
        //启动10条线程
        for(int k=0;k<10;k++){ts[k].start();}
        for(int k=0;k<10;k++){ts[k].join();}
        //执行结果
        //[10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000]
        System.out.println(arr);
    }
}

