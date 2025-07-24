/*
There are N cities in a state.
The cities are connected with two types of roadways:
1) concrete roadway 2) asphalt roadway.
The roadways may be parallel.

You are given the lists of concrete roadways and asphalt roadways
between the cities. All roadways are unidirectional.
Concrete_Roadway[i,j] indiactes: a concrete road from city-i to city-j. Similarly,
Asphalt[i,j] indiactes: an asphalt road from city-i to city-j. Similarly,

Your task is to find and return the list of lengths of the shortest paths from 
city-0 to city-P, where P start from 0 to N-1. And the path should contains 
alternative roadways like as follows: concrete - asphalt - concrete -asphalt --etc
or vice versa. If there is no such shortest path exist print -1.

Input Format:
-------------
Line-1: 3 space separated integers N, C & A, Number of cities, routes between the cities.
		number of concrete roads and number of asphalt roads
Next C lines: Two space separated integers, concrete road between city-i to city-j.		
Next A lines: Two space separated integers, asphalt road between city-i to city-j.		

Output Format:
--------------
Print the list of lengths, the shortest paths.


Sample Input-1:
---------------
4 2 1
0 1
2 3
1 2

Sample Output-1:
----------------
0 1 2 3

Sample Input-2:
---------------
4 2 1
1 0
2 3
1 2

Sample Output-2:
----------------
0 -1 -1 -1


Sample Input-3:
---------------
4 3 2
1 0
1 2
2 3
0 1
1 2

Sample Output-3:
----------------
0 1 2 -1
*/
import java.util.*;
public class Day76P1 {
	 public static List<Integer> findShortestPaths(int N, int C, int A, int[][] concrete, int[][] asphalt) {
        List<Integer>[] concreteGraph = new ArrayList[N];
        List<Integer>[] asphaltGraph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            concreteGraph[i] = new ArrayList<>();
            asphaltGraph[i] = new ArrayList<>();
        }

        for (int[] road : concrete) {
            concreteGraph[road[0]].add(road[1]);
        }
        for (int[] road : asphalt) {
            asphaltGraph[road[0]].add(road[1]);
        }

        int[] result = new int[N];
        Arrays.fill(result, -1);
        result[0] = 0; 

        boolean[][] visited = new boolean[N][2];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0}); 
        queue.offer(new int[]{0, 1, 0}); 
        visited[0][0] = true;
        visited[0][1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int lastType = current[1];
            int dist = current[2];

            if (result[node] == -1) {
                result[node] = dist;
            } else {
                result[node] = Math.min(result[node], dist);
            }

            List<Integer>[] nextGraph = (lastType == 0) ? asphaltGraph : concreteGraph;
            int nextType = 1 - lastType;

            for (int neighbor : nextGraph[node]) {
                if (!visited[neighbor][nextType]) {
                    visited[neighbor][nextType] = true;
                    queue.offer(new int[]{neighbor, nextType, dist + 1});
                }
            }
        }

        List<Integer> output = new ArrayList<>();
        for (int val : result) output.add(val);
        return output;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int A = sc.nextInt();
        int [][] concrete = new int [C][2];
        int [][] asphalt = new int [A][2];
        for(int i = 0 ; i < C ; i++){
            concrete[i][0] = sc.nextInt();
            concrete[i][1] = sc.nextInt();
        }
        for(int i = 0 ; i < A ; i++){
            asphalt[i][0] = sc.nextInt();
            asphalt[i][1] = sc.nextInt();
        }
        List<Integer> res = findShortestPaths(N,C,A,concrete,asphalt);
        System.out.println(res);
        sc.close();
    } 
}