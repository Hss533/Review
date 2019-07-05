package zijieTest;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/7037a3d57bbd4336856b8e16a9cafd71?orderByHotValue=1&page=1&onlyReference=false
 来源：牛客网

 机器人正在玩一个古老的基于DOS的游戏。游戏中有N+1座建筑——从0到N编号，从左到右排列。编号为0的建筑高度为0个单位，编号为i的建筑的高度为H(i)个单位。

 起初， 机器人在编号为0的建筑处。每一步，它跳到下一个（右边）建筑。假设机器人在第k个建筑，且它现在的能量值是E, 下一步它将跳到第个k+1建筑。它将会得到或者失去正比于与H(k+1)与E之差的能量。如果 H(k+1) > E 那么机器人就失去 H(k+1) - E 的能量值，否则它将得到 E - H(k+1) 的能量值。

 游戏目标是到达第个N建筑，在这个过程中，能量值不能为负数个单位。现在的问题是机器人以多少能量值开始游戏，才可以保证成功完成游戏？
 */
public class Test3 {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        double[] array=new double[n+1];
        array[0]=0;
        for(int i=1;i<=n;i++){
            array[i]=scanner.nextDouble();
        }
        System.out.println(cal(array));
    }
    public static  int  cal(double[] array){

        double t[]=new double[array.length];
        t[array.length-1]=0;
        for(int i=array.length-1;i>0;i--){
            t[i-1]=(array[i]+t[i])/2;
        }
        for(int i=0;i<t.length;i++){
//            System.out.print(t[i]+" ");
        }
//        System.out.println();
        String a=t[0]+"";
//        System.out.println(a);
//        System.out.println();
        String[] a1=a.split("\\.");
        for(int i=0;i<a1.length;i++){
//            System.out.println(a1[i]);
        }
//        System.out.println(a1);
        int result=Integer.valueOf(a1[0]);
        if(t[0]>result){
            result+=1;
        }
        return result;
    }
}
