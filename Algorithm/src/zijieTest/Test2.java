package zijieTest;

        import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sn=new Scanner(System.in);
        int use=sn.nextInt();
        int result=1024-use;
        int count=0;
        for(int i=0;i<result;i++){
            if(64*i<=result&&64*(i+1)>result){
                result=result-i*64;
                count+=i;
                break;
            }
        }

        for(int i=0;i<result;i++){
            if(16*i<=result&&16*(i+1)>result){
                result=result-i*16;
                count+=i;
                break;
            }
        }

        for(int i=0;i<result;i++){
            if(4*i<=result&&4*(i+1)>result){
                result=result-i*4;
                count+=i;
                break;
            }
        }

        count+=result;
        System.out.println(count);
    }
}
