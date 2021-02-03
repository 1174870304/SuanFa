import java.util.Arrays;

/**
 * @author fangyi
 * @create 2021-02-02 20:56
 */

/*
        插入排序原理：1，把所有的元素分为两组，已排序的和未排序的。
                    2.找到未排序的组中的第一个元素，向已经排序的组中插去。
                    3.倒叙遍历已经排序的元素，依次和待插入的元素进行比较，直到找到一个元素小于等于待插入元素，那么就把待插入元素放到这个位置，
                       其他的元素向后挪动一位。
                     4.插入排序的时间复杂度为o（n^2）
 */
public class insert_sort {
    //对数组A中的元素进行排序
    public static void  sort(Comparable[] a){
        for(int i=1;i<a.length;i++){
            for (int j=i;j>0;j--){
                //比较索引j处的值和j-1，如果索引j-1处的值比索引j处的值大，则交换数据，如果不是，则找到了合适的位置，退出循环即可。
                if(greater(a[j-1],a[j])){
                    exch(a,j-1,j);
                }else{
                    break;
                }
            }
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
