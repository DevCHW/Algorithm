import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] arr = new String[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextLine();
        }


        System.out.print(solution(n, arr));
    }
    private static StringBuilder solution(int n, String[] arr) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for(String x : arr) {
            String[] command = x.split(" ");
            if(command[0].equals("push")) queue.offer(Integer.parseInt(command[1]));
            else if(command[0].equals("front")) {
                if(queue.isEmpty()) sb.append(-1);
                else sb.append(queue.peek());
            } else if(command[0].equals("back")) {
                if(queue.isEmpty()) sb.append(-1);
                else {
                    for(int i=0; i<queue.size(); i++) {
                        int tmp = queue.poll();
                        queue.offer(tmp);
                        if(i == queue.size()-1) sb.append(tmp);
                    }
                }
            } else if(command[0].equals("size")) {
                sb.append(queue.size());
            } else if(command[0].equals("pop")) {
                if(queue.isEmpty()) sb.append(-1);
                else sb.append(queue.poll());
            } else if(command[0].equals("empty")) {
                if(queue.isEmpty()) sb.append(1);
                else sb.append(0);
            }
            if(!command[0].equals("push")) sb.append("\n");
        }
        return sb;
    }
}
