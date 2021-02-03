import java.util.Arrays;

/**
 * @author fangyi
 * @create 2021-02-01 20:11
 */
/*
    选择排序原理：1.每次遍历过程中，都假定第一个索引处的元素是最小值，和其他索引处依次比较。如果当前索引处的值大于某个其他处索引的值，
       则假定某个其他处索引的值为最小值，最后可以找到最小值所在索引。
               2.交换第一个索引处和最小值所在索引处的值
               3.选择排序法的时间复杂度 o(n^2)

 */
public class select_sort {
    //对数组A中的元素进行排序
    public static void  sort(Comparable[] a){
        for(int i= 0;i<=a.length-2;i++){
            //定义一个变量，记录最小元素所在的索引，默认为参与排序的第一个元素所在的位置
            int minindex=i;
            for(int j=i+1;j<a.length;j++){
                //需要比较最小索引处的值和j处所在索引的值
                if(greater(a[minindex],a[j])){
                    minindex=j;
                }
            }
            //交换最小索引minindex处的值和索引i处的值
            exch(a,i,minindex);
        }
    }

    //比较v元素是否大于w元素
    private static boolean  greater(Comparable v ,Comparable w){
        return v.compareTo(w)>0;
    }

    //数据元素i 和 j交换位置
    private  static  void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void main(String[] args) {
        Integer[] a={4,9,7,5,6,8,11,10};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
