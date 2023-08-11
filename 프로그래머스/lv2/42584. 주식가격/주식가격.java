class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++) {
            
            int price1 = prices[i];
            
            // print("price1 = " +price1);
            int day = 0;
            
            for(int j=i+1; j<len; j++) {
                int price2 = prices[j];
                
                // print("price2 = " + price2);
                // print("day = " + day);
                
                if (price2 < price1) { //가격이 떨어진 날
                    day++;
                    answer[i] = day;
                    break;
                } else { //가격이 안떨어진 날
                    day++;
                }
                
                if(j == len-1) {
                    answer[i] = day;
                }
            }
        }
        
        return answer;
    }
    
    
    
    // 프린트
    private void print(String str) {
        System.out.println(str);
    }
    
    private void print(int number) {
        System.out.println(number);
    }
}