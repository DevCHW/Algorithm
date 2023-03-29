class Solution {
    public int solution(int n) {
        int answer = 0;
        //'연속된' 자연수.. 투포인터 알고리즘 이용해보기
        
        int lt = 0;
        int rt = 1;
        int sum = 0;
        while(rt <= n) {
            if(sum == n) {
                answer++;
                sum += rt;
                rt++;
            }
            else if(sum > n) {
                sum -= lt;
                lt++;
            } else {
                sum += rt;
                rt++;
            }
        }
        answer++;
        
        return answer;
    }
}