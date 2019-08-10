package per.offerShuJu;

import java.util.ArrayList;
import java.util.Stack;

public class LinkListClass {
    public ListNode ReverseList(ListNode head)
    {
        Stack list=returnStack(head);
        ListNode listNode=creatListNodeFromStack(list);
        return listNode;

    }
    public ArrayList<Integer> returnArrayList(ListNode listNode)
    {
        ArrayList<Integer> arrayList=new ArrayList<>();
        while(true)
        {
            if(listNode==null)
                break;
            arrayList.add(listNode.val);
            listNode=listNode.next;
        }
        return  arrayList;
    }
    public Stack<Integer> returnStack(ListNode listNode)
    {
        Stack<Integer> arrayList=new Stack<>();
        while(true)
        {
            if(listNode==null)
                break;
            arrayList.push(listNode.val);
            listNode=listNode.next;
        }
        return  arrayList;
    }
    public ListNode  creatListNodeFromArrayList(ArrayList<Integer> arrayList)
    {
        ListNode listNode=new ListNode(0);
        ListNode p,r;
        p=listNode;
        r=listNode;
        for(int i=0;i<arrayList.size();i++)
        {
            p=new ListNode(arrayList.get(i));
            r.next=p;
            r=p;
        }
        r.next=null;
        listNode=listNode.next;
        return listNode;
    }
    public ListNode  creatListNodeFromStack(Stack<Integer> stack)
    {
        ListNode listNode=new ListNode(0);
        ListNode p,r;
        r=listNode;
        while (!stack.empty())
        {
            p=new ListNode(stack.pop());
            r.next=p;
            r=p;
        }
        r.next=null;
        listNode=listNode.next;
        return listNode;
    }

    public static void main(String[] args) {

        ArrayList<Integer> a=new ArrayList<>();

        ListNode listNode=new LinkListClass().creatListNodeFromArrayList(a);
        System.out.println(new LinkListClass().returnArrayList(listNode));

        ListNode listNode1=new LinkListClass().ReverseList(listNode);
        System.out.println(listNode1);
    }

}
