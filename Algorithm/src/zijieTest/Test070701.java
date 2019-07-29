package zijieTest;


import java.util.ArrayList;
import java.util.Collections;

public class Test070701 {

    public static void main(String[] args) {
        ArrayList<String> arrayList=new Test070701().Permutation("516810");
        System.out.println(arrayList);
        for(String s:arrayList){
            System.out.println(s);
        }
       /* ArrayList<String> result=new ArrayList<>();
        for(String s:list){
            for(int i=0;i<s.length()-1;i++){
                if(Integer.valueOf(s.charAt(i))-Integer.valueOf(s.charAt(i+1))>8){
                    break;
                }
            }
            result.add(s);
        }
        System.out.println(result.size());*/
    }
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> ans=new ArrayList<>();//所有排列的可能都在这里
        int[] a=new int[]{5,16,8,10};
        if(str!=null||str.length()>0){
            help(0,a,ans);
            Collections.sort(ans);
        }

        return ans;
    }
    public static void help(int i,int[] cha,ArrayList<String> ans){
        if(i==cha.length-1){
            String val = String.valueOf(cha);
            if(!ans.contains(val)){
                ans.add(val);
            }
        }else{
            for(int j=i;j<cha.length;j++){
                swap(i,j,cha);//依次选一个数固定住
                help(i+1,cha,ans);//让后面的进行全排列
                swap(i,j,cha);//恢复原来的模样，回溯关键
            }
        }

    }
    public static void swap(int i,int j,int[] cha){
        int temp=cha[i];
        cha[i]=cha[j];
        cha[j]=temp;
    }

}
