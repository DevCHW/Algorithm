import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        int len = numbers.length;
        String[] arr = new String[len];
        
        for(int i=0; i<len; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));
        
        if (arr[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String x : arr) {
            sb.append(x);
        }
        
        return sb.toString();
    }
}