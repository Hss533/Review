package per.offerShuJu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeleteDuplicationClass {
    public ArrayList<Integer> returnArrayList(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(listNode.val - 1);
        while (true) {
            if (listNode == null)
                break;
            arrayList.add(listNode.val);
            listNode = listNode.next;
        }
        return arrayList;
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)//没有节点或者只有一个节点
        {
            return pHead;
        }
        ListNode newList = new ListNode(pHead.val - 1);

        ListNode start = pHead;
        ListNode temp = pHead.next;

        ListNode p;
        ListNode r = newList;
        while (true) {

            if (temp == null && start != null && start.next == temp) {

                p = new ListNode(start.val);
                r.next = p;
                r = p;
            }
            if (temp == null) {
                break;
            }
            if (start.val == temp.val) {

                temp = temp.next;
                continue;
            }
            if (start.val != temp.val) {
                if (start.next == temp) {
                    p = new ListNode(start.val);
                    r.next = p;
                    r = p;
                    start = temp;
                    temp = temp.next;


                }
                if (start.next != temp) {
                    //没挨
                    start = temp;
                    temp = temp.next;
                }
                continue;
            }
        }
        r.next = null;
        newList = newList.next;
        return newList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        System.out.println(arrayList);
        ListNode listNode = new LinkListClass().creatListNodeFromArrayList(arrayList);
        ListNode listNodeno = new DeleteDuplicationClass().deleteDuplication(listNode);
        System.out.println(listNodeno);

    }
}
