import java.io.*;
import java.util.*;

public class Main {
    static class Room {
        int level;
        int cnt;
        List<Player> players = new ArrayList<>();

        public Room (int l, String n) {
            this.level = l;
            this.cnt = 1;
            players.add(new Player(l, n));
        }
    }

    static class Player implements Comparable<Player> {
        int level;
        String nickname;

        public Player (int l, String n) {
            this.level = l;
            this.nickname = n;
        }

        @Override
        public int compareTo(Player o) {
            return this.nickname.compareTo(o.nickname);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken()); // 플레이어의 수
        int m = Integer.parseInt(st.nextToken()); // 방의 정원

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()); // 현재 플레이어의 레벨
            String n = st.nextToken(); // 현재 플레이어의 닉네임

            boolean isEnter = false;
            for (Room room : rooms) {
                if (room.level - 10 <= l && l <= room.level + 10 && room.cnt < m) {
                    room.cnt++;
                    room.players.add(new Player(l, n));
                    isEnter = true;
                    break;
                }
            }

            if (!isEnter) {
                rooms.add(new Room(l, n));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            if (room.cnt == m) sb.append("Started!");
            else sb.append("Waiting!");

            sb.append('\n');
            Collections.sort(room.players);
            for (Player player : room.players) {
                sb.append(player.level).append(" ").append(player.nickname).append('\n');
            }
        }

        System.out.println(sb);
    }
}