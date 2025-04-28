/*
There are N cities, and M routes[], each route is a path between two cities.
routes[i] = [city1, city2], there is a travel route between city1 and city2.
Each city is numbered from 0 to N-1.
 
There are one or more Regions formed among N cities. 
A Region is formed in such way that you can travel between any two cities 
in the region that are connected directly and indirectly.
 
Your task is to findout the number of regions formed between N cities. 
 
Input Format:
-------------
Line-1: Two space separated integers N and M, number of cities and routes
Next M lines: Two space separated integers city1, city2.
 
Output Format:
--------------
Print an integer, number of regions formed.
 
 
Sample Input-1:
---------------
5 4
0 1
0 2
1 2
3 4
 
Sample Output-1:
----------------
2
 
 
Sample Input-2:
---------------
5 6
0 1
0 2
2 3
1 2
1 4
2 4
 
Sample Output-2:
----------------
1
 
Note: Look HINT for explanation.
*/
import java.util.*;
public class Day29P3 {
    static int [] parent;
    public static void initialize(int n){
        parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
    }
    public static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public static void union(int x,int y){
        int px = find(x);
        int py = find(y);
        if(px == py) return;
        if(px < py) parent[py] = px;
        else parent[px] = py;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  
        int m = sc.nextInt();
        initialize(n);
        for (int i = 0; i < m; i++) {
            int city1 = sc.nextInt();
            int city2 = sc.nextInt();
            union(city1, city2);
        }
        Set<Integer> region = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            region.add(find(i));
        }
        System.out.println(region.size());
        sc.close();
    }
}
