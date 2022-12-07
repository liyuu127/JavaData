package nowcoder.hw;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author liyu
 * date 2022/12/7 14:19
 * description 表达式求值
 */
public class HJ54 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //将其他括号，替换成小括号
        s = s.replace("{", "(");
        s = s.replace("[", "(");
        s = s.replace("}", ")");
        s = s.replace("]", ")");
        System.out.println(handle(s));
    }

    public static int handle(String s) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, n = s.length();
        char sign = '+';
        int d = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                sign = s.charAt(i);
                i++;
                continue;
            } else if (s.charAt(i) == '(') {
                int count = 1;
                int j = i + 1;
                while (j < n && count > 0) {
                    if (s.charAt(j) == ')') {
                        count--;
                    } else if (s.charAt(j) == '(') {
                        count++;
                    }
                    j++;
                }
                d = handle(s.substring(i + 1, j - 1));
                i = j;
            } else if (Character.isDigit(s.charAt(i))) {
                while (i < n && Character.isDigit(s.charAt(i))) {
                    d = d * 10 + s.charAt(i) - '0';
                    i++;
                }
            }

            if (sign == '+') {
                stack.push(d);
            } else if (sign == '-') {
                stack.push(-1 * d);
            } else if (sign == '*') {
                stack.push(stack.pop() * d);
            } else if (sign == '/') {
                stack.push(stack.pop() / d);
            }
            d=0;
            sign='+';
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
