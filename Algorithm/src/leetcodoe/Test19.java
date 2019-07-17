package leetcodoe;

/**
 * 删除链表的倒数第N个节点
 */
public class Test19 {
    public static void main(String[] args) {

        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        ListNode l6=new ListNode(6);

        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;

        Test19 test19=new Test19();
        ListNode re=test19.removeNthFromEnd(l1,5);
        test19.print(re);

    }
    public void print(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

       ListNode temp=head;
       while (n>0)
       {
           temp=temp.next;
           n--;
       }
        if(temp==null){
            return head.next;
        }
       ListNode newnode=head;
       while (temp!=null){
           newnode=newnode.next;
           temp=temp.next;
       }

       //newnode是倒数第k个节点
        ListNode prenew=head;
        ListNode nextnew=prenew.next;
        while (nextnew!=null){
            if(nextnew==newnode){
                break;
            }
            nextnew=nextnew.next;
            prenew=prenew.next;

        }
        if(nextnew.next!=null){
            nextnew=nextnew.next;
            prenew.next=nextnew;
        }
        else {
            prenew.next=null;
        }
       return head;
    }

    //先要找到链表的倒数第n个节点
}
