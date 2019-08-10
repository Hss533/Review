package leetcodoe;

public class Test5 {
    public static void main(String[] args) {

        System.out.println(longestPalindrome("ccdcc"));
    }

    public static String longestPalindrome(String s) {

        if(s==null||"".equals(s)){
            return s;
        }
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.charAt(0) + "";
            }
        }
        int max = 0;
        int index=0;
        int judge=0;
        String result="";
        for (int i = 1; i < s.length() - 1; i++) {

            int num = 1;
            int j = i;
            int big=0;
            if (s.charAt(i - 1) == s.charAt(i + 1)) {
                judge=1;
                int t = 1;
                while (s.charAt(j - t) == s.charAt(j + t)) {
                    num += 2;
                    t++;
                    if (j - t < 0 || j + t >=s.length()) {
                        break;
                    }
                }
                big=num;
            }
            if(s.charAt(i)==s.charAt(i+1)) {
                judge=-1;
                num = 0;
                int t1 = 0;
                int t2 = 1;
                while (s.charAt(j - t1) == s.charAt(j + t2)) {
                    num += 2;
                    t1++;
                    t2++;
                    if(j-t1<0||j+t2>=s.length()){
                        break;
                    }
                }
                if(num<big){
                    judge=1;
                    num=big;
                }
            }
            if (num >=max) {
                max = num;
                index=i;
                if(judge==1){
                    result=s.substring(index-(num-1)/2,index+(num-1)/2+1);
                }
                if(judge==-1){
                    result=s.substring(index-num/2+1,index+num/2+1);
                }
//                System.out.println(i+"=======i");
            }
//            System.out.println(result);
//            System.out.println(num);
//            System.out.println(max);
        }
        if("".equals(result)){
            if(s.charAt(0)==s.charAt(1)){
                return s.substring(0,2);
            }
            else return s.charAt(0)+"";
        }
        return result;
    }
}
