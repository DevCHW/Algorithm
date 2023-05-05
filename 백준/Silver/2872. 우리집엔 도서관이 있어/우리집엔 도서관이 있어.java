import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        System.out.println(solution(n, arr));
    }

    private static int solution(int n, int[] arr) {
        int num = n;    //최대값
        int count = 0; //제대로 정렬되어있는 원소 갯수
        for(int i=n-1; i>=0; i--) {
            if(arr[i] == num) {
                count++;
                num--; //최댓값 -1
            }
        }
        return n-count;
    }
}
