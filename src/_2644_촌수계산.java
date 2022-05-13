import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _2644_촌수계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]), d = Integer.parseInt(input[1]), m =  Integer.parseInt(br.readLine());
        boolean[][] graph = new boolean[101][101];

        for(int i = 0; i < m; i++){
            input = br.readLine().split(" ");
            graph[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = true;
            graph[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = true;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        int[] visited = new int[101];
        visited[s]++;
        while(!q.isEmpty()){
            int f = q.poll();
            for(int i = 1; i <= n; i++){
                if(graph[f][i] && visited[i] == 0){
                    q.add(i);
                    visited[i] = visited[f] + 1;
                }
            }
        }
        System.out.println(visited[d] == 0 ? -1 :visited[d] - 1);
    }
}
