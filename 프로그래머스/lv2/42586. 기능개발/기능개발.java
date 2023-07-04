import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        //map으로 배포되는 기능들 중복카운팅 하기.(배포되는 일자, 배포되는 기능 횟수)
        Map<Integer, Integer> map = new LinkedHashMap<>();
        
        //탐색 배열 길이 뽑기
        int len = progresses.length;
        int[] arr = new int[len];
        
        // 작업들의 남은 일 수 계산하여 arr에 넣기
        int beforeWorkDay = 0;
        for(int i=0; i<len; i++) {
            int percent = progresses[i];
            int speed = speeds[i];
            
            int workDay = calculateWorkDay(percent, speed);
            if (beforeWorkDay > workDay) workDay = beforeWorkDay;
            
            map.put(workDay, map.getOrDefault(workDay, 0) + 1);
            beforeWorkDay = workDay;
        }
        
        int[] answer = new int[map.size()];
        int idx = 0;
        for(int key : map.keySet()) {
            answer[idx] = map.get(key);
            idx++;
        }
        return answer;
    }
    
    // 남은 작업일자 계산
    private int calculateWorkDay(int percent, int speed) {
        int workDay = 0;
        
        while(percent < 100) {
            workDay++;
            percent += speed;
        }
        return workDay;
    }
}