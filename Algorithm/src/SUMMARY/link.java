package SUMMARY;

import java.util.Stack;
//翻转链表  翻转链表（两个一翻转）
//判断两个链表是否相交
//判断链表中是否有环  有环的话求出环的长度  找出环的入口节点
//奇数位升序  偶数位降序  合并成有序数组
/**
 * 链表相关经典算法
 */
//TODO 复杂链表的复制

class ListNode {

    public int val;
    public  ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }

}
public class link {
    public static void main(String[] args) {

    }
    //翻转链表
    public ListNode fanzhuan(ListNode pHead) {
        ListNode currentNode = pHead;
        ListNode preNode = currentNode.next;
        ListNode returnLink = null;
        while (currentNode != null) {
            currentNode.next = returnLink;
            returnLink = currentNode;
            currentNode = preNode;
            if (preNode != null)
                preNode = preNode.next;
        }
        return returnLink;
    }
    //判断两个链表是否相交
    /**先判断两个链表的长度，然后长的先走，等到长度一样长了
     * 再一起走，最后看一下两个的节点有没有相同的，如果有就说明相交
     * 了*/
    public ListNode getFirstHe(ListNode a, ListNode b) {
        int la = getLength(a);
        int lb = getLength(b);
        ListNode nodea = a;
        ListNode nodeb = b;
        if (la == lb) {

        } else if (la > lb) {
            int cha = la - lb;
            while (cha != 0) {
                nodea = nodea.next;
                cha--;
            }
        } else {
            int cha = lb - la;
            while (cha != 0) {
                nodeb = nodeb.next;
                cha--;
            }
        }
        while (nodea != null && nodeb != null) {
            nodea = nodea.next;
            nodeb = nodeb.next;
            if (nodea == nodeb) {
                return nodea;
            }
        }
        return null;
    }
    //辅助函数，输出链表的长度
    public int getLength(ListNode a) {
        ListNode phead = a;
        int count = 0;
        while (phead != null) {
            count++;
            phead = phead.next;
        }
        return count;
    }

    /**
     * 取出链表中倒数第K个结点
     *
     * @param a
     * @return
     */
    public ListNode getK(ListNode a, int k) {
        ListNode l1 = a;
        ListNode l2 = a;
        while ((k - 1) != 0) {
            l1 = l1.next;
            k--;
        }
        while (a != null) {
            if (l1.next == null) {
                return l2;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }
    //判断链表中是否有环
    /**快慢指针**/
    public boolean circleTest(ListNode listNode) {
        if (listNode == null)
            return false;
        ListNode q = listNode;
        ListNode s = listNode;
        while (q.next != null) {
            q = q.next.next;
            s = s.next;
            if (q == s)
                return true;
        }
        return false;
    }
    //获取链表环的长度
    /**如果已经有环了，就在走一圈，走到原来的位置就是一圈的长度了**/
    public int getCircleLength(ListNode listNode) {
        if (listNode == null)
            return 0;
        ListNode q = listNode;
        ListNode s = listNode;
        while (q.next != null) {
            q = q.next.next;
            s = s.next;
            if (q == s) {
                break;
            }
        }
        ListNode listNode1 = q.next;
        int v = 0;
        while (true) {
            v++;
            listNode1 = listNode1.next;
            if (listNode1 == q)
                break;
        }
        return v;
    }
    /**
     * 获取链表的入口结点
     * @param listNode
     * @return
     */
    public ListNode getenter(ListNode listNode)
    {
        ListNode quick=listNode;
        ListNode slow=listNode;
        while (quick!=null)
        {
            quick=quick.next.next;
            slow=slow.next;
            if(quick==slow)
            {
                System.out.println("成环");
                break;
            }
        }
        System.out.println(slow.val);
        slow=listNode;
        while (true)
        {
            slow=slow.next;
            quick=quick.next;
            if(slow==quick)
                break;
        }
        System.out.println(slow.val);
        return null;
    }
    /**
     * 两个一反转
     * 1 2 3 4 -->2 1 4 3
     * 1 2 3 4 5--> 2 1 4 3 5
     *
     * @param listNode
     * @return http://url.cn/5lFMKEq
     */
    public ListNode fanzhuan2(ListNode listNode) {
        ListNode phead = listNode.next;
        ListNode nextNode = new ListNode(0);
        ListNode currentNode = listNode;
        ListNode preNode = currentNode.next;
        while (true) {
            currentNode.next = preNode.next;
            preNode.next = currentNode;

            ListNode newList = nextNode;
            newList.next = preNode;
            nextNode = currentNode;


            currentNode = currentNode.next;
            if (currentNode.next == null)
                break;
            preNode = currentNode.next;

        }
        return phead;
    }



    /**
     * 奇数位升序
     * 偶数位降序
     * 合并成升序序列
     *
     * @param a
     * @return
     */
    public static ListNode test(ListNode a) {

        ListNode phead = a;
        ListNode j = new ListNode(0);
        ListNode o = new ListNode(0);
        ListNode l1 = j;
        ListNode l2 = o;
        int count = 0;
        while (phead != null) {
            count++;
            ListNode listNode = new ListNode(phead.val);
            if (count % 2 == 0) {
                l2.next = listNode;
                l2 = l2.next;
            } else {
                l1.next = listNode;
                l1 = l1.next;
            }
            phead = phead.next;
        }

        printLink(j.next);
        System.out.println();
        printLink(o.next);
        System.out.println();
        ListNode listNode = returnList(o.next);
        printLink(listNode);
        //得到奇偶两个序列

        //合并就好了
        ListNode result = new ListNode(0);
        ListNode lr = result;
        ListNode ll = listNode;
        ListNode lj = j.next;
        while (ll != null && lj != null) {
            if (ll.val > lj.val) {
                ListNode node = new ListNode(lj.val);
                lr.next = node;
                lr = lr.next;
                lj = lj.next;

            } else {
                ListNode node = new ListNode(ll.val);
                lr.next = node;
                lr = lr.next;
                ll = ll.next;

            }
        }
        while (lj != null) {
            ListNode node = new ListNode(lj.val);
            lr.next = node;
            lr = lr.next;
            lj = lj.next;
        }
        while (ll != null) {
            ListNode node = new ListNode(ll.val);
            lr.next = node;
            lr = lr.next;
            ll = ll.next;
        }

        System.out.println();
        printLink(result.next);
        return null;
    }

    public static  ListNode returnList(ListNode a) {
        Stack<Integer> stack = new Stack<>();
        ListNode phead = a;
        while (phead != null) {
            stack.push(phead.val);
            phead = phead.next;

        }
        ListNode b = new ListNode(0);
        ListNode result = b;
        while (!stack.isEmpty()) {
            ListNode newnode = new ListNode(stack.pop());
            b.next = newnode;
            b = b.next;
        }
        return result.next;
    }
    //打印链表
    public static void printLink(ListNode node) {
        ListNode newnode = node;
        while (newnode != null) {
            System.out.print(newnode.val + " ");
            newnode = newnode.next;
        }
    }
    //创建链表
    public ListNode createLink(int[] a) {
        ListNode phead = new ListNode(a[0]);
        ListNode node = phead;
        for (int i = 1; i < a.length; i++) {
            ListNode newnode = new ListNode(a[i]);
            node.next = newnode;
            node = newnode;
        }
        return phead;
    }
}
