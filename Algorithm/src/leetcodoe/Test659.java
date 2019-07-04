package leetcodoe;

import java.util.*;

/**
 * 分割子数组
 */
// 1,2,3,4,4,5,5
//
// 1,2,3,4,5
// 1,2,3
    //TODO 2019/7/5
public class Test659 {
    public static void main(String[] args)
    {
       /* Solution a=new Solution();
        a.isPossible(new int[]{1,2,3,3,4,4,5,5});*/
            isPossible(new int[]{1,2,3,3,4,4,5,5});
    }
    public static boolean isPossible(int[] nums) {

        HashMap<Integer,Integer> free=new HashMap();
        HashMap<Integer,Integer> appendFreq=new HashMap();
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();

        /*for(int i=0;i<nums.length-1;i++)
        {
            if(free.get(nums[i])!=)
            {
                free.put(nums[i],free.get(nums[i])+1);
            }
            else {
                free.put(nums[i],1);
            }
        }*/
        ArrayList<Integer> arrayList=new ArrayList<>();
        for(int i=0;i<3;i++){
            arrayList.add(nums[i]);
        }
        result.add(arrayList);
        for(int i=3;i<nums.length;i++){
            System.out.println();
            //如果能找到以这个结尾的，就加入
            //如果不能找到就创建新数组
            int flag=0;
            for(int j=0;j<result.size();j++){
                int size=result.get(j).size();
                if(nums[i]==result.get(j).get(size-1)+1){
                    result.get(j).add(nums[i]);
                    flag=1;
                }
            }
            //创建新数组
            if(flag==0)
            {
                ArrayList<Integer> arrayList1=new ArrayList<>();
                arrayList1.add(nums[i]);
                result.add(arrayList1);
            }
        }

        System.out.println(result);


        return false;
    }
}
//appendfreq用来判断当前元素是否能够插入到一个已经构建好的序列末端
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(),
                appendfreq = new HashMap<>();

        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            System.out.println(appendfreq.getOrDefault(i,0));

            //若当前元素个数为0， continue
            if (freq.get(i) == 0) continue;
                //大于0，表示当前元素可以插入到已经构建好的序列的末端
            else if (appendfreq.getOrDefault(i, 0) > 0) {
                appendfreq.put(i, appendfreq.get(i) - 1);
                appendfreq.put(i + 1, appendfreq.getOrDefault(i + 1, 0) + 1);
            }
            //表示当前元素可以作为新序列的第一个元素
            else if (freq.getOrDefault(i + 1, 0) > 0 && freq.getOrDefault(i + 2, 0) > 0) {
                freq.put(i + 1, freq.get(i + 1) - 1);
                freq.put(i + 2, freq.get(i + 2) - 1);
                //注意这里，构建好一个序列，那么该序列最后一个元素+1一定能插入到序列末端
                appendfreq.put(i + 3, appendfreq.getOrDefault(i + 3, 0) + 1);
            }
            else return false;
            freq.put(i, freq.get(i) - 1);
        }

        return true;
    }
}
