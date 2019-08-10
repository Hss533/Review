package per.offer;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static BigInteger string2int(String str) {



        if(str.charAt(str.length()-1)=='.')
            return new BigInteger("0");
        if(str.charAt(0)=='.')
            return new BigInteger("0");
        int flag=0;
        int count=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='.')
                flag++;
            if(str.charAt(i)<='9'&&str.charAt(i)>='0')
                count++;

        }
        if(count+flag!=str.length())
            return new BigInteger("0");
        if(flag!=0)
        {
            if(flag!=1)
            {
                return new BigInteger("0");
            }
        }


        if(str.contains("."))
        {
            str=str.split("\\.")[0];

        }
        char[] a=str.toCharArray();
        int j=0;
        StringBuilder stringBuilder=new StringBuilder("");

        for(int i=0;i<a.length;i++)
        {
            if(a[i]<='9'&&a[i]>='0')
                stringBuilder.append(a[i]);
            else {
                stringBuilder=new StringBuilder("0");
                break;
            }
        }

        if(stringBuilder.toString().equals("0"))
            return new BigInteger("0");
        int result=0;
        char[] c=stringBuilder.toString().toCharArray();
        int k=0;
        BigInteger r=new BigInteger("0");
        for(int i=c.length-1;i>=0;i--)
        {
           BigInteger t=new BigInteger((c[i]-48)*Math.pow(10,k)+"");
            r.add(t);
           result+=(c[i]-48)*Math.pow(10,k);
           k++;
        }
        return r;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        BigInteger res;

        String _str;
        try {
            _str = in.nextLine();
        } catch (Exception e) {
            _str = null;
        }

        res = string2int(_str);
        if(_str.charAt(0)=='-')
        {
            res=string2int(_str.substring(1,_str.length())).add(new BigInteger("-1"));
            if(res.equals(new BigInteger("0")))
               ;
        }


        System.out.println(String.valueOf(res));

    }
}

/**
 * 整理彩球
 时间限制：C/C++语言 1000MS；其他语言 3000MS
 内存限制：C/C++语言 65536KB；其他语言 589824KB
 题目描述：
 小明家有一些彩球，一段时间后小明玩耍时将它们无序的散落在家中，一天，小明想对其进行整理，规则为一个篮子中只放一种颜色彩球，可有多个篮子放同一颜色的球，每个篮子里的球不少于2个。假设小明整理好后，能使各篮子中彩球数量是相同的，则认为小明整理好了。用一个数字表示一种颜色彩球，一组数表示小明已经找到了的彩球，问小明用找到的全部彩球能按规则整理好么？

 输入
 第一行彩球总数: n,  2<n<10000

 第二行一段整数ai,  1<ai<10000  (排除ai全部相等的情况)

 输出
 若能整理好，最小篮子数；否则0


 样例输入
 6
 1 1 2 2 2 2
 样例输出
 3

 提示
 样例输入:
 6
 1 1 2 2 2 2
 样例输出:
 3      	tip: [1, 1] [2, 2] [2, 2]
 样例输入:
 5
 1 1 1 2 2
 样例输出:
 0     		tip: [1 1 1] [2 2]

 样例输入:
 6
 1 1 1 2 2 2
 样例输出:
 2      	tip: [1 1 1] [2 2 2]
 */