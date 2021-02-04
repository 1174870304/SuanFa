import java.util.Arrays;

/**
 * @author fangyi
 * @create 2021-02-04 19:44
 */
/*
  归并排序原理：

  //归并排序的时间复杂度是 o(nlogn)
 */
public class merge_sort {

    public static void main(String[] args) {
        Integer[] a={4,9,7,5,6,8,11,10};
        sort(a);
        System.out.println(Arrays.toString(a));
    }


    //归并所需要的辅助数组
    private  static Comparable [] assist;

    //数据元素i 和 j交换位置
    private  static  void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    //对a数组中元素进行排序
    public static void  sort(Comparable[] a){
        //1.初始化辅助数组
        assist=new Comparable[a.length];
        //2.定义lo,hi,分别记录数组的最小索引和最大索引。
        int lo=0;
        int hi=a.length-1;
        //3.调用sort重载方法，完成数组a中，从索引lo到索引hi的元素的排序
        sort(a,lo,hi);
    }
    //对数组a中的从lo到hi索引的数排序
    public static void  sort(Comparable[] a,int lo,int hi){
        //安全性校验
        if(lo>=hi){
            return;
        }
        //对lo到hi之间的元素分为两个组
        int mid=lo+(hi-lo)/2;
        //分别对每一组数组进行排序
        sort(a, lo, mid);
        sort(a,mid+1,hi);
        //再把两个组中的数据进行归并
        merge(a,lo,mid,hi);

    }
    //从lo到mid为一个子组，从mid到hi为一个子组，把数组a中的这两个子组的数据合并成一个有序的大组
    public static void  merge(Comparable[] a,int lo,int mid,int hi){
        //定义三个指针
        int i=lo;
        int p1=lo;
        int p2=mid+1;
        //遍历，移动p1和p2指针，比较对应索引的值，找到小的那个，放到辅助数组对应的索引处
        while (p1<=mid&&p2<=hi){
            //比较对应索引处的值
            if(less(a[p1],a[p2])){
                assist[i++]=a[p1++];
            }else{
                assist[i++]=a[p2++];
            }
        }
        //遍历，如果p1的指针没有走完，则顺序移动指针p1，把对应的元素放到辅助数组的对应索引处。
        while (p1<=mid){
            assist[i++]=a[p1++];
        }
        //遍历，如果p2的指针没有走完，则顺序移动指针p1，把对应的元素放到辅助数组的对应索引处。
        while (p2<=hi){
            assist[i++]=a[p2++];
        }
        //把辅助数组的元素拷贝到原数组中。
        for (int index=lo;index<=hi;index++){
            a[index]=assist[index];
        }
    }

    //
    public static boolean less(Comparable v ,Comparable w){
        return v.compareTo(w)<0;

    }

}
