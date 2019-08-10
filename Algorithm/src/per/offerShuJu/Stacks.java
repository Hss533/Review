package per.offerShuJu;

import java.util.Stack;

public class Stacks {
    public boolean IsPopOrder(int [] pushA,int [] popA)
    {
        Stack<Integer> A=new Stack<>();
        Stack<Integer> B=new Stack<>();
        for (int i=pushA.length-1;i>=0;i--)
        {
            A.push(pushA[i]);
        }
        //A 底5 4 3 2 1顶
        int temp=A.pop();
        B.push(temp);//A底 5 4 3 2 顶 |B 1
        int i=0;
        while (true)
        {
           /* if(B.empty()&&A.empty()&&i==popA.length-1)
            {
                return true;
            }
            if(A.empty()&&!B.empty()&&B.peek()!=popA[i])
            {
                return false;
            }

            if(!B.empty()||(B.peek()!=popA[i]&&!A.empty()))
            {
                B.push(A.pop());
                continue;
            }
            if(B.peek()==popA[i]&&!B.empty())
            {
                B.pop();
                i++;
                continue;
            }*/

            if(B.empty())//填入
            {
                if(A.empty())
                {
                    return true;
                }
                if (!A.empty())
                {
                    B.push(A.pop());
                }
            }
            if(!B.empty())
            {
                //进行比较
                if(B.peek()==popA[i])
                {
                    B.pop();
                    i++;
                }
                else
                    {//填入
                         if(A.empty())
                    {
                            return false;
                    }
                    else {
                        B.push(A.pop());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        /*int[] pushA=new int[]{1,2,3,4,5};
        int[] popA=new int[]{4,3,5,1,2};
        System.out.println(new Stacks().IsPopOrder(pushA,popA));
        */
        Zhu zhu = new Zhu("hushasha");
        System.out.println(zhu.toString());
    }

    static class Zhu
    {
        String name;
        Boolean jundge;

        public Zhu(String name)
        {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boolean getJundge() {
            return jundge;
        }

        public void setJundge(Boolean jundge) {
            this.jundge = jundge;
        }

        @Override
        public String toString() {
            return "Zhu{" +
                    "name='" + name + '\'' +
                    ", jundge=" + jundge +
                    '}';
        }
    }
}
