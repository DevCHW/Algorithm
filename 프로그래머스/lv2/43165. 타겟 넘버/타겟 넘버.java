class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    private void dfs(int depth, int currentNumber, int[] numbers, int target) {
        if(depth == numbers.length) {
            if(currentNumber == target) answer++;
        } else {
            dfs(depth+1, currentNumber+numbers[depth], numbers, target);
            dfs(depth+1, currentNumber-numbers[depth], numbers, target);
        }
    }
}