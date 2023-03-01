import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        StringBuilder sb = solution(n, arr);
        System.out.print(sb);
    }
    private static StringBuilder solution(int n, int[] arr) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int number = 1;
        int idx = 0;
        int[] answerArr = new int[n];
        boolean flag = true;
        while(idx < n) {
            while(number <= arr[idx]) {
                stack.push(number++);
                sb.append("+");
                sb.append("\n");
            }
            if(stack.isEmpty()) {
                flag = false;
                break;
            } else {
                answerArr[idx] = stack.pop();
                sb.append("-");
                sb.append("\n");
            }
            idx++;
        }
        if(Arrays.equals(answerArr, arr)) return sb;
        else return new StringBuilder("NO");
    }
}
