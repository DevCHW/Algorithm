import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        // n이 0이될 때 까지 반복
        while(n != 0) {
            if(n%2 == 0) n /=2; //짝수라면 순간이동
            else {      //홀수라면 -1(점프)
                n-=1;
                answer++;
            }
        }
        return answer;
    }
}