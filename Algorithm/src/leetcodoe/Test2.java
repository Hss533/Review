package leetcodoe;

import java.util.Stack;

/**
 * 栈
 */
public class Test2 {
    public static void main(String[] args) {

        System.out.println(evalRPN(new String[]{"2","3","+"}));

    }
    public  static int evalRPN(String[] tokens) {
        if(tokens.length==0)
            return 0;

        Stack<Integer> strings=new Stack<>();
        int i=0;
        while (i<tokens.length){
            try
            {
                int a=Integer.valueOf(tokens[i]);
                strings.push(a);

            }catch (Exception e){
                int b=strings.pop();
                int c=strings.pop();
                int result=0;
                if(tokens[i].equals("+")){
                    result=b+c;
                }
                if(tokens[i].equals("-")){
                    result=c-b;
                }
                if(tokens[i].equals("*")){
                    result=b*c;
                }
                if(tokens[i].equals("/")){
                    result=c/b;
                }
                strings.push(result);
            }
            i++;
        }

        return strings.pop();
    }
}
