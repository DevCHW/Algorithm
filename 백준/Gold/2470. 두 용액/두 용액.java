
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] solution(int n, int[] arr) {
        // 투 포인터를 이용하여 더한 결과가 0에 가까우면 된다.
        int[] answer = new int[2];
        Arrays.sort(arr);   //오름차순 정렬시키기
        int lt = 0;
        int rt = n-1;

        int answer_lt = 0;
        int answer_rt = n-1;

        int min = Integer.MAX_VALUE;
        while(lt < rt) {
            int sum = arr[lt] + arr[rt];
            if(Math.abs(sum) < min) {
                min = Math.abs(sum);
                answer_lt = lt;
                answer_rt = rt;
            }
            if(sum == 0) {
                answer_lt = lt;
                answer_rt = rt;
                break;
            } else if(sum > 0){
                rt--;
            } else {
                lt++;
            }
        }
        answer[0] = arr[answer_lt];
        answer[1] = arr[answer_rt];
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());   //전체 용액의 수

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int x : solution(n, arr)){
            System.out.print(x + " ");
        }
    }
}


