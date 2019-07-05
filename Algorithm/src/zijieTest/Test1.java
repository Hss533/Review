package zijieTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        List<String> stringList=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            stringList.add(scanner.next());
        }
        for(int i=0;i<n;i++)
        {
            System.out.println(change(stringList.get(i)));
        }

    }
    public  static  String change(String str){
        if(str==null || str.length()<=2)
            return str;
        for(int i=0;i<str.length()-3;i++)
        {
            //AABB的情况
            if(str.charAt(i)==str.charAt(i+1)&&str.charAt(i+2)==str.charAt(i+3)){
                str=delete(str,i+2);
                i--;
            }
            //三个A的情况
            if((str.charAt(i)==str.charAt(i+1))&&(str.charAt(i)==str.charAt(i+2))){
                //进行删除
                str=delete(str,i);
                i--;
            }

        }
        //删除结尾
        int n= str.length();
        if(str.charAt(n-1)==str.charAt(n-2)&&str.charAt(n-3)==str.charAt(n-1)){
            str=delete(str,n-1);
        }
        return str;
    }
    public static String delete(String str,int i){
        //删除某个项
        String newstr=str.substring(0,i)+str.substring(i+1);
        return newstr;
    }
}
