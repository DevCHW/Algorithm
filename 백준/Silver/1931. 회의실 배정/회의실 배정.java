import java.util.*;
class Time implements Comparable<Time> {
    int start;
    int end;
    Time(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Time t) {
        if(this.end == t.end) return this.start - t.start;
        return this.end - t.end;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Time> timeList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            timeList.add(new Time(start, end));
        }
        System.out.println(solution(n, timeList));
    }

    private static int solution(int n, List<Time> timeList) {
        Collections.sort(timeList);

        int answer = 0;
        int end = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if(end <= timeList.get(i).start) {
                answer++;
                end = timeList.get(i).end;
            }
        }
        return answer;
    }
}