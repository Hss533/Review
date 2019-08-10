import java.util.Scanner;

public class COFFEE {
    public static void main(String[] args) {
        while (true)
        {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int A=scanner.nextInt();
        int X=scanner.nextInt();
        int coffee[]=new int[N];
        int MAX=0;
        for(int i=0;i<N;i++){
            coffee[i]=scanner.nextInt();
            MAX+=coffee[i];
        }
//        System.out.println(MAX);
        int Total=A*60;
        int Temp=Total*X;
//        System.out.println(Temp);
        if(Temp<MAX){
            int re=MAX-Temp;
            int t=re+X*60;
            if(t>8*60)
            {
                System.out.println(0);

                return;
            }
            else {
                System.out.println(t);
                return;
            }
        }
        else {
            int a=MAX/Total;//2
//            System.out.println(a);
            int re=MAX-(a*Total);
//            System.out.println(re);
            int b=re/A;
//            System.out.println(b);
            if(b*A!=re){
                b=b+1;
            }
//            System.out.println(b);
            System.out.println(a*60+b);
        }

    }
    }
}
