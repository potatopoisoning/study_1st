import java.io.*;
import java.util.*;

public class Main {
	
	/*
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 
정점 번호는 1번부터 N번까지이다.

첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 
입력으로 주어지는 간선은 양방향이다.

첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
	 */
 
	static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 시작 정점 번호
		
        graph = new int[N+1][N+1];

        // 간선 정보 입력
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        // node가 1부터 시작하기 때문에 N + 1
        // DFS 수행
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        // BFS 수행
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println();
	}
    
    private static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        if(v == graph.length) return;

        for(int j = 1; j < graph.length; j++) {
        	// 연결된 노드인데 방문하지 않은 경우 
            if(graph[v][j] == 1 && visited[j] == false) {
            	// 연결된 노드 찾으면 재귀함수 호출
                dfs(j);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(v);
        visited[v] = true;

        System.out.print(v + " ");

        while(!queue.isEmpty()) {
            int n = queue.poll();

			// 노드 하나로 연결된 노드 먼저 다 체크 
            for(int i = 1; i < graph.length; i++) {
           		 // 연결된 노드인데 방문하지 않은 경우 
                if(graph[n][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    System.out.print(i + " ");
                    queue.offer(i);
                }
            }
        }   
    }
}