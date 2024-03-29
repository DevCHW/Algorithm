class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        // 0 카운팅
        int zeroCnt = 0;
        
        // 1 카운팅
        int count = 0;
        while(!"1".equals(s)) {
            count++;
            String tmp = "";
            for(char x : s.toCharArray()) {
                if(x == '0') {
                    zeroCnt++;
                } else {
                    tmp += x;
                }
            }
            
            s = String.valueOf(Integer.toBinaryString(tmp.length()));
        }
        answer = new int[2];
        answer[0] = count;
        answer[1] = zeroCnt;
        
        return answer;
    }
}