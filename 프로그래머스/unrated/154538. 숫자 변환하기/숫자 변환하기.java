class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y+1];
        for(int i=x; i<=y; i++) {
            if(i != x && dp[i] == 0) { //만들 수 없는 수는 전부 -1
                dp[i] = -1;
                continue;
            }
            if(i+n <= y) dp[i+n] = dp[i+n] == 0? dp[i]+1:Math.min(dp[i]+1, dp[i+n]);
            if(i*2 <= y) dp[i*2] = dp[i*2] == 0? dp[i]+1:Math.min(dp[i]+1, dp[i*2]);
            if(i*3 <= y) dp[i*3] = dp[i*3] == 0? dp[i]+1:Math.min(dp[i]+1, dp[i*3]);
        }
        int answer = dp[y];
        return answer;
    }
    
    
}