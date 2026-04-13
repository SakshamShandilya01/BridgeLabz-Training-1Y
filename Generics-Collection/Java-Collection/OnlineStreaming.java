import java.util.*;

public class OnlineStreaming {
    public static void main(String[] args) {

        List<String[]> movies = new ArrayList<>(); // {name, genre}
        Stack<String[]> history = new Stack<>();
        Set<String> genres = new HashSet<>();
        Queue<String[]> upNext = new LinkedList<>();

       
        movies.add(new String[]{"Avengers","Action"});
        movies.add(new String[]{"Titanic","Romance"});

       
        upNext.add(movies.get(0));
        upNext.add(movies.get(1));

       
        while(!upNext.isEmpty()) {
            String[] m = upNext.poll();
            history.push(m);
            genres.add(m[1]);
            System.out.println("Watched: " + m[0]);
        }

        
        System.out.println("Recommended:");
        for(String[] m : movies)
            if(genres.contains(m[1]))
                System.out.println(m[0]);
    }
}