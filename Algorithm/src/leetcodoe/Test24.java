package leetcodoe;


/**
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Test24 {
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
        ListNode re=new Test24().swapPairs(l11);
        System.out.println(re);
    }
    public  void print(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
    public ListNode swapPairs(ListNode head) {

        ListNode newnode=head;
        if(head.next==null){
            return head;
        }
        ListNode current=head;
        ListNode pre=head.next;
        head=pre;
        while (pre!=null){
            newnode.next=pre.next;
            pre.next=newnode;

            current=current.next;
            if(current!=null){
                pre=current.next;
            }
        }
        return null;
    }
}
