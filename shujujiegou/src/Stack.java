import java.util.Iterator;

/**
 * @author fangyi
 * @create 2021-02-24 20:29
 */
/*
栈：栈是一种基于先进先出的数据结构，是一种只能在一端进行删除和插入操作的特殊线性表，它按照县进后出的原则存储数据，先进入的数据被压入
    栈底，最后的数据在栈顶，需要读取数据时是从栈顶开始弹出数据。
 */
public class Stack <T> implements  Iterable<T>{
    //结点类
    private class Node{
        public T item;
        public Node next;
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
    //记录首结点
    private  Node head;
    //栈中元素的个数
    private  int N;
    public  Stack(){
        head=new Node(null,null);
        N=0;
    }
    //判断当前栈中元素个数是否为0
    public boolean isEmpty(){
        return N==0;
    }
    //把t元素压入栈
    public void push(T t){
       Node oldNext= head.next;
       Node node=new Node(t,oldNext);
       head.next=node;
       N++;
    }
    //弹出栈顶元素
    public T pop(){
        Node oldNext=head.next;
        if(oldNext==null){
            return  null;
        }
        //删除首个元素
        head.next=head.next.next;
        N--;
        return oldNext.item;
    }
    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    private class SIterator implements Iterator<T>{
        private Node n = head;
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }
        @Override
        public T next() {
            Node node = n.next;
            n = n.next;
            return node.item;
        }
    }
    public static void main(String[] args) throws Exception {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        for (String str : stack) {
            System.out.print(str+" ");
        }
        System.out.println("-----------------------------");
        String result = stack.pop();
        System.out.println("弹出了元素："+result);
    }








}
