class Solution {
    // System.out.println("");
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int total_deliveries = 0;
        int total_pickups = 0;

        // 항상 최대치를 실어서 맨 끝으로 온다고 가정.
        for(int i=n-1; i>=0; i--) {
            int distance = i+1; //물류창고부터의 거리
            
            //항상 최대치 배달, 최대치 수거
            while(total_deliveries < deliveries[i] || total_pickups < pickups[i]) { 
                total_deliveries += cap;
                total_pickups += cap;
                
                answer += distance*2; //왔다갔다 거리 answer에 누적
            }// end of while--
            
            total_deliveries -= deliveries[i];
            total_pickups -= pickups[i];
            
            // System.out.println("============================");
            // System.out.println((i+1)+"거리의 집에서 = " + tmp + "만큼 거리가 늘어났음");
            // System.out.println("tmp_delivery =" +total_deliveries);
            // System.out.println("tmp_pickups =" +total_pickups);
            // System.out.println("============================");
            
        }//end of for--
        return answer;
    }
}