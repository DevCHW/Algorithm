import java.util.*;
public class Main {
    static class Road implements Comparable<Road>{
        int start;
        int end;
        int length;

        Road(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(Road o) {
            return this.start - o.start;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //지름길의 개수 N
        int d = sc.nextInt(); //고속도로의 길이
        List<Road> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int length = sc.nextInt();
            list.add(new Road(start, end, length));
        }
        System.out.println(solution(n, d, list));
    }

    private static int solution(int n, int d, List<Road> list) {
        Collections.sort(list); //시작지점을 기준으로 정렬
        int current = 0;  //현재위치
        int[] moves = new int[d+1];
        Arrays.fill(moves, Integer.MAX_VALUE);
        moves[0] = 0;
        int idx = 0;
        while(current != d) {
            //현재 위치가 지름길로 가볼 수 있는 위치인지 확인
            for(int i=idx; i<n; i++) {
                if(list.get(i).start != current) break;   //지름길 아니면 빠져나감
                //원래 있던 값보다 지름길로 이동한 값이 작다면 넣어주기
                if(list.get(i).end <= d) {
                    moves[list.get(i).end] = Math.min(moves[current]+list.get(i).length, moves[list.get(i).end]);
                }
                idx++;
            }

            //한칸 전진 앞에걸 확인해서 1보전진한값이 더 작다면 넣어주기
            moves[current+1] = Math.min(moves[current+1], moves[current] + 1);
            current++;

        }//end of while--
        return moves[d];
    }
}
