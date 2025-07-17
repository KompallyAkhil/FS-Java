
import java.util.*;

public class Day73P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int R = sc.nextInt();
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new HashSet<>());
        }
        for (int i = 0; i < R; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int maxScore = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int score = graph.get(i).size() + graph.get(j).size();
                if(graph.get(i).contains(j)) {
                    score--;
                }
                maxScore = Math.max(maxScore, score);
            }
        }
        System.out.println(maxScore);
        sc.close();
    }
}
