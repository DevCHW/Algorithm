import java.util.*;
class Person implements Comparable<Person>{
    int num;
    int time;
    Person(int num, int time) {
        this.num = num;
        this.time = time;
    }

    @Override
    public int compareTo(Person o) {
        if(this.time == o.time) return this.num - o.num;
        return this.time - o.time;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Person> personList = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            int num = i;
            int time = sc.nextInt();
            personList.add(new Person(num, time));
        }

        System.out.println(solution(n, personList));
    }

    private static int solution(int n, List<Person> personList) {
        int answer = 0;
        int tmp = 0;
//        1 2 3 3 4
        Collections.sort(personList);
        for(int i=0; i<n; i++) {
            tmp += personList.get(i).time;
            answer += tmp;
        }
        return answer;
    }
}