import java.util.*;

public class OnlineGaming {
    public static void main(String[] args) {

        Set<Integer> players = new HashSet<>(Arrays.asList(1,2,3)); // unique players
        Queue<int[]> matches = new LinkedList<>(); // {p1,p2}
        List<String> results = new ArrayList<>();
        TreeSet<int[]> scores = new TreeSet<>((a,b)->b[1]-a[1]); // sort desc

        // schedule matches
        matches.add(new int[]{1,2});
        matches.add(new int[]{2,3});

        // process matches
        while(!matches.isEmpty()) {
            int[] m = matches.poll();
            int winner = m[0]; // simple logic

            results.add("Winner: " + winner);
            scores.add(new int[]{winner, winner*10}); // score
        }

        // leaderboard
        System.out.println("Leaderboard:");
        for(int[] s : scores)
            System.out.println("Player " + s[0] + " Score " + s[1]);
    }
}