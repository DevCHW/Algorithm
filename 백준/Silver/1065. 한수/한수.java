import java.util.*;

public class Main {
    /**
     * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     * StringTokenizer st = new StringTokenizer(br.readLine());
     * int n = Integer.parseInt(br.readLine());
     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++) {
            if (check(String.valueOf(i))) answer++;
        }

        return answer;
    }

    private static boolean check(String str) {
        if (str.length() >= 2) {
            int num1 = str.charAt(0)-'0';
            int num2 = str.charAt(1)-'0';
            int gap = num2 - num1;

            for(int i=2; i<str.length(); i++) {
                int tmp = (str.charAt(i)-'0') - (str.charAt(i-1)-'0');
                if (gap != tmp) return false;
            }
        }
        return true;
    }
}
