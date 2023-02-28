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
        List<Integer> sumList = new ArrayList<>();
        Arrays.sort(arr);
        int answer = -1;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                sumList.add(arr[i] + arr[j]);
            }
        }
        Collections.sort(sumList);

        for(int i=n-1; i>=0; i--) {
            for(int j=i; j>=0 ;j--) {
                int k = arr[i] - arr[j];
                if(Collections.binarySearch(sumList,k) > -1) {
                    answer = arr[i];
                    break;
                }
            }
            if(answer != -1) break;
        }
        return answer;
    }
}