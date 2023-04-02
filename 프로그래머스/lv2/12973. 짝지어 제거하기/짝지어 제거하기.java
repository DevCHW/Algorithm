import java.util.*;
class Solution{
    public int solution(String s) {
        int answer = -1;
        
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        
        for(int i=1; i<s.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        
        if(stack.isEmpty()) answer = 1;
        else answer = 0;
        
        return answer;
    }
}