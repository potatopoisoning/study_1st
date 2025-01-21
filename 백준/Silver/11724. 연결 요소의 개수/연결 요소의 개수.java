import java.io.*;
import java.util.*;

public class Main {
	
	/*
		방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

		첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. 
		(1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. 
		(1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

		첫째 줄에 연결 요소의 개수를 출력한다.
	 */
	
    static int n, m;
    static int[][] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        visit = new boolean[n + 1];
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                DFS(i);
                answer++;
            }
        }
        System.out.println(answer);
    }
    
    public static void DFS(int v) {
        if (visit[v]) return;
        else {
            visit[v] = true;
            for (int i = 1; i <= n; i++) {
                if (arr[v][i] == 1) DFS(i);

            }
        }
    }
}