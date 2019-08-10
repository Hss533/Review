package leetcodoe;

import java.nio.charset.Charset;
import java.util.*;

/**
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 输出:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]

 */
public class Test49 {
    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        if(strs.length==0){
            return new ArrayList<>();
        }
        Map<String,List> result=new HashMap<>();
        for(String s:strs){
            char[] a=s.toCharArray();
            Arrays.sort(a);
            String key=String.valueOf(a);
            if(!result.containsKey(key))
                result.put(key,new ArrayList());
            result.get(key).add(s);
        }
        return new ArrayList(result.values());
    }
}
