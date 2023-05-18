import java.util.*;
public class Main {
    static int count;
    static char[] arr;
    static String result;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.next();
            int n = sc.nextInt();
            System.out.println(solution(str, n));
            count = 0;
        }
    }

    private static String solution(String str, int n) {
        String answer = str + " " + n + " = ";

        visited = new int[str.length()];
        arr = new char[str.length()];

        recursive(0, str.length(),str, n);

        if(count < n) {
            answer += "No permutation";
            return answer;
        }

        answer += result;
        return answer;
    }

    private static void recursive(int depth, int len,String str, int n) {
        if(depth == len) {
            count++;
            if(count == n) result = new String(arr);
            return;
        }

        for(int i=0; i<len; i++) {
            if((visited[i] == 0)) {
                arr[depth] = str.charAt(i);
                visited[i] = 1;
                recursive(depth+1, len, str, n);
                visited[i] = 0;
            }
        }
    }
}
