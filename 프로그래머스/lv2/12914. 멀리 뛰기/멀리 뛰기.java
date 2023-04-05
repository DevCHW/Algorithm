class Solution {
    int[] dp;
    public long solution(int n) {
        long answer = 0;
        
        dp = new int[2001];
        dp[1] = 1;  //한칸
        dp[2] = 2;  //한칸,또는 두칸
        answer = (long) getAnswer(n);
        return answer;
    }
    
    public int getAnswer(int depth) {
        if(depth == 1) return 1;
        if(depth == 2) return 2;
        if(dp[depth] != 0) return dp[depth];
        else {
            return dp[depth] = (getAnswer(depth-2) + getAnswer(depth-1)) % 1234567;
        }
    }
}