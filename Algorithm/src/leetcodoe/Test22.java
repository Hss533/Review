package leetcodoe;

import java.util.ArrayList;
import java.util.List;
//这个是要用到递归的
public class Test22 {
    static List<String> parenthesis = new ArrayList<>();

    public static void main(String[] args) {
            generateParenthesis(3);
    }
    public static List<String> generateParenthesis(int n) {
        char[] string = new char[2*n];
        generate(0, n, n, string);
        return parenthesis;
    }

    public static void generate(int index, int open, int close, char[] string) {
        if (open == 0 && close == 0) {
            parenthesis.add(new String(string));
            return;
        }

        if (open-1 >= 0 ) {
            string[index] = '(';
            generate(index+1, open-1, close, string);
        }

        if (close-1 >= open) {
            string[index] = ')';
            generate(index+1, open, close-1, string);
        }
    }
    public static void help(int index,int start,int end,char[] string)
    {

    }
}
