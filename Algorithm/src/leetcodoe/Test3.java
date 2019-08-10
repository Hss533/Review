package leetcodoe;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

//找出重复的字符时  立即跳出该窗口 可以参考一下题解
public class Test3
{
    public static void main(String[] args) {
        System.out.println(myslengthOfLongestSubstring("abcabcbb"));
    }
    //官方题解
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    public static int mylengthOfLongestSubstring(String s) {

        int start=0;
        int end=0;
        Set<Character> result=new HashSet<>();
        int max=0;
        while (start<s.length()&&end<s.length()){
            if(!result.contains(s.charAt(end))){
                result.add(s.charAt(end));
                max=Math.max(max,end-start+1);
                end++;
            }
            else {
                result.remove(s.charAt(start));
                start++;
            }
        }
        return max;
    }
    //巧解
    static int myslengthOfLongestSubstring(String s) {
        int  size,i=0,j,k,max=0;
        size = s.length();
        for(j = 0;j<size;j++){
            for(k = i;k<j;k++)
                if(s.charAt(k)==s.charAt(j)){
                    i = k+1;
                    break;
                }
            if(j-i+1 > max)
                max = j-i+1;
        }
        return max;
    }

}
