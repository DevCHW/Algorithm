import java.util.*;
class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;
        //큰 쪽이 짝수여야 한다.
        while(true) {
            if(Math.abs(a-b) == 1) {
                if((a>b && a%2==0) ||
                  (b>a && b%2==0)) break;    
            }
            a = a%2==0?a/2:a/2+1;
            b = b%2==0?b/2:b/2+1;
            answer++;
        }
        return answer;
    }
}