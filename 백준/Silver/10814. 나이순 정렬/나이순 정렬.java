import java.util.*;

public class Main {
    static class Person implements Comparable<Person>{
        int age;
        String name;
        int sequence;

        Person(int age, String name, int sequence) {
            this.age = age;
            this.name = name;
            this.sequence = sequence;
        }

        @Override
        public int compareTo(Person o) {
            if(this.age == o.age) return this.sequence - o.sequence;
            return this.age - o.age;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Person> people = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            people.add(new Person(age, name, i));
        }

        System.out.print(solution(n, people));
    }

    private static String solution(int n, List<Person> people) {
        StringBuilder sb = new StringBuilder();
        Collections.sort(people);
        int len = people.size();
        int count = 0;
        for(Person person : people) {
            count++;
            sb.append(person.age)
                    .append(" ")
                    .append(person.name);

            if(count != len) sb.append("\n");
        }

        return sb.toString();
    }
}
