import java.util.*;
class Solution {
    class Homework implements Comparable<Homework>{
        public String name; //과제명
        public int startTime; //시작시간
        public int playTime; 
        
        Homework(String name, int startTime, int playTime) {
            this.name = name;
            this.startTime = startTime;
            this.playTime = playTime;
        }
        
        @Override
        public int compareTo(Homework o) {
            return this.startTime - o.startTime;
        }
    }
    
    public String[] solution(String[][] plans) {
        
        //자료구조 선언
        Stack<Homework> stack = new Stack<>(); //임시 저장소
        List<Homework> list = new ArrayList<>(); //과제 리스트
        List<String> answerList = new ArrayList<>(); //정답 리스트
        
        // 1.과제 리스트 값 넣어주기
        for(int i=0; i<plans.length; i++) {
            //변수 꺼내기
            String[] info = plans[i];
            String name = info[0];
            String start = info[1];
            int playTime = Integer.parseInt(info[2]);
            
            String[] arr = start.split(":");
            
            int startTime = transferMinute(arr[0], arr[1]);
            list.add(new Homework(name, startTime, playTime));
        }//end of for--
        
        Collections.sort(list); //2.시작시간을 기준으로 정렬
        
        //3.과제 리스트 탐색
        for(int i=1; i<list.size(); i++) {
            Homework currentHw = list.get(i);   //현재 진행과제
            Homework beforeHw = list.get(i-1);  //이전 과제
            
            int runningTime = currentHw.startTime - beforeHw.startTime; //과제를 수행 할 수 있는 시간 
            
            if(beforeHw.playTime < runningTime) { //case 1.이전 과제를 끝내고 시간이 남은 경우
                answerList.add(beforeHw.name);
                runningTime -= beforeHw.playTime;
                
                while(runningTime > 0) {
                    if(!stack.isEmpty()) { //멈춰 둔 과제가 있다면 진행.
                        Homework tmpHw = stack.pop();
                        
                        if(tmpHw.playTime <= runningTime) { //멈춰 둔 과제를 끝낼 수 있다면
                            runningTime -= tmpHw.playTime;
                            answerList.add(tmpHw.name);
                            
                        } else { //멈춰 둔 과제를 끝낼 수 없다면
                            tmpHw.playTime = tmpHw.playTime - runningTime;
                            stack.push(tmpHw);
                            break;
                        }
                    } else { //멈춰 둔 과제가 없다면 탈출
                        break;
                    }
                }
                
            } else if(beforeHw.playTime == runningTime) { //case 2.이전 과제를 끝내고 새로운 과제를 바로 시작해야하는 경우
                answerList.add(beforeHw.name);
                
            } else { //case 3.이전 과제를 끝낼 수 없는 경우
                beforeHw.playTime = beforeHw.playTime - runningTime; //남은시간 기록
                stack.push(beforeHw); //임시저장소에 저장
            }
            
            // 마지막 차례의 과제는 무조건 끝내기
            if(i == list.size()-1) answerList.add(currentHw.name);
        }//end of for--
        
        //임시 저장소 탐색
        while(!stack.isEmpty()) {
            Homework hw = stack.pop();
            answerList.add(hw.name);
        }
        
        
        String[] answer = new String[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    // hh:mm -> 분으로 변환메소드
    private int transferMinute(String strHour, String strMinute) {
        int hour = Integer.parseInt(strHour);
        int minute = Integer.parseInt(strMinute);
        return (hour*60) + minute;
    }
}