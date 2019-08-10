package leetcodoe;

import java.util.ArrayList;
import java.util.List;

/**

 给出两个 非空 的链表用来表示两个非负的整数。

 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 */
//如果是倒叙的话  可以放入栈中
public class Test2 {
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dum=new ListNode(0);
        ListNode listNode1=l1;
        ListNode listNode2=l2;
        ListNode current=dum;
        int carry=0;
        while (listNode1!=null||listNode2!=null){
            int x=(listNode1!=null)?listNode1.val:0;
            int y=(listNode2!=null)?listNode2.val:0;
            int sum=carry+x+y;

            carry=sum/10;
            current.next=new ListNode(sum%10);
            current=current.next;
            if(listNode1!=null)listNode1=listNode1.next;
            if(listNode2!=null)listNode2=listNode2.next;

        }
        if(carry>0){
            current.next=new ListNode(carry);
        }

        return dum.next;
    }
}
