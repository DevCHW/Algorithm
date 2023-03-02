import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //단어의 개수
        String[] arr = new String[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.next();
        }
        System.out.println(solution(n, arr));
    }
    private static int solution(int n, String[] arr) {
        int answer = 0;
        for(String x : arr) {
            Map<Character, Integer> map = new HashMap<>();
            char tmp = x.charAt(0);
            map.put(tmp, 1);
            for(int i=1; i<x.length(); i++) {
                if(tmp != x.charAt(i)) {
                    tmp = x.charAt(i);
                    map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                }
            }
            boolean flag = true;
            for(int a : map.values()) {
                if(a > 1) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }//end of for--
        return answer;
    }
}
