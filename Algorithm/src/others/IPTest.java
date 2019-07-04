/**
 * 判断ip地址是否正确
 */
package others;

public class IPTest {
    public static void main(String[] args) {

        String a=new String(".123.123.123.123");
        System.out.println(test(a));
    }
    public static boolean test(String ipString){
        if(ipString==null)
            return false;
        if(ipString.length()<7||ipString.length()>15){
            return false;
        }
        if(ipString.charAt(0)=='.'||ipString.charAt(ipString.length()-1)=='.'){
            return false;
        }
        String[] strs=ipString.split(".");
        if(strs.length!=4){
            return false;
        }
        for(int i=0;i<strs.length;i++){
            try{
            int a=Integer.valueOf(strs[i]);
            if(a>225||a<0)
                return false;
            }
            catch (Exception e){
                return false;
            }
        }
        return true;
    }
}
