package inflearn.가위바위보;

import java.util.*;

public class Main {
    public String[] solution(int n, int[] arrA, int[] arrB) {
        String[] answer = new String[n];
//        A가 1을 냈을 때 이기려면 => B가 3을 내야 함
//        A가 2을 냈을 때 이기려면 => B가 1을 내야 함
//        A가 3을 냈을 때 이기려면 => B가 2를 내야 함
        for(int i=0; i<n; i++) {
            if(arrA[i] == 1 && arrB[i] == 3){           // A이김
                answer[i] = "A";
            } else if(arrA[i] == 2 && arrB[i] == 1) {   // A이김
                answer[i] = "A";
            } else if(arrA[i] == 3 && arrB[i] == 2) {   // A이김
                answer[i] = "A";
            } else if (arrA[i] == arrB[i]) {            // 비김
                answer[i] = "D";
            } else {
                answer[i] = "B";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];

        for(int i=0; i<n; i++) {
            arrA[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++) {
            arrB[i] = sc.nextInt();
        }
        for(String x : T.solution(n, arrA, arrB)){
            System.out.println(x);
        }
    }

    /**
     // == 로직 == //
     1:가위, 2:바위, 3:보
     A가 1을 냈을 때 이기려면 => B가 3을 내야 함
     A가 2을 냈을 때 이기려면 => B가 1을 내야 함
     A가 3을 냈을 때 이기려면 => B가 2를 내야 함
     */

}


