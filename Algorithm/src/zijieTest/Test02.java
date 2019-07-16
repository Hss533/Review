package zijieTest;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count=sc.nextInt();
        int result[]=new int[count];
        for(int i=0;i<count;i++){
            result[i]=sc.nextInt();
        }
        int yin=result[0];
        for(int i=1;i<result.length;i++){
            yin=maxYinshu(yin,result[i]);
        }
        int banshu=0;
        for(int i=0;i<result.length;i++){
            banshu+=result[i]/yin;
        }
        System.out.println(banshu);
    }
    static int  maxYinshu(int a,int b){
        if(b==0){
            return a;

        }
        else {
            return a%b==0?b:maxYinshu(b,a%b);
        }
    }
}
