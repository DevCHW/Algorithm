class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right-left+1);
        int[] answer = new int[len];
        
        int index = 0;
        for(long i=left; i<=right; i++) {
            if( (i/n) > 0 ) { //사이클이 돌았을 경우
                if( (i%n) < (i/n) ) { //인덱스 전까지 + cycle
                    answer[index] = (int) ((i/n)+1);
                } else { //원래숫자
                    answer[index] = (int) (i%n+1);
                }            
            } else { //사이클이 돌지 않았을 경우
                answer[index] = (int) (i%n+1);
            }
            index++;
        }
        return answer;
    }
}