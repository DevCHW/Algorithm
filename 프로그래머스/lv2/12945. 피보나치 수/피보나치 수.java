class Solution {
    static long[] fibo;
    
    public int solution(int n) {
        int answer = 0;
        fibo = new long[100001];
        answer = (int) F(n);
        return answer;
    }
    
    public long F(int depth) {
        if(depth == 0) return 0;
        if(depth == 1) return 1;
        if(fibo[depth] != 0L) return fibo[depth];
        else {
            return fibo[depth] = (F(depth-1) + F(depth-2))%1234567;
        }
    }
}