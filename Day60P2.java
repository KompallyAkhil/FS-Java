// /*
// Gopal would like to go on Tour, and planned a schedule.
// Airport authority has created a new way of issuing tickets.
// Gopal purchased a set of airline tickets, 
// each ticket contains the 'departure from' and 'arrival to'.

// Redesign the Gopal's tour schedule in an order.
// Gopal intially must begin his tour from BZA.
// Hence the tour schedule's start point should begin with BZA. 

// You are given a list of flight tickets which Gopal has purchased.
// Your task is to find out and return the tour schedule that has the least 
// lexical order. Gopal must use all the tickets once and only once.

// Note:
// ------
// If there are multiple valid schedules, you should return the schedule 
// that has the smallest lexical order when read as a single string. 
// For example, the schedule ["BZA", "LGA"] has a smaller lexical order 
// than ["BZA", "LGB"].

// All airports are represented by three capital letters.
// You may assume all tickets form at least one valid schedule.

// Input Format:
// -------------
// Single Line of tickets separated by comma, and each ticket separated by space, 
// Gopal's flight tickets.

// Output Format:
// --------------
// Print the schedule, which is smallest lexical order of tour schedule.

// Sample Input-1:
// ----------------
// DEL HYD,BZA DEL,BLR MAA,HYD BLR

// Sample Output-1:
// --------------------
// [BZA, DEL, HYD, BLR, MAA]

// Sample Input-2:
// ------------------
// BZA BLR,BZA CCU,BLR CCU,CCU BZA,CCU BLR

// Sample Output-2:
// ------------------
// [BZA, BLR, CCU, BZA, CCU, BLR]
import java.util.*;

public class Day60P2 {
    public static void dfs(String start, HashMap<String, PriorityQueue<String>> hm, List<String> result) {
        PriorityQueue<String> pq = hm.get(start);
        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            dfs(next, hm, result);
        }
        result.add(0, start); // Add to front to get the correct order
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
         HashMap<String, PriorityQueue<String>> hm = new HashMap<>();
        
        for (String i : s) {
            String[] split = i.trim().split(" ");
            hm.putIfAbsent(split[0], new PriorityQueue<>());
            hm.get(split[0]).offer(split[1]);
        }

        // ✅ Step 2: Use DFS to traverse and build the path
        List<String> result = new LinkedList<>();
        dfs("BZA", hm, result);

        // ✅ Step 3: Print result
        System.out.println(result);
        sc.close();
    }
}
