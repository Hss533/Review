import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Date;
import java.util.Scanner;

public class UDPTest {
    public static void main(String[] args) {
        System.out.println("asdas");
    }
    @Test
    public void send() throws IOException{

        DatagramChannel datagramChannel=DatagramChannel.open();
        datagramChannel.configureBlocking(false);
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.next();
            byteBuffer.put(new Date().toString().getBytes());
            byteBuffer.flip();
            datagramChannel.send(byteBuffer,new InetSocketAddress("127.0.0.1",9898));
        }
    }
    @Test
    public void receive(){

    }
}
