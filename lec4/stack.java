package lec4;
import java.util.Stack;
// Stack (тот кто пришел первым, будет обработан в последнюю очередь) в постфиксной записи

//1+2*3 = 7
//123*+
//3  когда приходит знак действия, извлекаются верхние 2 эл-та: 3*2 -> 6 след знак 6+1=7
//2                                                                    1
//1
// public class stack {
//     private static boolean isDigit(String s) throws NumberFormatException {
//         try {
//             Integer.parseInt(s);
//             return true;
//         } catch (NumberFormatException e) {
//             return false;
//         }
//     }

//     public static void main(String[] args) {
//         // (1+2*3*4)*(10/5) - 20
//         // 1 2 3 * 4 * + 10 5 / * 20 -
        
//         //var exp = "20 30 - 10 *".split(" "); // (20-30)*10
//         var exp = "1 2 + 3 *".split(" "); // (1 + 2) * 3
        
//         //var exp = "1 2 3 * +".split(" "); // 1 + 2 * 3
//         int res = 0;
//         System.out.println(exp);
        
//         Stack<Integer> st = new Stack<>();
//         for (int i = 0; i < exp.length; i++) {

//             if (isDigit(exp[i])) {
//                 st.push(Integer.parseInt(exp[i]));
//             } else {
//                 switch (exp[i]) {
//                     case "+":
//                         res = st.pop() + st.pop();
//                         st.push(res);
//                         break;
//                     case "-":
//                         res = -st.pop() + st.pop();
//                         st.push(res);
//                         break;
//                     case "*":
//                         res = st.pop() * st.pop();
//                         st.push(res);
//                         break;
//                     case "/":
//                         res =  st.pop()/ st.pop();
//                         st.push(res);
//                         break;
//                     default:
//                         break;
//                 }
//             }
//         }
//         System.out.printf("%d\n", st.pop());
//     }
// }

public class stack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(123);
        st.push(12);
        System.out.println(st.pop());//12
        System.out.println(st.pop());//123
        System.out.println(st.pop());//1
    }
}