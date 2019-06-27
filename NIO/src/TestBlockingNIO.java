import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 使用NIO完成网络传输的三个核心
 *
 * 通道 缓冲区 选择器（多路复用器）
 * 是用来监控selectableChannel的IO状况
 * fileChannel不能切换为非阻塞模式
 */
public class TestBlockingNIO {

    @Test
    public void client() throws IOException {
        //获取通道
        SocketChannel socketChannel
        =SocketChannel.open(new InetSocketAddress("127.0.0.1",10000));

        FileChannel in=FileChannel.open(Paths.get("C:\\Users\\hu\\Desktop\\1.jpg"), StandardOpenOption.READ);

        //分配指定大小的缓冲区
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

        //读取本地文件 发送到服务器
        while (in.read(byteBuffer)!=-1){
            //切换为读取模式
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        in.close();
        socketChannel.close();

    }
    @Test
    public void server() throws IOException {
        //获取通道
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();

        FileChannel fileChannel=FileChannel.open(Paths.get("C:\\Users\\hu\\Desktop\\2.jpg"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        //绑定链接
        serverSocketChannel.bind(new InetSocketAddress(10000));

        SocketChannel socketChannel=serverSocketChannel.accept();

        //分配指定大小的缓冲区
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

        //接受客户端的数据 并保存到本地
        while (socketChannel.read(byteBuffer)!=-1){
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        fileChannel.close();
        serverSocketChannel.close();

    }

}
