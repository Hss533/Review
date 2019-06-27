import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.channels.FileChannel.open;

public class TestChannel {
    //利用通道完成文件的复制 非直接缓冲区的方式
    @Test
   public void test() throws Exception{
       FileInputStream fileInputStream=new FileInputStream("C:\\Users\\hu\\Desktop\\1.jpg");
        FileOutputStream fileOutputStream=new FileOutputStream("C:\\Users\\hu\\Desktop\\5.jpg");

        //获取通道
        FileChannel fileChannel=fileInputStream.getChannel();
        FileChannel fileChannel1=fileOutputStream.getChannel();


        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

        //将通道中的数据存入缓冲区中
        while (fileChannel.read(byteBuffer)!=-1){
            byteBuffer.flip();
            fileChannel1.write(byteBuffer);
            byteBuffer.clear();
        }
        fileChannel.close();
        fileChannel1.close();
        fileInputStream.close();
        fileOutputStream.close();
   }

   //内存映射文件的方式完成文件的复制(直接缓冲区)
   @Test
   public void test2() throws  Exception{
        //读模式
       FileChannel inChannel=FileChannel.open(Paths.get("C:\\Users\\hu\\Desktop\\1.jpg"), StandardOpenOption.READ);
       FileChannel outChannel=FileChannel.open(Paths.get("C:\\Users\\hu\\Desktop\\7.jpg"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);//和new create有所区别

       MappedByteBuffer mappedByteBuffer=inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
       MappedByteBuffer outBuffer1=outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

       //直接对缓冲区进行读写操作
       byte[] dst=new byte[mappedByteBuffer.limit()];
       mappedByteBuffer.get(dst);
       outBuffer1.put(dst);

       inChannel.close();
       outChannel.close();


   }

   //通道之间的数据传输 transform()  transTo() 直接缓冲区的方式
   @Test
    public void test3() throws Exception{
       FileChannel inChannel=FileChannel.open(Paths.get("C:\\Users\\hu\\Desktop\\1.jpg"), StandardOpenOption.READ);
       FileChannel outChannel=FileChannel.open(Paths.get("C:\\Users\\hu\\Desktop\\7.jpg"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);//和new create有所区别

       inChannel.transferTo(0,inChannel.size(),outChannel);

//       outChannel.transferFrom(inChannel,0,inChannel.size());
       inChannel.close();
       outChannel.close();
   }

   //分散与聚集  分散读取：将通道中的数据分散到多个缓冲区中
   // 聚集写入 ：将多个缓冲区中的数据聚集到通道中
    @Test
    public void test4() throws  Exception{
        RandomAccessFile file=new RandomAccessFile("C:\\Users\\hu\\Desktop\\1.txt","rw");

        //获取通道
        FileChannel channel=file.getChannel();
        //分配指定大小的缓冲区
        ByteBuffer byteBuffer1=ByteBuffer.allocate(10);
        ByteBuffer byteBuffer2=ByteBuffer.allocate(100);
        ByteBuffer byteBuffer3=ByteBuffer.allocate(1024);

        //分散读取
        ByteBuffer[] byteBuffers={byteBuffer1,byteBuffer2,byteBuffer3};
        channel.read(byteBuffers);

        for(ByteBuffer byteBuffer:byteBuffers){
            byteBuffer.flip();
        }
        System.out.println(byteBuffers[0].array());
        System.out.println("--------------------------------");
        System.out.println(byteBuffers[1].array());
        System.out.println("--------------------------------");
        System.out.println(byteBuffers[2].array());

        //聚集写入
        RandomAccessFile randomAccessFile=new RandomAccessFile("C:\\Users\\hu\\Desktop\\2.txt","rw");
        FileChannel fileChannel=randomAccessFile.getChannel();

        fileChannel.write(byteBuffers);
    }

    /**
     * 字符串转换为字节数组的过程叫做编码
     * 解码字节数组转换成字符串的过程
     */
    @Test
    public void test5() throws  Exception{
        Charset.availableCharsets();//看一下支持多少种字符集

        Charset cs2=Charset.forName("GBK");
        CharsetEncoder ce=cs2.newEncoder();//获取编码器
        CharsetDecoder charsetDecoder=cs2.newDecoder();//获取解码器

        CharBuffer charBuffer=CharBuffer.allocate(1024);
        charBuffer.put("胡莎莎最美");
        charBuffer.flip();

        ByteBuffer byteBuffer=ce.encode(charBuffer);

        for(int i=0;i<10;i++){
            System.out.println(byteBuffer.get());
        }
        byteBuffer.flip();
        CharBuffer charBuffer1=charsetDecoder.decode(byteBuffer);
        System.out.println(charBuffer1.toString());

    }
}
