package leetcodoe;

import java.util.HashMap;
import java.util.Map;

public class Test929 {
    public static void main(String[] args) {

//        System.out.println(help("test.email+alex@leetcode.com"));
        System.out.println(numUniqueEmails(new String[]{
                "testemail@leetcode.com",
                "testemail1@leetcode.com",
                "testemail+david@lee.tcode.com"}));
    }
    public static  int numUniqueEmails(String[] emails) {
        if(emails.length==0)
        return 0;
        Map<String,String> result=new HashMap<>();
        for(int i=0;i<emails.length;i++){
            String s=help(emails[i]);
            if(!result.containsKey(s)){
                result.put(s,"");
            }
        }
        System.out.println(result);
        return result.size();
    }
    public static String help(String emails)
    {
        String[] a=emails.split("\\@");
        StringBuilder stringBuilder=new StringBuilder("");
        String before="";
        if(a[0].contains("+")){
            before=a[0].split("\\+")[0];
        }
        else {
            before=a[0];
        }
        for(int i=0;i<before.length();i++)
        {
            if(before.charAt(i)!='.'){
                stringBuilder.append(before.charAt(i));
            }
        }
        System.out.println(stringBuilder);
        stringBuilder.append("@"+a[1]);
        return stringBuilder.toString();
    }
}
