class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        // m*n n*k 행렬의 곱셈 결과는 m*k 행렬이다. 
        // 결과의 배열 생성
        
        for(int i = 0; i < answer.length; i++){ 
            for(int j = 0; j < answer[i].length; j++){
                for(int k = 0; k < arr1[0].length; k++){
                    answer[i][j] += arr1[i][k]*arr2[k][j];
                }
            }
        }
        return answer;
    }
}