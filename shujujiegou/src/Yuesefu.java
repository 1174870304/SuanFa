/**
 * @author fangyi
 * @create 2021-02-24 19:34
 */
/*
约瑟夫问题：41个人坐一圈，第一个人编号为1，第二个人编号为2，第n个人编号为n。
1.编号为1的人开始从1报数，依次向后，报数为3的那个人退出圈；
2.自退出那个人开始的下一个人再次从1开始报数，以此类推；
3.求出最后退出的那个人的编号
 */
public class Yuesefu {
    //结点类
    private static class Node<T> {
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        //1.构建循环链表
        Node<Integer> first=null;//首结点
        Node<Integer> pre=null;//记录前一个结点
        for(int i=1;i<=41;i++){
            //第一个元素
            if(i==1){
                first=new  Node(i,null);
                pre=first;
                continue;
            }

            Node<Integer> node=new Node<>(i,null);
            pre.next=node;
            pre=node;

            //最后一个元素
            if(i==41){
                //构建循环链表，让最后一个结点指向第一个结点
                pre.next=first;

            }
}
        //2.使用count，记录当前的报数值
        int count=0;
        //3.遍历链表，每循环一次，count++
        Node<Integer> n=first;//默认从首结点开始
        Node<Integer> before=null;//记录当前结点的上一个结点
        while (n!=n.next){
            count++;
            //4.判断count的值，如果是3，则从链表中删除这个结点并打印结点的值，把count重置为0
            if(count==3){
                //删除当前结点
                before.next=n.next;
                System.out.print(n.item+",");
                count=0;
                n=n.next;
            }else{
                //如果不是3，让当前结点变为before,当前结点向后移
                before=n;
                n=n.next;
            }
        }
        //打印剩余的最后的那个人
        System.out.println(n.item);

    }



}
