import java.util.Iterator;

/**
 * @author fangyi
 * @create 2021-02-22 20:36
 */
/*
 双向链表：由多个结点组成，每个结点都由一个数据域和两个指针域组成，数据域用来存储数据，其中的一个指针域用来指向其后继结点，其中一个指针域用来
      指向其前驱结点。链表的头节点的数据域不存储数据，指向前驱结点的指针域为null，指向后继结点的指针域指向第一个真正存储数据的结点。
 */
public class TwoWayLinkList<T>  implements  Iterable<T>{
    @Override
    public Iterator<T> iterator() {
        return  new TIterator();
    }

    private class  TIterator implements  Iterator{
        private  Node n=head;
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.item;
        }
    }

    //结点类
    private  class  Node{
        //存储数据
        public T item;
        //指向上一个结点
        public Node pre;
        //指向下一个结点
        public Node next;
       public  Node(T item,Node pre,Node next){
           this.item=item;
           this.pre=pre;
           this.next=next;
       }
    }

    //首结点
    private Node head;
    //最后一个节点
    private  Node last;
    //链表长度
    private  int N;

    public  TwoWayLinkList(){
        last=null;
        head=new Node(null,null,null);
        N=0;
    }
    //清空链表
    public void clear(){
        last=null;
        head.next=last;
        head.pre=null;
        head.item=null;
        N=0;
    }
    //获取链表长度
    public int length(){
        return  N;
    }
    //判断链表是否为空
    public boolean isEmpty(){
        return N==0;
    }
    //插入元素t
    public void insert(T t){
        if(last==null){
            last=new Node(t,head,null);
            head.next=last;
        }else {
            Node oldLast=last;
            Node node=new Node(t,oldLast,null);
            oldLast.next=node;
            last=node;
        }
        //长度+1
        N++;
    }
    //向指定位置i处插入元素t
    public void insert(int i,T t){
        if(i<0||i>=N){
            throw  new RuntimeException("位置不合法");
        }
        //找到位置i的前面一个结点
        Node pre=head;
        for (int index=0;index<i;index++){
            pre=pre.next;
        }
        //当前结点
        Node curr=pre.next;
        //构建新结点
        Node newNode=new Node(t,pre,curr);
        curr.pre=newNode;
        pre.next=newNode;
        //长度加1
        N++;
    }
    //获取指定位置i处的元素
    public T get(int i){
        if(i<0||i>=N){
            throw  new RuntimeException("位置不合法");
        }
        //寻找当前结点
        Node curr=head.next;
        for(int index=0;index<i;index++){
            curr=curr.next;
        }
        return  curr.item;
    }
    //找到元素t在链表中第一次出现的位置
    public int indexOf(T t){
        Node n =head;
        for (int i=0;n.next!=null;i++){
            n=n.next;
            if (n.next.equals(t)){
                return  i;
            }
        }
        return  -1;
    }
    //删除位置i处的元素，并返回该元素
    public T remove(int i){
        if(i<0||i>=N){
            throw  new RuntimeException("位置不合法");
        }
        //寻找i位置的前一个元素
        Node pre=head;
        for (int index=0;index<i;index++){
            pre=pre.next;
        }
        //i位置的元素
        Node curr=pre.next;
        //i位置的下一个元素
        Node curr_next=curr.next;

        pre.next=curr_next;
        curr_next.pre=pre;
        //长度-1
        N--;
        return curr.item;
    }
    //获取第一个元素
    public T getFirst(){
        if (isEmpty()){
            return null;
        }
        return  head.next.item;
    }
    //获取最后一个元素
    public T getLast(){
        if (isEmpty()){
            return  null;
        }
        return  last.item;
    }

    public static void main(String[] args) throws Exception {
        TwoWayLinkList<String> list = new TwoWayLinkList<>();
        list.insert("乔峰");
        list.insert("虚竹");
        list.insert("段誉");
        list.insert(1,"鸠摩智");
        list.insert(3,"叶二娘");
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("----------------------");
        String tow = list.get(2);
        System.out.println(tow);
        System.out.println("-------------------------");
        String remove = list.remove(3);
        System.out.println(remove);
        System.out.println(list.length());
        System.out.println("--------------------");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }
}

