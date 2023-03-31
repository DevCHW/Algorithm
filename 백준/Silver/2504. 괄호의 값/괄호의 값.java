import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

    public static int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        int tmp = 1;
        for(int i=0; i<str.length(); i++) {
            char x = str.charAt(i);
            if (x == '(' ) {
                tmp *= 2;
                stack.push(x);
            } else if(x == '[') {
                tmp *= 3;
                stack.push(x);
            }
            else {      //닫는 괄호라면,
                if (stack.isEmpty()) return 0;  //올바르지 못한 괄호라면 0 return
                else {  // 올바른 괄호
                    if(x == ')') {  // ')'일 때
                        if(stack.peek() != '(') return 0;
                        else {
                            if(str.charAt(i-1) == '(') {
                                answer += tmp;
                            }
                            tmp /= 2;
                            stack.pop();
                        }
                    } else if(x == ']'){    // ']'일 때
                        if(stack.peek() != '[') return 0;
                        else {
                            if(str.charAt(i-1) == '[') {
                                answer += tmp;
                            }
                            tmp /= 3;
                            stack.pop();
                        }
                    }
                }
            }
        }

        if (!stack.isEmpty()) return 0; //스택이 비어있지 않다면 0
        else {
            return answer;
        }
    }
}
