package zijieTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Testtemp
{

    static ArrayList<ArrayList<Integer>> result=new ArrayList<>();
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int x=scanner.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=scanner.nextInt();
        }
        int result=test(a,0,n-1,x);
        System.out.println(result);
    }
    public static int test(int[] a,int start,int end,int x){
        permutation(a,start,end);
        System.out.println(result);
        ArrayList<ArrayList<Integer>> size=new ArrayList<>();
        for(ArrayList<Integer> integers:result){
            int flag=0;
            //判断收尾是否ok
            int temp2=integers.get(0)-integers.get(integers.size()-1);
            if(temp2<0)
                temp2=-temp2;
            if(temp2>x)
                flag=1;
            //判断相邻
            for(int i=1;i<integers.size();i++){
                int temp=integers.get(i)-integers.get(i-1);
                if(temp<0)
                    temp=-temp;
                if(temp>x){
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                size.add(integers);
        }
        return  size.size()/(end+1);
    }
    public static  void permutation(int[] buf, int start, int end) {
        if (start == end) {// 当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
            ArrayList<Integer> integers=new ArrayList<>();
            for (int i = 0; i <= end; i++) {
//                System.out.print(buf[i]);
                integers.add(buf[i]);
            }
//            System.out.println(integers);
           result.add(integers);
        } else {// 多个字母全排列
            for (int i = start; i <= end; i++) {
                int temp = buf[start];// 交换数组第一个元素与后续的元素
                buf[start] = buf[i];
                buf[i] = temp;
                permutation(buf, start + 1, end);// 后续元素递归全排列
                temp = buf[start];// 将交换后的数组还原
                buf[start] = buf[i];
                buf[i] = temp;
            }
        }
    }
}
