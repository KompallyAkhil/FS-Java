// “Live Scoreboard in Drone Racing League”
// Simple Description
// In a professional drone racing tournament, pilots’ scores change rapidly based on real-time race
// data.
// The league needs to constantly display the top K pilots ranked by score.
// Problem Statement
// Design a live leaderboard that efficiently maintains the top K pilots by their latest scores.
// Input Format
// List of (pilot_name, score) pairs
// Integer K (top K pilots)
// Example Input
// Output
// [("PilotY", 1200), ("PilotZ", 1100)]
// Test Cases
// 1. scores=[("A",10),("B",5),("C",20)], K=2 → [("C",20),("A",10)]
// 2. scores=[("Sky",500),("Cloud",450),("Storm",600)], K=1 → [("Storm",600)]
// 3. scores=[("P1",300),("P2",300),("P3",299)], K=2 → [("P1",300),("P2",300)]
// 4. scores=[("Solo",50)], K=1 → [("Solo",50)]
// Complexity
// Time: O(N log K)
// Space: O(K)
// scores = [("PilotX", 980), ("PilotY", 1200), ("PilotZ", 1100), ("PilotW", 1000)] K = 2
import java.util.*;
class Speed{
    String name;
    int score;
    Speed(String name , int score){
        this.name = name;
        this.score = score;
    }
}
public class SpecialQ1 {
    public static void main(String [] args){
        Queue<Speed> pq = new PriorityQueue<>(Collections.reverseOrder( (a,b) -> a.score == b.score ? a.name.compareTo(b.name) : a.score - b.score 
        ));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            String name = sc.next();
            int score = sc.nextInt();
            pq.add(new Speed(name,score));
            
        }
        while (k > 0) {
            Speed s = pq.poll();
            System.out.println(s.name + " " + s.score);
            k--;
        }
        sc.close();
    }
}
