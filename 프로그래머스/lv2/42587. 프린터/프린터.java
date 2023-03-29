import java.util.*;
class Solution {
    
    class Document {
        int location;   //위치
        int priority;   //중요도
        Document(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Document> queue = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++) {
            queue.offer(new Document(i, priorities[i]));
        }
        
        while(!queue.isEmpty()) {
            Document doc = queue.poll();
            int current_priority = doc.priority;   //꺼낸 문서의 중요도
            
            int len = queue.size();
            boolean flag = true;    //출력할지(true), 출력하지않을지(false) 
            for(Document x : queue) { //queue에 남아있는 문서들 중 현재 출력할 문서보다 중요도가 높은 문서가 있는지 체크
                if(current_priority < x.priority) {
                    queue.offer(doc);
                    flag = false;
                    break;
                }
            }
            if(flag) {
                answer++;  //출력
                if(doc.location == location) {  //출력한 문서가 내가 요청한 문서라면 탈출
                    break;
                }
            }
        }
        return answer;
    }
}