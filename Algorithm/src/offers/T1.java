package offers;

import java.util.Arrays;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }
public class T1 {
    public static void main(String[] args) {

//        System.out.println(4<<1);
//        System.out.println(count(4));
        System.out.println(7>>1);
        System.out.println(count(10));
    }

    public static  int count(int n){
        /*int count=0;
        while (n>0){
            count++;
            n=n&(n-1);
        }
        return count;
        */
        int count = 0;
        int flag = 1;
        int f=0;
        while (n>0) {
            if ((n & flag) != 0) {
                count++;
            }
            n=n>>1;
        /*    System.out.println(f++);
            flag = flag << 1;
        */
        }
        return count;
    }
}
