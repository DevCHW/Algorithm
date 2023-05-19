import java.util.*;
class Solution {
    // 접근 => 무적권은 가장 적이 많을 때 사용하여야 함.
        // n의 범위가 10억이므로 n제곱 X
        // 일단 무적권을 사용하지 않고 돌면서, 병사가 다 떨어지면 그동안 지나왔던 라운드에서 가장 적이 많은 것 꺼내고 무적권 사용했다고 치고 쭉 전진.
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<enemy.length; i++) {
            int enemyCount = enemy[i];  //현재 라운드의 적의 수
            queue.offer(enemyCount);
            n -= enemyCount; //현재병사 - 적의 수
            
            if(n < 0) { //감당할 수 없는 라운드일 경우
                if(k > 0) { //무적권을 사용할 수 있는지 확인
                    k--; //무적권 사용
                    int saveEnemyCount = queue.poll(); //pq에 있는 가장 큰 값 꺼내기
                    n += saveEnemyCount;
                } else { //무적권을 사용할 수 없다면 탈출
                    break;
                }
            }
            answer++; //라운드 증가
        }//end of for--
        
        return answer;
    }
}