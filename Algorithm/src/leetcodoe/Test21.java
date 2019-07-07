package leetcodoe;
/*

* 合并两个有序链表
*
* */
//TODO
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
public class Test21 {
    public static void main(String[] args) {
        ListNode l11=new ListNode(1);
        ListNode l12=new ListNode(3);
        l11.next=l12;
        ListNode l13=new ListNode(5);
        ListNode l14=new ListNode(7);
        ListNode l15=new ListNode(9);
        l12.next=l13;
        l13.next=l14;
        l14.next=l15;

        ListNode l21=new ListNode(2);
        ListNode l22=new ListNode(4);
        ListNode l23=new ListNode(6);
        ListNode l24=new ListNode(8);
        ListNode l25=new ListNode(10);
        l21.next=l22;l22.next=l23;l23.next=l24;l24.next=l25;

        Merge(l11,l21);
    }
    public  static ListNode Merge(ListNode list1,ListNode list2){

        if(list1==null&&list2==null){
            return null;
        }
        if(list1==null)
            return list2;
        if(list2==null)
            return null;
        ListNode l1=list1;
        ListNode l2=list2;


        return null;
    }
}
