class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        // 노랑 1 갈색 8  -> 가로 3 세로 3
        // 노랑 2 갈색 10 -> 가로 4 세로 3
        // 노랑 3 갈색 12 -> 가로 5 세로 3
        // 노랑 4 갈색 12 -> 가로 4 세로 4
        // 노랑 5 갈색 16 -> 가로 7 세로 3
        // 노랑 6 갈색 14 -> 가로 5 세로 4
        
        // 노랑 + 갈색 -> x * y
        // 카펫 사이즈 변수 선언 (노랑+갈색)
        int size = brown+yellow;
        
        int x = -1;
        int y = -1;
        
        // 1~ size까지 탐색( O(N) )
        for(int i=1; i<=size; i++) {
            if(size % i == 0) { //i가 size의 약수라면
                if(i >= (size/i)) { //가로의 길이가 세로길이와 같거나 크다면
                    x = i;
                    y = size/i;
                }    
            }
            if((x-2) * (y-2) == yellow) break;
        }
        answer = new int[2];
        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }
}