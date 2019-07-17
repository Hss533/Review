package leetcodoe;

/**
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Test24 {
    public static void main(String[] args) {

    }
    public ListNode swapPairs(ListNode head) {

        if(head.next==null){
            return head;
        }
        ListNode current=head;
        ListNode pre=head.next;
        while (pre==null){
            head.next=pre.next;
            pre.next=head;
            current=current.next;
            if(current.next!=null){
                pre=current.next;
            }
        }
        return null;
    }
}
