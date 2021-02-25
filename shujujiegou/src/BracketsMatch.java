/**
 * @author fangyi
 * @create 2021-02-25 19:46
 */
/*
栈解决-括号匹配问题：给定一个字符串，里边可能包含"()"小括号和其他字符，请编写程序检查该字符串的中的小括号是否成对出现。
 */
public class BracketsMatch {
    public static void main(String[] args) {
        String str = "(上海(长安)())(";
        boolean match = isMatch(str);
        System.out.println(str+"中的括号是否匹配："+match);
    }
    /**
     * 判断str中的括号是否匹配
     * @param str 括号组成的字符串
     * @return 如果匹配，返回true，如果不匹配，返回false
     */
    public static boolean isMatch(String str){
        //1.创建栈对象，用来存储左括号
        Stack<String> chars=new Stack<>();
        //2.从左到右遍历字符串
        for (int i = 0; i < str.length(); i++) {
            String currChar=str.charAt(i)+"";
            //3.判断当前字符串是否为左括号，如果是，则把字符串放入到栈中
            if(currChar.equals("(")){
                chars.push(currChar);
            }else if(currChar.equals(")")){
                //继续判断当前字符串是否为右括号，如果是，则从栈中弹出一个左括号，并判断弹出的结果是否为空，如果为null则证明没有匹配的左括号
                String pop=chars.pop();
                if(pop==null){
                    return  false;
                }
            }
        }
        if (chars.size()==0){
            return  true;
        }else{
            return  false;
        }
    }
}

