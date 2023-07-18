class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(0, 0, numbers, target);
        return answer;
    }
    
    private int dfs(int depth, int sum, int[] numbers, int target) {
        if(depth == numbers.length) {
            if (sum == target) return 1;
            else return 0;
        }
        return dfs(depth+1, sum + numbers[depth], numbers, target) + 
            dfs(depth+1, sum - numbers[depth], numbers, target);    //더하거나, 빼거나
    } 
}