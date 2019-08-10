import javax.security.sasl.SaslClient;
import java.util.*;

public class WANGYi1 {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int i=scanner.nextInt();
        String[] a=new String[i];
        while (i<0){
            a[i]=scanner.next();
            i--;
        }
        System.out.println(help("(A2A)B2"));
    }
    public static String help(String str){
        char[] strs=str.toCharArray();
        Stack<Character> stack=new Stack<>();
        StringBuffer stringBuffer=new StringBuffer("");
        for(int i=0;i<str.length();)
        {
            if(i>=str.length())
                break;
            if(strs[i]=='(')
            {
                stack.push(strs[i]);
                i++;
            }
            if(i>=str.length())
                break;
            if(strs[i]>='A'&&strs[i]<='Z'){
                stack.push(strs[i]);
                i++;
            }
            if(i>=str.length())
            {
                System.out.println();
                break;
            }
            if(strs[i]==')')
            {
                i++;
                int num=0;
                StringBuffer stringBuffer1=new StringBuffer("");
                for(int j=i;j<strs.length;j++){
                    if(strs[j]>='0'&&strs[j]<='9')
                    {
                        stringBuffer1.append(strs[j]);
                        i++;
                    }
                    else break;
                }
                if(stringBuffer1==null||stringBuffer1.toString().equals("")){
                    num=1;
                }
                else
                {
                    num=Integer.valueOf(stringBuffer1.toString());
                }
                List<Character> result=new ArrayList<>();
                while (stack.peek()!='('){
                    result.add(stack.pop());
                }
                stack.pop();

                Collections.reverse(result);
                String re="";
                for(int t=0;t<result.size();t++){
                    re+=result.get(t);
                }
                String r="";
                for(int t=0;t<num;t++){
                    r+=re;
                }

                for(int t=0;t<r.length();t++){
                    stack.push(r.charAt(t));
                }
            }
            if(strs[i]>='1'&&strs[i]<='9')

            {
                StringBuffer stringBuffer1=new StringBuffer("");
                stringBuffer1.append(strs[i]);
                i++;


                for(int j=i;j<strs.length;j++){
                    if(strs[j]>='0'&&strs[j]<='9')
                    {
                        stringBuffer1.append(strs[j]);
                        i++;
                    }
                    else break;
                }
                int num=Integer.valueOf(stringBuffer1.toString());
                List<Character> result=new ArrayList<>();
                while (stack.peek()>='A'&&stack.peek()<='Z'){
                    result.add(stack.pop());
                }
                //stack.pop();

                Collections.reverse(result);
                String re="";
                for(int t=0;t<result.size();t++){
                    re+=result.get(t);
                }
                String r="";
                for(int t=0;t<num;t++){
                    r+=re;
                }

                for(int t=0;t<r.length();t++){
                    stack.push(r.charAt(t));
                }


            }
        }

        System.out.println(stack);
        return null;
    }
}
