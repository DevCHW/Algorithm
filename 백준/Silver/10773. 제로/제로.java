import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] arr = new int[k];
        for(int i=0; i<k; i++) arr[i] = sc.nextInt();
        System.out.println(solution(k, arr));
    }
    private static int solution(int k, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int x : arr) {
            if(x != 0) {
                stack.push(x);
            } else {
                if(stack.isEmpty()) continue;
                stack.pop();
            }
        }
        int sum = 0;
        for(int x : stack) sum += x;
        return sum;
    }
}
