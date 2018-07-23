package Stack;

import java.util.Stack;

//将十二个月份放入栈中，然后再将其取出
public class Subject1 {
    private static String[] months = {"January","February","March","April","MAY","June","July","August","September ","October","November","December"};
    public static void main(String[] a){
        Stack stack = new Stack();
        for(String month:months){
            stack.push(month);
        }
        //栈弹出遍历方式
        //while (s.peek()!=null) {     //不健壮的判断方式，如果栈为空的话，则要抛出异常，正确写法是下面的
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}
