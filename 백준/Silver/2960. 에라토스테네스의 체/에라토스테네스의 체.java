
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n + 1];
        for(int i=2; i<=n; i++) {
            arr[i] = i;
        }

        int count = 0;
        int answer = 0;
        for(int i=2; i<=n; i++) {
            if(arr[i] != 0) {
                for(int j=i; j<=n; j+=i) {
                    if(arr[j] != 0) count++;

                    int tmp = arr[j];
                    arr[j] = 0;
                    if(count == k) {
                        answer = tmp;
                        break;
                    }
                }
            }
            if(count == k) break;
        }
        System.out.print(answer);
    }
}
