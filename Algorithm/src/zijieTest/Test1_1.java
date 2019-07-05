package zijieTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
*
*
*
*
* */

public class Test1_1 {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        List<String> stringList=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
//            System.out.println();
            stringList.add(scanner.next());
        }
        for(int i=0;i<n;i++)
        {
            System.out.println(change(stringList.get(i)));
        }

    }
    public static  String  change(String str){

        for(int i=0;i<str.length()-3;i++){

                if(str.charAt(i)==str.charAt(i+1)&&str.charAt(i+2)==str.charAt(i+3)){
                    str=del(str,i+2);
                    i--;
                }
                else
                if(str.charAt(i)==str.charAt(i+1)&&str.charAt(i)==str.charAt(i+2)){
                        str=del(str,i+2);
                        i--;
                    }


        }
        int n=str.length();
        if(n-2>0){
            if(str.charAt(n-1)==str.charAt(n-2)&&str.charAt(n-1)==str.charAt(n-3)){
                str=del(str,n-1);
            }
        }
      //  System.out.println(str);

        return str;
    }
    public  static String del(String str,int i)
    {
        return str.substring(0,i)+str.substring(i+1,str.length());
    }
}
