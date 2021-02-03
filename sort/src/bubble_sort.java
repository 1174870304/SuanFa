import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author fangyi
 * @create 2021-02-01 19:10
 */
/*冒泡排序原理：1.比较相邻的元素，如果前一个元素比后一个元素大，则交换这两个元素的位置。
/            2.对每一对相邻的元素都做相同的动作，从开始第一对到结尾最后一对元素，最终最后位置的元素就是最大值。
            3.冒泡排序法的时间复杂度 o(n^2)
 */
public class bubble_sort {
    //对数组A中的元素进行排序
    public static void  sort(Comparable[] a){
        for (int i=a.length-1;i>0;i--){
            for (int j=0;j<i;j++){
                //比较索引j和j+1的值
                if(greater(a[j],a[j+1])){
                    exch(a,j,j+1);
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
        Integer[] a={4,9,7,5,6};
        sort(a);
        System.out.println(Arrays.toString(a));
    }


}
