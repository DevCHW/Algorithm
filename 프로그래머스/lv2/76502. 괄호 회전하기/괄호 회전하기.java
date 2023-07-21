import java.util.*;
class Solution {
    Stack<Character> stack = new Stack<>();
    
    public int solution(String s) {
        int answer = 0;
        // () [] {} 올바른 괄호
        // 포함 가능
        // 0부터 시작하여 s의 길이 -1 만큼 검사 하면 되지 않을까?
        // s의 범위는 1000 이므로 1000의 제곱은 1000000 이라서 쌉가능
        
        // 일단, 문자가 들어오면 올바른 괄호인지 검사하는 메소드 만들자.
        
        // 회전시키면서 검사하면 될듯?
        for(int i=0; i<s.length(); i++) {
            if (testBracket(s)) {   //올바른 괄호라면
                answer++;
            }
            // 회전시키기
            s = rotation(s);
        }
        
        return answer;
    }
    // 회전 시키는 메소드
    private String rotation(String s) {
        // 문자의 길이가 2 이상이어야 회전 가능함.
        if(s.length() > 1) {
            String tmp = s.substring(0,1);
            s = s.substring(1);
            s += tmp;
            return s;
        }
        return s;
    }
    
    // 올바른 괄호인지 검사하는 메소드
    private boolean testBracket(String s) {
        for(char x : s.toCharArray()) {
            if(x == '(' || x == '[' || x == '{') {  //여는 괄호라면 스택에 넣기
                stack.push(x);
            } else {    //닫는 괄호라면
                if(!stack.isEmpty()) {  //스택이 비어있지 않다면
                    char tmp = stack.pop();
                    if (tmp == '{' && x != '}' ||
                        tmp == '(' && x != ')' ||
                        tmp == '[' && x != ']') {
                        stack.clear();
                        return false;
                    } 
                } else {    //스택이 비어있다면 올바른 괄호가 아님.
                    return false;
                }
            }
        }
        
        // 위의 과정이 끝나고 난 뒤에 스택 확인
        if (stack.isEmpty()) {  //스택이 비어있다면
            return true;
        } else {    //스택이 비어있지 않다면
            stack.clear();
            return false;
        }
    }
}