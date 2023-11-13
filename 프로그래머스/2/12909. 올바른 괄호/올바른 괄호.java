import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(char x : s.toCharArray()) {
            if (x == '(') { // 열린 괄호라면
                stack.push(x);
            } else { // 닫힌 괄호라면
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}