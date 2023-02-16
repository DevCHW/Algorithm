
import java.util.*;

public class Main {
    public static String solution(String str) {
        String answer = "";
        str = str.toUpperCase();
        Map<Character,Integer> map = new HashMap<>();

        for(char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1) ;
        }
        int max = 0;
        boolean flag = false;
        for(char x : map.keySet()) {
            int val = map.get(x);
            if(val == max) {
                flag = true;
            } else if(val > max) {
                flag = false;
                max = val;
                answer = String.valueOf(x);
            }
        }

        if(flag) return "?";
        else return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
