import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 */
interface Subject
{

    void  addObserver(Observer observer);
    void  removeObserver(Observer observer);
    void  notifyObserver();


}
interface Observer{
    //观察者只有收信息的行为
    void collect(String message);
}
class User implements Observer{
    private String name;
    private String message;
    public User(String name){
        this.name =name;
    }

    @Override
    public void collect(String message) {
        this.message=message;
        read();
    }
    public void read(){
        System.out.println(name+"收到了推送消息"+message);
    }
}
//被观察者的实现类  ，也就是微信公总号服务
class WeChatServer implements Subject{

    //注意到这个list集合的繁星参数为Observer接口 ，设计原则 ，面向接口编程而不面向实现编程
    private List<Observer> list=new ArrayList<>();
    private  String message;

    @Override
    public void addObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (!list.isEmpty())
            list.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < list.size(); i++) {
            Observer observer = list.get(i);
            observer.collect(message);
        }

    }
    public void setInformation(String s){
        this.message=s;
        System.out.println("微信服务更新消息"+s);
        //消息更新的时候 通知所有观察者
        notifyObserver();
    }
}
public class ObserverTest
{
    public static void main(String[] args) {
        WeChatServer server=new WeChatServer();

        Observer observerA=new User("A");
        Observer observerB=new User("B");
        Observer observerC=new User("C");

        server.addObserver(observerA);
        server.addObserver(observerB);
        server.addObserver(observerC);

        server.setInformation("ahhhhhh ");

        System.out.println("-----------");
        server.removeObserver(observerA);
        server.setInformation("heiheihei");

    }
}
/**
 *
 * 微信服务更新消息ahhhhhh
 A收到了推送消息ahhhhhh
 B收到了推送消息ahhhhhh
 C收到了推送消息ahhhhhh
 -----------
 微信服务更新消息heiheihei
 B收到了推送消息heiheihei
 C收到了推送消息heiheihei
 */
