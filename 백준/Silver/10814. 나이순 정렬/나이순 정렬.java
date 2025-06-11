import java.io.*;
import java.util.*;

public class Main {
    static class User implements Comparable<User> {
        int age;
        String name;
        int date;

        User (int age, String name, int date) {
            this.age = age;
            this.name = name;
            this.date = date;
        }

        @Override
        public int compareTo(User o) {
            if (this.age == o.age) return this.date - o.date;
            return this.age - o.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        User[] arr = new User[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new User(Integer.parseInt(st.nextToken()), st.nextToken(), i);
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i].age).append(" ").append(arr[i].name).append('\n');
        }

        System.out.print(sb);
    }
}