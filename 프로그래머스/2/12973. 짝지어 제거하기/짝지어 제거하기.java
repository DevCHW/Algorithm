import java.util.*;
class Solution{
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(char x : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(x);
            } else {
                if (stack.peek() == x) {
                    stack.pop();
                } else {
                    stack.push(x);
                }
            }
        }
        
        if (stack.isEmpty()) return 1;
        else return 0;
    }
}