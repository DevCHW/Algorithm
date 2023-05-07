import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, arr));
    }
    private static int solution(int n, int[] arr) {
        Arrays.sort(arr);
        int idx = 0;
        for(int x : arr) {
            if(x > 0) break;
            idx++;
        }
        int answer = 0;
        // 음수또는 0 탐색, 길이 = idx
        boolean flag = false;
        int count = 0;
        int tmp = 1;
        for(int i=0; i<idx; i++) {
            if(idx % 2 == 0) {  //음수또는 0의 갯수가 짝수개라면,
                answer += arr[i] * arr[i+1];
                i++;
            } else {    //음수또는 0의 갯수가 홀수개라면 맨 뒤의 것만 제외해야 함.
                if(i == idx-1) {
                    answer += arr[i];
                } else {
                    tmp *= arr[i];
                    count++;
                    if(count == 2) {
                        answer += tmp;
                        tmp = 1;
                        count = 0;
                    }
                }
            }
        }

        tmp = 1;
        count = 0;
        //양수 탐색
        for(int i=n-1; i>=idx; i--) {
            if(arr[i] == 1) answer += 1;
            else {
                tmp *= arr[i];
                count++;
                if(count == 2) {
                    answer += tmp;
                    tmp = 1;
                    count = 0;
                }
            }
        }
        if(tmp != 1) answer += tmp;
        return answer;
    }
}
