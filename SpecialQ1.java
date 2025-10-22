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
