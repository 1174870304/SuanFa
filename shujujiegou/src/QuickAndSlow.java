/**
 * @author fangyi
 * @create 2021-02-23 20:28
 */
/*
 快慢指针在链表中的应用场景 1.中间值问题（无环）
                        2.单向链表是否有环及环的入口
 */
public class QuickAndSlow {
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
    public static void main(String[] args) throws Exception {
        Node<String> first = new Node<String>("aa", null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> fourth = new Node<String>("dd", null);
        Node<String> fifth = new Node<String>("ee", null);
        Node<String> six = new Node<String>("ff", null);
        Node<String> seven = new Node<String>("gg", null);
      //完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;
        //产生环
        seven.next=third;
        //查找中间值
        // String mid = getMid(first);
        // System.out.println("中间值为："+mid);
        System.out.println(isCircle(first));
        System.out.println(getEntrance(first).item);
       }
    //查找中间值
    public static String getMid(Node first){
        Node<String> fast=first;//快指针
        Node<String> slow=first;//慢指针
        while (fast!=null&&fast.next!=null){
           fast= fast.next.next;
           slow=slow.next;
        }
        return  slow.item;
    }
    //判断链表是否有环
    public static boolean isCircle(Node<String> first){
        Node<String> fast=first;//快指针
        Node<String> slow=first;//慢指针
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast.equals(slow)){
                return  true;
            }
        }
        return false;
    }
    //获取环的入口
    public static Node getEntrance(Node<String> first){
        Node<String> fast=first;//快指针
        Node<String> slow=first;//慢指针
        Node<String> temp=null;//临时指针
        while (fast!=null &&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast.equals(slow)){
                temp=first;
                continue;
            }
            if (temp != null) {
                temp=temp.next;
                if (temp.equals(slow)){
                    return temp;
                }
            }

        }
        return  null;
    }






}
