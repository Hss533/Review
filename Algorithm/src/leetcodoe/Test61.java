package leetcodoe;

public class Test61 {
    public static void main(String[] args) {
        System.out.println(1%0);
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
        Test61 test61=new Test61();
        ListNode re=test61.rotateRight(l1,7);
        test61.print(re);
    }
    public  void print(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {

        int len=lenght(head);
        ListNode start=head;
        ListNode pre=head;
        int temp;
        if(len==0||k==0||k%len==0){
            return head;
        }
        if(k<len){
            temp=len-k+1;
        }
        else {
            temp=len-k%len+1;
        }
        while (temp-1>0){
            temp--;
            start=start.next;
            if(temp-2==0){
                pre=start;
            }
        }
        pre.next=null;
       // print(head);
        ListNode newnode=start;
        while (newnode.next!=null){
            newnode=newnode.next;
        }
        newnode.next=head;
        return start;
    }
    public int lenght(ListNode head){
        ListNode p=head;
        int len=0;
        while (p!=null){
            p=p.next;
            len++;
        }
        return len;
    }
}
