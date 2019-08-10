package leetcodoe;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入: candidates = [2,3,5], target = 8,
 所求解集为:
 [
   [2,2,2,2],
   [2,3,3],
   [3,5]
 ]
 */
public class Test39 {
    static  List<List<Integer>> result=new ArrayList<>();
    public static void main(String[] args) {

        new Test39().combinationSum(new int[1],7);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        help(candidates,new ArrayList<>(),0,target);
        return result;
    }
    public void help(int[] array,List<Integer> list,int sum,int target){
        if(sum>=target)
        {
            if(sum==target)
            {
                List<Integer> newlist=new ArrayList<>();
                for(Integer i:list){
                    newlist.add(i);
                }
                System.out.println(list);
            }
            return;
        }

        for(int i=0;i<array.length;i++){

            if(list.size()==0||array[i]>=list.get(list.size()-1)) {
                list.add(array[i]);
                help(array, list, sum + array[i], target);

                int t = list.size() - 1;
                list.remove(t);
            }
        }
    }
}
