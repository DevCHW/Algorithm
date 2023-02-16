package inflearn.중복확인;

import java.util.*;

public class Main2 {
    //해쉬맵으로 풀기
    public static String solution(int n, int[] arr) {
        String answer = "U";
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for(int x : map.keySet()) {
            if(map.get(x) > 1) return "D";
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

