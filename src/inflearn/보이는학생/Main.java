package inflearn.보이는학생;

import java.util.*;

public class Main {
    public int solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        int max = arr[0];
        for(int i=1; i<n; i++) {
            if(arr[i] > max) {
                max = arr[i];
                answer.add(arr[i]);
            }
        }
        return answer.size();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(T.solution(n, arr));

    }

    /**
     // == 준비 == //
     1.정수 하나 입력받기 : int n
     2. 정수배열 : int[] arr

     // == 로직 == //
     1. 배열 돌려서 큰 수만 돌리기
     */

}


