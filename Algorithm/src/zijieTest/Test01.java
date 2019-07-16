package zijieTest;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a=new int[n][3];
        for(int i = 0; i < n; i++){
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
            a[i][2]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            int b=test(a[i][0],a[i][1],a[i][2]);
            System.out.println(b);
        }


//        test(2013,3,31);
    }
    public static int test(int year,int month,int day){

        Calendar calendar1=new GregorianCalendar(2012,3,12);
        Calendar calendar2=new GregorianCalendar(year,month,day);

       /*
        Date dates1= new Date(2012,3,12);
        Date dates2= new Date(year,month,day);
        */
        System.out.println(calendar1.getTime());
        System.out.println(calendar2.getTime());
        long diff;
        long tim1=calendar1.getTime().getTime();
        long tim2=calendar2.getTime().getTime();

        if(tim1<tim2){
            diff=tim2-tim1;
        }
        else {
            diff=tim1-tim2;
        }
        return (int)(diff/(24*60*60*1000));
    }
}
