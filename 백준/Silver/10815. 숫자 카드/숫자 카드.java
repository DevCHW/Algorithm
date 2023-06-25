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
        int[] sangArr = new int[n];

        for(int i=0; i<n; i++) {
            sangArr[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr = new int[m];
        for(int i=0; i<m; i++) {
            arr[i] = sc.nextInt();
        }

        for(int x : solution(n, sangArr, m, arr)) {
            System.out.print(x + " ");
        }
    }

    public static int[] solution(int n, int[] sangArr, int m, int[] arr) {
        int[] answer = new int[m];
        Set set = new HashSet<>();

        for(int x : sangArr) set.add(x);

        for(int i=0; i<m; i++) {
            // 상근이가 가지고 있는 카드라면
            if (set.contains(arr[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
}
