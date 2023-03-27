class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(String x : arr) {
            int tmp = Integer.parseInt(x);
            if(max < tmp) max = tmp;
            if(min > tmp) min = tmp;
        }
        answer += min + " ";
        answer += max;
        return answer;
    }
}