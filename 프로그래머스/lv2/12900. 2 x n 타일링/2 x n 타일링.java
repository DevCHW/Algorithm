class Solution {
    int[] dp;
    public int solution(int n) {
        int answer = 0;
        // 세로의 길이 2로 고정.
        // 가로의 길이 n(60000 이하)
        // 방법의 수 -> dp?
        // n이 1일 때 -> 1
        // n이 2일 때 -> 2
        // n이 3일 때 -> 3
        // n이 4일 때 -> 5
        // n = n-1 + n-2
        dp = new int[n+1];
        answer = recursive(n);
        return answer;
    }
    
    public int recursive(int n) {
        if(n == 1) return dp[1] = 1;
        if(n == 2) return dp[2] = 2;
        if(dp[n] != 0) return dp[n];
        return dp[n] = (recursive(n-2) + recursive(n-1)) % 1000000007;
    }
}