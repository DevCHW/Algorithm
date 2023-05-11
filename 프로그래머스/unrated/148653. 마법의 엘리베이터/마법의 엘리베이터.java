class Solution {
    public int solution(int storey) {
        int answer = 0;
        char[] tmp = String.valueOf(storey).toCharArray();
        
        int[] arr = new int[tmp.length];
        for(int i=0; i<tmp.length; i++) {
            arr[i] = tmp[i]-'0';
        }
        
        for(int i=arr.length-1; i>=0; i--) {    //뒤에서부터 탐색
            int lastNumber = arr[i];
            
            if(lastNumber == 10) {  //마지막 숫자가 10이되었을 경우
                if(i == 0) {
                    answer++;
                    continue;
                }
                arr[i - 1] += 1;    //앞자리 증가
                continue;
            }
            
            if(lastNumber > 5) {    //마지막 숫자가 5보다 크다면
                answer += 10-lastNumber;
                if(i == 0) {
                    answer++;
                    continue;
                }
                arr[i - 1] += 1;    //앞자리 증가
            } else if(lastNumber == 5) {    //마지막 숫자가 5라면
                if (i == 0) {
                    answer += 5;
                    continue;
                } else {    //앞자리가 남아있다면
                    if (arr[i - 1] < 5) {
                        answer += lastNumber;
                    } else {
                        answer += 5;
                        arr[i - 1]++;
                    }
                }
            } else {    //마지막 숫자가 5보다 작다면
                answer += lastNumber;
            }
        }
        return answer;
    }
}