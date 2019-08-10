package per.offerShuJu;

import java.util.Random;
import java.util.Stack;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class FindKthToTailClass {

    /**
     * 链表找出倒数第K个值
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k)
    {
        if (head==null)
            return null;
        Stack<Integer> stack=new Stack<>();
        ListNode p;
        p=head;
        for(;;)
        {
            stack.push(head.val);
            if(p.next==null)
            {
                break;
            }
            p=p.next;
        }
        int size=stack.size();
        if(k>size)
            return null;
        int i=0;
        while(true)
        {
            i++;
           if(size-i+1==k)
               break;
           head=head.next;

        }
        return head;

    }

    public ListNode Merge(ListNode list1,ListNode list2)
    {
            ListNode p1=list1;
            ListNode p2=list2;
            ListNode newnode=p1.val<=p2.val?p1:p2;
            int a=0;
            if(p1.val>p2.val)
            {
                a=1;
            }
            if(a==0)//newnode shi从p1开始的
            {
                ListNode p=list1;
                ListNode q=list2;
                for(;;)
                {
                    if (q.val >= p.val)
                    {

                    }

                }

            }
            return newnode;
    }

    /**
     * 头插法
     * @return
     */
    public ListNode creatListNode()
    {
        ListNode listNode=new ListNode(0);
        ListNode p;
        for(int i=0;i<10;i++)
        {
            p=new ListNode(i);
            p.next=listNode.next;
            listNode.next=p;
        }
        return listNode;
    }

    /**
     * 尾插法
     * @return
     */
    public ListNode creatListNodeFromEnd()
    {
        ListNode listNode=new ListNode(0);
        ListNode p,r=listNode;
        Random random=new Random();
        for(int i=1;i<6;i++)
        {
            int number=random.nextInt(100);
            p=new ListNode(i);
            r.next=p;
            r=p;
        }
        r.next=null;
        return listNode;
    }
    public ListNode addListNode(ListNode head,int a)
    {
        ListNode p=head;
        int  flag=0;
        for(int i=0;;i++)
        {
            //寻找要插入的结点
            if(a>=p.val&&a<=p.next.val)
            {
                ListNode newlist=new ListNode(a);
                ListNode t=p;
                newlist.next=t.next;
                p.next=newlist;
                flag=1;
                break;
            }
            p=p.next;
            //如果结点在最后
            if(p.next==null&&flag==0)
            {

                p.next=new ListNode(a);
                break;
            }
            if(p.next==null)
            {
                break;
            }
        }
        return head;
    }
    public ListNode delListNode(ListNode listNode,int a)
    {
        ListNode p,r;
        p=listNode;
        r=p.next;
        for (;;) {

            if (p.val == a) {
                p=r;
                listNode=r;
                r=r.next;
            }
            p=p.next;
            r=r.next;
        }
    }

    public static void main(String[] args) {

/*
        ListNode listNode=new FindKthToTailClass().creatListNodeFromEnd();
        ListNode insert=new FindKthToTailClass().addListNode(listNode,3);
        System.out.println("结束程序");*/
    }
}
