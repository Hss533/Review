package per.offerShuJu;


import java.util.ArrayList;

public class AddListNode {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode(0);
        ListNode i, j, p, r;
        r = newList;
        i = list1;
        j = list2;
        while (true) {
            if (i == null && j == null)
                break;
            //向链表中加入新的数据
            if (i == null) {
                p = new ListNode(j.val);
                r.next = p;
                r = p;
                j = j.next;
                continue;
            } else if (j == null) {
                p = new ListNode(i.val);
                r.next = p;
                r = p;
                i = i.next;
                continue;
            } else {
                if (i.val <= j.val) {
                    p = new ListNode(i.val);
                    r.next = p;
                    r = p;
                    i = i.next;
                    continue;
                }
                if (i.val > j.val) {
                    p = new ListNode(j.val);
                    r.next = p;
                    r = p;
                    j = j.next;
                    continue;
                }
            }
        }
        r.next = null;
        newList = newList.next;
        return newList;
    }

    public ListNode creatListNodeFromEnd(ArrayList<Integer> arrayList) {

        ListNode newListNode = new ListNode(0);
        ListNode p, r;
        r = newListNode;
        for (int i = 0; i < arrayList.size(); i++) {
            p = new ListNode(arrayList.get(i));
            r.next = p;
            r = p;
        }
        r.next = null;
        newListNode = newListNode.next;
        return newListNode;
    }

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();

       /* arrayList.add(1);
        arrayList.add(3);
        arrayList.add(5);*/

       /* arrayList2.add(2);
        arrayList2.add(4);
        arrayList2.add(6);*/

        ListNode list1 = new AddListNode().creatListNodeFromEnd(arrayList);
        ListNode list2 = new AddListNode().creatListNodeFromEnd(arrayList2);
        ListNode newList = new AddListNode().Merge(list1, list2);
        System.out.println(newList);
    }
}
