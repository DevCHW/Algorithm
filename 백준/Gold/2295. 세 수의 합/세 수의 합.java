
import java.util.*;

public class Main {
    private static List<Integer> sumList;
    private static boolean search(int gap) {
        int lt = 0;
        int rt = sumList.size()-1;

        while(lt < rt) {
            int mid = (lt + rt)/2;
            if(sumList.get(mid) < gap) {
                lt = mid + 1;
            } else if(sumList.get(mid) > gap) {
                rt = mid - 1;
            } else if(sumList.get(mid) == gap) {
                return true;
            }
        }
        return false;
    }
    public static int solution(int n, int[] arr) {
        //범위설정
        // x + y + z = k라면
        // x + y = k - z
        // x + y의 집합체를 만들기
        sumList = new ArrayList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sumList.add(arr[i] + arr[j]);
            }
        }
        Arrays.sort(arr);
        Collections.sort(sumList);

        int answer = Integer.MIN_VALUE;
        // k - z를 해서 검사하기
        for(int i=n-1; i>=0 ; i--) {
            for(int j=0; j<i; j++) {
                int gap = arr[i] - arr[j];
                if(search(gap) && arr[i] > answer) {
                    answer = arr[i];
                }
            }
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
