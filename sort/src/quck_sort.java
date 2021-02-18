import java.util.Arrays;

/**
 * @author fangyi
 * @create 2021-02-18 20:02
 */
/*
   快速排序原理 1.首先设定一个分界值，通过该分界值将数组分为左右两部分。
             2.将大于或者等于分界值的数据放到数组右边，小于分界值的数据放到数组的左边，此时左边部分中各元素都小于或等于分界值
                ，而右边部分中各元素都大于或等于分界值
             3.然后，左边和右边的数据可以独立排序。对于左侧数组的数据，又可以取一个分界值，将该部分数据分成左右两部分，同2.
             4.重复上述过程，可以看出，这是一个递归定义，通过递归将左侧部分排好序后，再递归排好右侧部分的顺序。
                当左侧和右侧两个部分的数据排完序后，整个数组的排序也就完成了。
 */

public class quck_sort {
    public static void main(String[] args) {
        Integer[] a={4,9,7,5,6,8,11,10};
        sort(a);
        System.out.println(Arrays.toString(a));
    }



    //比较v元素是否小于w元素
    private  static boolean less(Comparable v,Comparable w){
        return  v.compareTo(w)<0;
    }

    //数组元素i和j交换位置
    private  static  void  exch(Comparable [] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    //对数组内的元素进行排序
    public  static  void sort(Comparable[] a){
        int lo=0;
        int hi=a.length-1;
        sort(a,lo,hi);
    }

    //对数组a中从索引lo到索引hi之间的元素进行排序
    private static  void  sort(Comparable [] a,int lo,int hi){
        //安全性校验
        if(hi<=lo){
            return;
        }
        //需要对数组中lo索引到hi索引的元素进行分组（左子组和右子组）
        int partition=partition(a,lo,hi);//返回的是分组的分界值所在的索引，分界值位置变换后的索引

        //让左子组有序
        sort(a,lo,partition-1);

        //让右子组有序
        sort(a,partition+1,hi);


    }

    //对数组a中从索引lo到索引hi之间的元素进行分组，并返回分组界限对应的索引
    /*
    切分原理，把一个数组切分为两个子数组的基本思想：1.找一个基准值，用两个指针分别指向数组的头部和尾部
                                       2.先从尾部从头部开始搜索一个比基准值小的元素，搜索到即停止，并记录指针的位置。
                                       3.再从头部向尾部开始搜索一个比基准值大的元素，搜索到即停止，并记录指针的位置。
                                       4.交换当前左边指针位置和右边指针位置的元素；
                                       5.重复2，3，4步骤，直到左边指针的值大于右边指针的值停止
     */
    public static  int partition(Comparable [] a,int lo,int hi){
       //确定分界值
        Comparable key=a[lo];
        //定义两个指针，分别指向待切分元素的最小索引处和最大索引处的下一个位置
        int left=lo;
        int right=hi+1;
        //切分
        while(true){
            //先从右往左扫描，移动right指针，找到一个比分界值小的元素，停止。
            while(less(key,a[--right])){
                if(right==lo){
                    break;
                }
            }
            //再从左往右扫描，移动left指针，找到一个比分界值大的元素，停止。
            while(less(a[++left],key)){
                if(left==hi){
                    break;
                }
            }
            //判断left>=right,如果是，则证明元素扫描完毕，结束循环，如果不是，则交换元素即可。
            if(left>=right){
                break;
            }else{
                exch(a,left,right);
            }
        }
       //交换分界值
        exch(a,lo,right);

        return  right;
    }





}
