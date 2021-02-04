/**
 * @author fangyi
 * @create 2021-02-04 19:29
 */
//递归学习 --  求n的阶乘
public class digui {
    public static void main(String[] args) {
        System.out.println(jisuan(5));
    }
    public static  long jisuan(int n){
        if(n==1){
            return  1;
        }
        return  n*jisuan(n-1);
    }

}
