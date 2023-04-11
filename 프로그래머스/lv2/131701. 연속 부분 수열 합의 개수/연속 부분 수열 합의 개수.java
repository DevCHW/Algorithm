import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        answer += elements.length;
        int len = 1;    //길이
        
        Set<Integer> set = new HashSet<>();
        while(len <= elements.length) { //구하고자 하는 연속부분수열의 길이를 1씩 늘리면서 구하기
            for(int i=0; i<elements.length; i++) {
                int sum = 0;
                for(int j=i; j<i+len; j++) { //연속부분수열의 길이만큼 sum 구하기
                    sum += elements[j % elements.length];
                }
                set.add(sum);
            }
            len++;
        }
        answer = set.size();
        return answer;
    }
}