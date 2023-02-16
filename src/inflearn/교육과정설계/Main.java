package inflearn.교육과정설계;
import java.util.*;

public class Main {
    public static String solution(String str1, String str2) {
        String answer ="YES";
        Queue<Character> queue = new LinkedList<>();
        for(char x : str1.toCharArray()) {
            queue.offer(x);
        }
        for(char x : str2.toCharArray()) {
            if(queue.contains(x)) {
                if(x != queue.poll()) return "NO";
            }
        }
        if(!queue.isEmpty()) return "NO";
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();    //필수과목
        String str2 = sc.next();    //수업계획
        System.out.println(solution(str1, str2));
    }
}
