import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestBlockingNIO2 {

    @Test
    public void client() throws IOException{

        SocketChannel socketChannel=SocketChannel.open(new InetSocketAddress("127.0.0.1",8989));

        FileChannel fileChannel=FileChannel.open(Paths.get("C:\\Users\\hu\\Desktop\\2.jpg"), StandardOpenOption.READ);

        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

        while (fileChannel.read(byteBuffer)!=-1){
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        socketChannel.shutdownOutput();

        int len=0;
        while ((len=socketChannel.read(byteBuffer))!=-1)
        {
            byteBuffer.flip();
            System.out.println(byteBuffer);
            byteBuffer.clear();
        }
        fileChannel.close();
        socketChannel.close();
    }
    @Test
    public void server() throws IOException{

        //获取通道
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();

        FileChannel fileChannel=FileChannel.open(Paths.get("C:\\Users\\hu\\Desktop\\4.jpg"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        //绑定链接
        serverSocketChannel.bind(new InetSocketAddress(8989));

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

        byteBuffer.put("服务端接受客户端发送的信息".getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);

        socketChannel.close();
        serverSocketChannel.close();
        fileChannel.close();
    }
}
