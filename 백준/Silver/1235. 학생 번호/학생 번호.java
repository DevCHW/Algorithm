import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.next();
        }
        System.out.println(solution(n, arr));
    }
    private static int solution(int n, String[] arr) {
        boolean flag = false;
        int len = arr[0].length();
        int k = 0;

        while(!flag) {
            k++;
            flag = true;
            for(int i=0; i<n; i++) {
                String tmp = arr[i].substring(len-k);
                for(int j=0; j<n; j++) {
                    if(i == j) continue;
                    if(arr[j].substring(len-k).equals(tmp)) {
                        flag = false;
                        break;
                    }
                    if(!flag) break;
                }
            }
        }
        return k;
    }


}