package leetcodoe;

/**
 * 跳跃游戏
 */
public class Test55 {
    public static void main(String[] args) {
        canJump(new int[]{3,2,1,0,4});
    }
    public  static boolean canJump(int[] nums)
    {
        int length=nums.length;
        boolean[] pandaun=new boolean[length];
        pandaun[length-1]=true;
        for(int i=length-2;i>=0;i--){
            if(nums[i]==0)
                pandaun[i]=false;
            else {
                for(int j=i+1;j<=nums[i]+i;j++){
                   /* System.out.println("i="+i);
                    System.out.println("j="+j);
                    System.out.println("-------------");*/
                    if(j<length) {
                        if (pandaun[j] == true) {
                                    pandaun[i] = true;
                        }
                    }
                }
                //pandaun[i]=false;
            }
        }
        for(int i=0;i<length-1;i++){
//            System.out.print(pandaun[i]+" ");
        }
        return pandaun[0];
    }
}
