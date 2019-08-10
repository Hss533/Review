package leetcodoe;

public class Test38 {
    public  String countAndSay(int n) {
        String[] t=new String[30];
        t[0]="1";
        t[1]="11";
        for(int i=2;i<30;i++){
            t[i]=countAndSay1(t[i-1]);

        }
        return t[n-1];
    }
    public static void main(String[] args) {
        System.out.println(new Test38().countAndSay(1));
    }
    public  String countAndSay1(String n) {
        String a=n+"";
        char[] chars=a.toCharArray();
        StringBuffer re=new StringBuffer("");
        for(int i=0;i<chars.length;){
           char t=chars[i];
           int num=1;
           int j=i+1;
           for(j=i+1;j<chars.length;j++){

               if(chars[j]==t){
                   num++;
               }
               else break;
           }
           re.append(num+""+t);
           i=j;
        }
        return re.toString();
    }
}
