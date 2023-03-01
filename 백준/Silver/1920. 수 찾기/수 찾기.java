import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i=0; i<n; i++) arr1[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i=0; i<m; i++) arr2[i] = sc.nextInt();

        StringBuilder sb = solution(n, arr1, m, arr2);
        System.out.println(sb);
    }
    private static StringBuilder solution(int n, int[] arr1, int m, int[] arr2) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x: arr1) {
            map.put(x, map.getOrDefault(x,0) + 1);
        }
        int count = 0;
        for(int x : arr2) {
            count++;
            int a = map.getOrDefault(x,0);
            if(a > 0) {
                sb.append(1);
            } else {
                sb.append(0);
            }

            if(count != arr2.length) sb.append("\n");
        }//end of for--
        return sb;
    }
}
