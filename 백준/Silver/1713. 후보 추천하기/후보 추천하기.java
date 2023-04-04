import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //사진틀의 개수
        int k = sc.nextInt();   //추천 횟수
        int[] arr = new int[k];
        for(int i=0; i<k; i++) arr[i] = sc.nextInt();

        for (int x : solution(n, k, arr)) {
            System.out.print(x + " ");
        }
    }

    private static int[] solution(int n, int k, int[] arr) {
        int[] answer = {};

        //순서를 보장하고, 추천받은 학생번호와 추천횟수를 기록할 수 있는 LinkedHashMap 사용
        Map<Integer, Integer> photos = new LinkedHashMap<>();

        for(int i=0; i<k; i++) {
            if(photos.size() >= n) { //사진첩 용량 초과
                if(!photos.containsKey(arr[i])) {   //사진첩에 이미 게시되어있는 학생이 아니라면,
                    int min_like = Integer.MAX_VALUE;   //가장 적은 추천수 기록
                    int number = 0; //학생 번호 기록
                    for (Integer key : photos.keySet()) {
                        if(photos.get(key) < min_like) {
                            min_like = photos.get(key);
                            number = key;
                        }
                    }
                    photos.remove(number);  //가장 적은 추천수를 받은 학생 삭제
                }
                photos.put(arr[i], photos.getOrDefault(arr[i], 0) + 1);
            } else { //사진첩 용량 허용
                photos.put(arr[i], photos.getOrDefault(arr[i], 0) + 1);
            }
        }
        answer = new int[photos.size()];
        int idx = 0;
        for(Integer number : photos.keySet()) {
            answer[idx] = number;
            idx++;
        }
        Arrays.sort(answer);
        return answer;
    }


}
