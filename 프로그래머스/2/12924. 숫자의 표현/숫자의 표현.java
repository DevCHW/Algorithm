class Solution {
    public int solution(int n) {
        int count = 0;
        int lt = 1;
        int rt = 1;
        int sum = lt;
        while(rt <= n) {
            if (sum > n) {
                sum -= lt;
                lt++;
            } else if (sum == n) {
                count++;
                rt++;
                sum += rt;
            } else {
                rt++;
                sum += rt;
            }    
        }
        return count;
    }
}