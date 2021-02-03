import java.util.Arrays;

/**
 * @author fangyi
 * @create 2021-02-03 19:53
 */
/*
    希尔排序原理 1.选一个增长量h,按照增长量h作为分组的依据，对数据进行分组。
                2.对分好组的每组数据做插入排序
                3.减少增长量，最小减为1，重复第二步操作。
 */

public class shell_sort {
    //对数组A中的元素进行排序
    public static void  sort(Comparable[] a){
        //1.根据数组的长度，定好增长量初始值h
         int h=1;
         while (h<a.length/2){
             h=h*2+1;
         }
        //2.希尔排序
        while (h>=1){
            //排序
            //2.1找到待插入元素
            for(int i=h;i<a.length;i++){
                //2.2把待插入元素插入到有序数列中
                for(int j=i;j>=h;j-=h){
                    //待插入的元素是a[j],比较a[j]和a[j-h]
                    if(greater(a[j-h],a[j])){
                        exch(a,j-h,j);
                    }else{
                        break;
                    }
                }
            }
            h/=2;
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
