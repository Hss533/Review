package leetcodoe;

import zijieTest.Test4;

import java.util.ArrayList;
import java.util.List;

public class Test46
{
    static   List<List<Integer>> result=new ArrayList<>();
    public static void main(String[] args) {
        new Test46().permute(new int[]{1});
        System.out.println(result);
    }
    public List<List<Integer>> permute(int[] nums) {
        help(0,nums.length-1,nums);
        return result;
    }
    public void help(int k,int m,int[] a){
        if(m==k){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<a.length;i++){
                list.add(a[i]);
            }
            result.add(list);
        }
        for(int i=k;i<=m;i++){

            swap(i,k,a);
            help(k+1,m,a);
            swap(i,k,a);

        }
    }
    public  void swap(int a,int b,int[] array){
        int temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }
}
