import java.util.*;
public class Main {
    static String[] lotto;
    static String[] arr;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while(true) {
            int k = sc.nextInt();
            arr = new String[k];
            for(int i=0; i<k; i++) {
                arr[i] = sc.nextInt()+"";
            }

            if(k == 0) break;
            
            for(String x : solution(k)) {
                System.out.println(x);
            }
            System.out.println();
        }//end of while--
    }

    private static List<String> solution(int k) {
        List<String> answer = new ArrayList<>();
        lotto = new String[6];
        visited = new int[k];

        recursive(0,0,  answer, k);
        return answer;
    }

    private static void recursive(int start, int depth, List<String> answer, int k) {
        if(depth == 6) {
            String str = String.join(" ", lotto);
            answer.add(str);
            return;
        }

        for(int i=start; i<k; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                lotto[depth] = arr[i];
                recursive(i, depth + 1, answer, k);
                visited[i] = 0;
            }
        }
    }
}
