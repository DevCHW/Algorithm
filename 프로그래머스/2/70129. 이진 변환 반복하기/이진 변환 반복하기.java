import java.util.*;

class Solution {
    // System.out.println();
    public int[] solution(String s) {
        int zeroCount = 0;
        int binaryCount = 0;
        while(true) {
            if (s.equals("1")) break;
            
            binaryCount++;
            zeroCount += countZero(s);
            // 0 제거
            String removeZero = s.replaceAll("0", "");
            // 길이 구하기
            int len = removeZero.length();
            // 2진 변환
            String result = Integer.toBinaryString(len);
            
            s = result;
        }
        
        int[] answer = {binaryCount, zeroCount};
        return answer;
    }
    
    private int countZero(String s) {
        int count = 0;
        for(char x : s.toCharArray()) {
            if (x == '0') count++;
        }
        return count;
    }
}