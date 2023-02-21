import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i=0; i<n; i++) {
            arr[i] = br.readLine();
        }
        solution(n, arr);
    }

    private static void solution(int n, String[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(String x : arr) {
            String answer = "";
            String[] str = x.split(" ");

            if(str[0].equals("push")) {
                stack.push(Integer.parseInt(str[1]));
                continue;
            } else if(str[0].equals("pop")) {
                if(stack.isEmpty()) {
                    answer = "-1";
                } else {
                    answer = stack.pop()+"";
                }
            } else if(str[0].equals("size")) {
                answer = stack.size()+"";
            } else if(str[0].equals("empty")) {
                if(stack.isEmpty()) {
                    answer = "1";
                } else {
                    answer = "0";
                }
            } else if(str[0].equals("top")) {
                if(stack.isEmpty()) {
                    answer = "-1";
                }else {
                    answer = stack.peek()+"";
                }
            }
            System.out.println(answer);
        }
    }
}