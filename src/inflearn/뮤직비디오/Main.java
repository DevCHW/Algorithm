package inflearn.뮤직비디오;


import java.util.*;

public class Main {
    private static int count(int mid, int[] arr) {
        int sum =0;
        int count =1;
        for(int i=0; i<arr.length; i++) {
            if(sum+arr[i] > mid) {
                count++;
                sum = arr[i];
            } else sum += arr[i];
        }
        return count;
    }

    public static int solution(int n, int m, int[] arr) {
        int lt = Arrays.stream(arr).max().getAsInt();   //배열의 최댓값
        int rt = Arrays.stream(arr).sum();              //배열의 합
        int answer = Integer.MAX_VALUE;
        while(lt <= rt) {   //이분탐색 시작
            int mid = (lt+rt)/2;
            if(count(mid, arr) <= m) {
                rt = mid-1;
                answer = mid;
            }
            else lt = mid + 1;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //노래 갯수
        int m = sc.nextInt();   //dvd 장 수
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }
}

