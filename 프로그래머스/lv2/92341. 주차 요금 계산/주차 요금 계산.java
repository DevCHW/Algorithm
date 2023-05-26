import java.util.*;
class Solution {
    class Car implements Comparable<Car>{
        int number;
        int price;
        
        Car(int number, int price) {
            this.number = number;
            this.price = price;
        }
        
        @Override
        public int compareTo(Car o) {
            return this.number - o.number;
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        // 차량번호, 주차시간
        Map<String, String> map = new HashMap<>();
        Map<String, String> tmpMap = new HashMap<>();
        
        
        for(int i=0; i<records.length; i++) {
            String[] arr = records[i].split(" ");
            //arr[0] => 입차시간, 출차시간
            //arr[1] => 차량번호
            //arr[2] => IN, OUT
            if(arr[2].equals("IN")) { //입차
                tmpMap.put(arr[1], arr[0]);    //들어간시간 저장
            } else { //출차
                String startParkingTime = tmpMap.get(arr[1]);
                String endParkingTime = arr[0];
                String parkingTime = calcParkingTime(startParkingTime, endParkingTime);

                String originParkingTime = map.getOrDefault(arr[1], "0");
                String plusParkingTime = String.valueOf(Integer.parseInt(originParkingTime) + Integer.parseInt(parkingTime));
                map.put(arr[1], plusParkingTime);
                tmpMap.remove(arr[1]);
            }
        }//end of for--
        
        
        //출차시간이 안들어온 차량에 대하여 주차시간 계산 2(map2에 대한 계산)
        for(String key : tmpMap.keySet()) {
                String parkingTime = calcParkingTime(tmpMap.get(key), "23:59");
                String originParkingTime = map.getOrDefault(key, "0");
                String plusParkingTime = String.valueOf(Integer.parseInt(originParkingTime) + Integer.parseInt(parkingTime));
            
                map.put(key, plusParkingTime);
        }//end of for--
        
        
        
        
        List<Car> answerList = new ArrayList<>();
        for(String key : map.keySet()) {
            int parkingTime = Integer.parseInt(map.get(key));
            
            // 기본시간 이하라면,
            if(parkingTime <= fees[0]) {
                answerList.add(new Car(Integer.parseInt(key), fees[1]));
            } else { // 기본시간을 넘기게 주차하였다면
                //fees[0] => 기본시간
                //fees[1] => 기본요금
                //fees[2] => 단위시간
                //fees[3] => 단위요금
                
                // 요금 계산 => 기본요금 + [(주차시간 - 기본시간) / 단위시간] * 단위요금
                
                
                int basePrice = fees[1]; //기본요금
                int parkingMinusBase = parkingTime - fees[0]; //주차시간 - 기본시간
                int standardTime = fees[2]; //단위시간
                int standardPrice = fees[3]; //단위요금
                
                if(parkingMinusBase % standardTime == 0) {
                    int price = basePrice + (parkingMinusBase / standardTime) * standardPrice;
                    answerList.add(new Car(Integer.parseInt(key), price));
                } else {
                    int price = basePrice + (int) Math.ceil((parkingMinusBase / (float)standardTime)) * standardPrice;
                    answerList.add(new Car(Integer.parseInt(key), price));
                }
            }
        }//end of for--
        
        Collections.sort(answerList);
        
        answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i).price;
        }
        
        return answer;
    }
    
    // 출차시간 - 입차시간 계산해서 (분)으로 변환하여 retun
    private String calcParkingTime(String startParkingTime, String endParkingTime) {
        
        String[] start = startParkingTime.split(":");
        String[] end =  endParkingTime.split(":");
        
        //start (분) 으로 변환
        int startMinute = (Integer.parseInt(start[0]) * 60) + Integer.parseInt(start[1]);
        int endMinute = (Integer.parseInt(end[0]) * 60) + Integer.parseInt(end[1]);
        int result = endMinute - startMinute;
        
        return String.valueOf(result);
    }
}