class Solution {
    static int[] data = new int[100001]; // 최대값 100000
    
    public int solution(int n) {
        int answer = 0;
        
        answer = fibonacci(n);
        
        return answer;
    }
    
    private static int fibonacci(int n) {
        if(n < 2) return n; // 0과 1은 그대로 return
        if(data[n] != 0) return data[n] % 1234567; // n번째 피보나치 수 / 1234567 값 return
		
        return data[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 1234567;
    }
}