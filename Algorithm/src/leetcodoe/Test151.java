package leetcodoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test151 {
    public static void main(String[] args) {
        System.out.println(reverseWords("    ")+"----");
    }
    public static String reverseWords(String s) {
        s=s.trim();
        System.out.println(s+"++++");
        if (s.length()==0){
            return "";
        }
        String[] r=s.split(" ");
        StringBuilder result=new StringBuilder("");
        Stack<String> strings=new Stack<>();

        for(int i=0;i<r.length;i++){
            if(!("".equals(r[i]))&&!("".equals(r[i].trim())))
            strings.push(r[i]);
        }
        System.out.println(strings);
        while (!strings.isEmpty()){
            result.append(strings.pop()+" ");
        }
        System.out.println(result.length());
        return result.substring(0,result.length()-1);
    }
}
