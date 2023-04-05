class Solution {
    public int solution(int[] arr) {
        //두 수의 최소공배수 -> 두 수의 곱 / 최대공약수
        //두 수의 최소공배수를 arr의 0번째 인덱스부터 끝까지 구하는거로 진행
        
        int answer = arr[0];
        for(int i=1; i<arr.length; i++) {
            answer = (answer * arr[i]) / cal(answer, arr[i]);   //두 수의 곱 /최대공약수
        }
        return answer;
    }
    
    // 두 수의 최대 공약수 계산하기
    private int cal(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        
        while(max % min != 0) {
            int tmp = min;
            min = max%min;
            max = tmp;
        }
        return min;
    }
}