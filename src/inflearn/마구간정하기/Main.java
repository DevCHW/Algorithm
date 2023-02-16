package inflearn.마구간정하기;


import java.util.*;

public class Main {
    public static int count(int mid, int[] arr) {
        int count = 1;
        int endPoint = arr[0];
        for(int i=0; i<arr.length; i++) {
            if(arr[i] - endPoint >= mid) {
                count++;
                endPoint = arr[i];
            }
        }
        return count;
    }

    public static int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        // 1, 2, 4, 8, 9

        int lt=1; //거리의 최솟값
        int rt=arr[n-1]-arr[0];
        while(lt <= rt) {
            int mid = (lt + rt)/2;
            if(count(mid, arr) >= c) {
                answer = mid;
                lt = mid+1;
            } else rt = mid -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //마구간 수
        int c = sc.nextInt();   //말 마리 수
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, c, arr));
    }
}

