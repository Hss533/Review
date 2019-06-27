import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * NIO 非阻塞式IO
 * 非阻塞时IO的关键是
 */
public class TestNoBlockingNIO
{

    @Test
    public void client() throws IOException {

        SocketChannel socketChannel= SocketChannel.open(new InetSocketAddress("127.0.0.1",8989));
                //切换成非阻塞模式
        //切换成非阻塞模式
        socketChannel.configureBlocking(false);

        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

        //后面新添加的功能  来一个循环发送

        Scanner scanner=new Scanner(System.in);

        java.lang.String str=scanner.next();
        byteBuffer.put((new Date().toString()+"\n"+str).getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        byteBuffer.clear();
       /* while (scanner.hasNext())
        {

        }*/
        //发送数据给服务端
        socketChannel.close();
    }

    @Test
    public void server() throws Exception{
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();

        //切换成非阻塞模式
        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.bind(new InetSocketAddress(8989));

        Selector selector=Selector.open();

        //将通道注册到选择器上 指定监听接受事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //使用选择器轮询式获取选择器上已经准备就绪的时间
        while(selector.select()>0){
            //获取当前选择器中所有注册的选择键  已就绪的监听事件
            Iterator<SelectionKey> it=selector.selectedKeys().iterator();

            while (it.hasNext()){
                //获取准备就绪的时间
                SelectionKey sk=it.next();

                //判断具体是什么时间准备就绪
                if(sk.isAcceptable()){
                    //如果接受就绪 接受socketChannel
                    SocketChannel socketChannel=serverSocketChannel.accept();
                    //System.out.println(socketChannel);
                    socketChannel.configureBlocking(false);
                    //将该通道注册到选择器上
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }else if(sk.isReadable()){
                    //获取当前选择器上“读就绪”状态的通道
                    SocketChannel socketChannel=(SocketChannel)sk.channel();

                   // System.out.println("读取");
                    ByteBuffer buffer=ByteBuffer.allocate(1024);

                    int len=0;
                    while ((len=socketChannel.read(buffer))>0){
                        buffer.flip();
                        System.out.println(new java.lang.String(buffer.array(),0,len));
                        buffer.clear();
                    }
                }
                //取消选择键 不取消就会一直有效
                it.remove();
            }

        }

    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println(scanner.next());

       /* SocketChannel socketChannel= SocketChannel.open(new InetSocketAddress("127.0.0.1",8989));
        //切换成非阻塞模式
        //切换成非阻塞模式
        socketChannel.configureBlocking(false);

        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

        //后面新添加的功能  来一个循环发送

        Scanner scanner=new Scanner(System.in);

        java.lang.String str=scanner.next();
        byteBuffer.put((new Date().toString()+"\n"+str).getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        byteBuffer.clear();
       *//* while (scanner.hasNext())
        {

        }*//*
        //发送数据给服务端
        socketChannel.close();*/
    }
}