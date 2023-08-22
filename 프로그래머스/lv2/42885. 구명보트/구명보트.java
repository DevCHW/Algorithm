import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        //오름차순 정렬
        Arrays.sort(people);
        
        //몸무게가 가장 낮은사람 + 가장 높은사람 <= limit 이라면 같이 탑승,
        
        int lt = 0;
        for(int rt=people.length-1; rt>=lt; rt--) {
            if(people[lt] + people[rt] <= limit) lt++;
            answer++;
        }
        return answer;
    }
}