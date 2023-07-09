import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Double> queue = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            double remainDays = (100 - progresses[i]*1.0) / speeds[i];
            double date = Math.ceil(remainDays); // 해당 progress를 처리하는데 걸리는 날짜
            queue.add(date);
        }

        List<Integer> answerList = new ArrayList<>();

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            int count = 1; // 현재 배포될 기능의 수
            double topDate = queue.poll(); // 큐의 맨 앞 원소를 빼서 가져옴

            while (!queue.isEmpty() && topDate >= queue.peek()){ // 큐의 맨 앞 수보다 작거나 같으면 함께 배포
                queue.poll();
                count ++;
            }
            answerList.add(count);
        }


        int[] answer = new int[answerList.size()];

        // 리스트에 저장된 배포될 기능의 수 배열에 담기
        for(int i=0; i<answer.length; i++ ){
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}