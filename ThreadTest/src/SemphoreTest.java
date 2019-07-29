
import java.util.concurrent.Semaphore;

/**
 * semphore
 */
class MyThreadTest implements  Runnable{
    @Override
    public void run() {
        System.out.println("啊哈哈哈哈哈哈");
    }
}
public class SemphoreTest {
    private static Semaphore semaphore=new Semaphore(5);
    class MyThreadTest implements  Runnable{
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("啊哈哈哈哈哈哈");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args) {


            /*Thread test=new Thread(MyThreadTest);
            test.start();*/
           /* for(int i=0;i<10;i++){
                int finalI = i;
                new Thread(new Runnable() {
                  @Override
                  public void run() {
                      try {
                          semaphore.acquire();
                          Thread.sleep(1000);
                          System.out.println(finalI+"------------------------------");
                          semaphore.release();
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
              }).start();
            }*/
    }
}
