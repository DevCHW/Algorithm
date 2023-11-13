import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        // 하나는 오름차순 정렬, 하나는 내림차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        int len = A.length;
        int answer = 0;
        for(int i=0; i<len; i++) {
            answer += A[i]*B[len-1-i]; 
        }
        
        return answer;
    }
}