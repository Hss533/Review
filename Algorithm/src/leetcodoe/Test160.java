package leetcodoe;

import leetcodoe.Test;

/**
 * 判断两个链表是否相交
 */
public class Test160 {
    public static void main(String[] args) {
        ListNode l11=new ListNode(1);
        ListNode l12=new ListNode(2);
        l11.next=l12;
        ListNode l13=new ListNode(3);
        ListNode l14=new ListNode(4);
        ListNode l15=new ListNode(5);
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);

        l2.next=l13;

        l12.next=l13;
        l13.next=l14;
        l14.next=l15;
        Test160 t=new Test160();

        System.out.println(t.getIntersectionNode(l1,l1)==null?null:t.getIntersectionNode(l1,l1).val);
    }
    public int length(ListNode A){

        ListNode pre=A;
        int re=0;
        while (pre!=null){
            pre=pre.next;
            re++;
        }
        return re;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA=length(headA);
        int lenB=length(headB);
        ListNode lA=headA;
        ListNode lB=headB;
        int cha=lenA-lenB;
        if(cha>0){
            while (cha>0){
                lA=lA.next;
                cha--;
            }
        }
        if(cha<0){
            cha=-cha;
            while (cha>0){
                lB.next=lB;
                cha--;
            }
        }
        while(lA!=null){
            if(lA==lB){
                return lA;
            }
            lA=lA.next;
            lB=lB.next;
        }
        return null;
    }
}
