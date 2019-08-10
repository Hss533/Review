package per.offerShuJu;

public class EnTryNodeOdLoopClass {
    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead == null)
            return null;
        if (pHead.next == null)
            return null;
        if (pHead.next.next == null)
            return null;
        int flag;
        ListNode r, p;
        p = pHead;
        r = pHead;
        while (true) {
            if (r.next == null)
                return null;
            p = p.next;
            r = r.next.next;
            if (p == r) {
                flag = 1;
                break;
            }
        }
        if (pHead == p)
            return pHead;
        r = pHead;
        while (true) {
            if (flag == 1) {
                //表示已经成环了
                r = r.next;
                p = p.next;
                if (r == p) {
                    return r;
                }
            }
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = e;
        e.next = a;
        /*b.next=c;
        c.next=d;
        d.next=e;*/
        ListNode re = new EnTryNodeOdLoopClass().EntryNodeOfLoop(a);
        System.out.println(a);

    }
}
