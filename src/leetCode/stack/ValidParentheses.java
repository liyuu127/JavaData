package leetCode.stack;

import java.util.*;

/**
 * @author liyu
 * date 2021/6/4 10:09
 * description 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'?的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidParentheses {
    public static void main(String[] args) {
        boolean valid = isValid("]");
        System.out.println("valid = " + valid);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.empty()) {
                    if (s.charAt(i) == ')') {
                        if (stack.pop() != '(') {
                            return false;
                        }
                    } else if (s.charAt(i) == '}') {
                        if (stack.pop() != '{') {
                            return false;
                        }
                    } else {
                        if (stack.pop() != '[') {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public boolean isValid0(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
