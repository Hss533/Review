package leetcodoe;

/**
 *
 输入: version1 = "7.5.2.4", version2 = "7.5.3"
 输出: -1

 */
public class Test165 {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.0.0.0","1.0.0"));
    }
    public static int compareVersion(String version1, String version2) {

        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int low=v1.length>v2.length?v2.length:v1.length;
        for(int i=0;i<low;i++){
            if(Integer.valueOf(v1[i])>Integer.valueOf(v2[i])){
                return 1;
            }
            else if(Integer.valueOf(v1[i])<Integer.valueOf(v2[i])){
                return -1;
            }
        }
        if(v1.length!=low){
            for(int i=low;i<v1.length;i++){
                if(Integer.valueOf(v1[i])!=0){
                    return 1;
                }
            }
        }

        if(v2.length!=low){
            for(int i=low;i<v2.length;i++){
                if(Integer.valueOf(v2[i])!=0){
                    return -1;
                }
            }
        }
        return 0;
    }
}
