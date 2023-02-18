
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String first = sc.next();   //부분문자열이 될 문자
            String second = sc.next();

            Queue<Character> queue = new LinkedList<>();
            for(char x : first.toCharArray()) {
                queue.offer(x);
            }

            char ch = queue.peek();

            for(char x : second.toCharArray()) {
                if(ch == x) {
                    queue.poll();
                    if(!queue.isEmpty()) {
                        ch = queue.peek();
                    } else {
                        break;
                    }
                }
            }

            if(!queue.isEmpty()) System.out.println("No");
            else System.out.println("Yes");
        }
    }
}
