package leetcodoe;

/**
 * 翻转链表
 */
public class Test206 {
    public static void main(String[] args) {
        ListNode l11=new ListNode(1);
        ListNode l12=new ListNode(2);
       /* l11.next=l12;*/
        ListNode l13=new ListNode(3);
        ListNode l14=new ListNode(4);
        ListNode l15=new ListNode(5);
        /*l12.next=l13;
        l13.next=l14;
        l14.next=l15;*/

        Test206 test206=new Test206();
//        test206.print(l11);

        ListNode re=test206.reverseList(l11);
        test206.print(re);
    }
    public  void print(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
    public ListNode reverseList(ListNode head) {

        if(head==null)
            return null;

        ListNode pre=null;
        ListNode cur=head;
        ListNode next=null ;
        if(head.next==null){
            return head;
        }
        else {
            next=head.next;
        }
        while (next!=null){
            cur.next=pre;
            pre=cur;
            cur=next;
            next=next.next;
        }
        cur.next=pre;
        return cur;
    }
}
