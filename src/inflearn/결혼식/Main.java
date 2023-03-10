package inflearn.결혼식;

import java.util.*;
class Time implements Comparable<Time>{
    int time;
    char status;
    Time(int time, char status) {
        this.time = time;
        this.status = status;
    }

    @Override
    public int compareTo(Time t) {
        if(t.time == this.time) return  this.status -t.status;
        else return this.time - t.time;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Time> timeList = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int time = sc.nextInt();
            timeList.add(new Time(time, 's'));
            time = sc.nextInt();
            timeList.add(new Time(time, 'e'));
        }

        System.out.println(solution(timeList));
    }

    private static int solution(List<Time> timeList) {
        int answer = 0;
        Collections.sort(timeList);
        int count = 0;
        for(int i=0; i<timeList.size(); i++) {
            if(timeList.get(i).status == 's') {
                count++;
            } else count--;
            answer = Math.max(answer, count);
        }
        return answer;
    }
}
