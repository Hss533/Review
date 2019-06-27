import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class TestPipe {

    @Test
    public void test() throws Exception{

        //获取管道
        Pipe pipe=Pipe.open();
        //将缓冲区中的数据写入管道
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        Pipe.SinkChannel sinkChannel=pipe.sink();
        byteBuffer.flip();
        sinkChannel.write(byteBuffer);

        //读取缓冲区中数据
        Pipe.SourceChannel sourceChannel=pipe.source();
        byteBuffer.flip();
        int len=sourceChannel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array(),0,len));
        sourceChannel.close();
        sinkChannel.close();
    }
}
