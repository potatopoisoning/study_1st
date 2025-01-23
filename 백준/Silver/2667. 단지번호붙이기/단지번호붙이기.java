import java.io.*;
import java.util.*;

public class Main {
	
	/*
		<그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 
		철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 
		여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. 
		<그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
		
		첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
		
		첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
	 */
	
	static int[][] danji;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static List<Integer> result;
	static int cnt, N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		result = new LinkedList<>(); 
		N = Integer.parseInt(br.readLine());
		danji = new int[N][N];
		visited = new boolean[N][N]; //단지에 속해있는지
		cnt = 1; //기준이 아파트(단지로 묶일 첫 아파트)가 포함될 때니 1로 초기화
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				danji[i][j] = str.charAt(j)-'0';
			}
		}
		
		
		for(int x=0;x<N;x++) {
			for(int y=0;y<N;y++) {
				if(danji[x][y]==1 && !visited[x][y]) {
					dfs(x,y);
					result.add(cnt);
					cnt = 1;
				}
			}
		}
		
		Collections.sort(result);
		
		bw.write(result.size()+"\n");
		for(int r : result) bw.write(r+"\n");
		bw.flush();
		bw.close();

	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int nx = dx[i]+x;
			int ny = dy[i]+y;
			
			if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny] && danji[nx][ny]==1) {
				cnt++;
				dfs(nx,ny);
			}
		}
	}
}