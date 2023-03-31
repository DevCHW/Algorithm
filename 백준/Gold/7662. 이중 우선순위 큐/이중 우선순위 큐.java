import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            int k = Integer.parseInt(br.readLine());   //연산의 갯수
            char[] chArr = new char[k];
            int[] numArr = new int[k];
            for(int j=0; j<k; j++) {
                String[] input = br.readLine().split(" ");
                chArr[j] = input[0].charAt(0);
                numArr[j] = Integer.parseInt(input[1]);
            }
            sb.append(solution(k, chArr, numArr));
            if(i != t-1) sb.append("\n");
        }
        System.out.print(sb);
    }
    private static String solution(int k, char[] chArr, int[] numArr) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();    //최솟값 삭제해주는 큐
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());  //최대값 삭제해주는 큐
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<k; i++) {
            if(chArr[i] == 'I') {
                map.put(numArr[i], map.getOrDefault(numArr[i], 0) + 1);
                minQueue.offer(numArr[i]);
                maxQueue.offer(numArr[i]);
            } else {     //'D'
                if(map.size() == 0) continue;   //맵이 비어있다면 무시
                if(numArr[i] == 1) {    //최댓값 삭제
                    while(true) {
                        int num = maxQueue.poll();
                        int count = map.getOrDefault(num, 0);

                        if(count == 0) continue;
                        if(count == 1) map.remove(num);
                        else map.put(num, count - 1);
                        break;
                    }
                } else {    //최솟값 삭제
                    while(true) {
                        int num = minQueue.poll();
                        int count = map.getOrDefault(num, 0);

                        if(count == 0) continue;

                        if(count == 1) map.remove(num);
                        else map.put(num, count - 1);
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if(map.isEmpty()) return "EMPTY";
        else {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (Integer x : map.keySet()) {
                if(x > max) max = x;
                if(x < min) min = x;
            }
            sb.append(max+" ").append(min);
        }
        return sb.toString();
    }
}