package per.leetcode;
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class L025 {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        ListNode listNode=new ListNode(0);
       ListNode a= new L025().reverseKGroup(l1,2);

       while (a!=null){
           System.out.println(a.val);
           a=a.next;
       }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
       return null;
    }
}
