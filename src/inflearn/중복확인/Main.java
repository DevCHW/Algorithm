package inflearn.중복확인;

import java.util.*;

public class Main {
    //정렬로 풀기
    public static String solution(int n, int[] arr) {
        String answer = "U";
        Arrays.sort(arr);
        for(int i=0; i<n-1; i++) {
            if(arr[i] == arr[i+1]) return "D";
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(solution(n, arr));
    }
}

