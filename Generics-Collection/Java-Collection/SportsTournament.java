import java.util.*;

public class SportsTournament {
    public static void main(String[] args) {

        Set<Integer> teams = new HashSet<>(Arrays.asList(1,2,3));
        Queue<int[]> matches = new LinkedList<>(); // {team1, team2}
        List<String> results = new ArrayList<>();
        TreeSet<int[]> rank = new TreeSet<>((a,b)->b[1]-a[1]); // sort by points

        
        matches.add(new int[]{1,2});
        matches.add(new int[]{2,3});


        while(!matches.isEmpty()) {
            int[] m = matches.poll();
            int winner = m[0]; // simple logic

            results.add("Winner: " + winner);
            rank.add(new int[]{winner, winner*10}); // points
        }

       
        System.out.println("Leaderboard:");
        for(int[] r : rank)
            System.out.println("Team " + r[0] + " Points " + r[1]);
    }
}