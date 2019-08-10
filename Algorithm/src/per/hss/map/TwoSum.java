package per.hss.map;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

        int nums[]=new int[]{2,6,7,4,5};
        int target=9;
       /* HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (m.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = m.get(target - nums[i]);
                break;
            }
            m.put(nums[i], i);
        }
        System.out.println();*/
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int i=0;i<nums.length;i++)
       {
           map.put(nums[i],0);
       }
       for(int i=0;i<nums.length;i++)
       {
           if(map.get(target-nums[i])!=null)
           {
               System.out.println(nums[i]);
           }
       }
    }
}
