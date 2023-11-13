class Solution {
    private int[] fibo;
    
    public int solution(int n) {
        fibo = new int[n+1];
        return recursive(n);
    }
    
    private int recursive(int n) {
        if (n == 0) return fibo[n] = 0;
        if (n == 1) return fibo[n] = 1;
        if (fibo[n] != 0) return fibo[n];
        return fibo[n] = (recursive(n-1) + recursive(n-2))%1234567;
    }
}