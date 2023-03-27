class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = s.split(" ");
        for(int i=0; i<arr.length; i++) {
            if(arr[i].length() == 0) continue;
            else {
                String tmp1 = arr[i].substring(0,1);
                String tmp2 = arr[i].substring(1);
                arr[i] = tmp1.toUpperCase() +tmp2.toLowerCase();
            }
        }
        
        answer = String.join(" ", arr);
        if(s.charAt(s.length()-1) == ' ') return answer + " ";
        return answer;
    }
}