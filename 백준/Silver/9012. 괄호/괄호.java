import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            String str = sc.next();
            sb.append(solution(str));
            if(i != t-1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static String solution(String str) {
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(x == '(') {
                stack.push(x);
            } else {
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }//end of for--
        if(stack.isEmpty()) return "YES";
        else return "NO";
    }

}