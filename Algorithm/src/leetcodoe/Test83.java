package leetcodoe;

public class Test83 {

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(1);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        ListNode l6=new ListNode(5);

        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;

        deleteDuplicates(l1);
//        print(l1);
    }
    public static void print(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
    public static  ListNode deleteDuplicates(ListNode head) {
          ListNode pre=head;
          ListNode cur=head;
          if(pre!=null)
          cur=pre.next;

          if(cur==null)
              return head;
          while (cur!=null){
              if (cur.val==pre.val){
                  cur=cur.next;
                  pre.next=cur;

              }
              else{
                  cur=cur.next;
                pre=pre.next;
              }
          }
          return head;
    }
}
