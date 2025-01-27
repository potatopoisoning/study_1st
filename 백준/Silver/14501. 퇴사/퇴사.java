import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String args[]) throws IOException {
		/*
			상담원으로 일하고 있는 백준이는 퇴사를 하려고 한다.
			
			오늘부터 N+1일째 되는 날 퇴사를 하기 위해서, 남은 N일 동안 최대한 많은 상담을 하려고 한다.
			
			백준이는 비서에게 최대한 많은 상담을 잡으라고 부탁을 했고, 비서는 하루에 하나씩 서로 다른 사람의 상담을 잡아놓았다.
			
			각각의 상담은 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi로 이루어져 있다.
			
			N = 7인 경우에 다음과 같은 상담 일정표를 보자.
			
			 	1일	2일	3일	4일	5일	6일	7일
			Ti	3	5	1	1	2	4	2
			Pi	10	20	10	20	15	40	200
			
			1일에 잡혀있는 상담은 총 3일이 걸리며, 상담했을 때 받을 수 있는 금액은 10이다. 5일에 잡혀있는 상담은 총 2일이 걸리며, 받을 수 있는 금액은 15이다.
			
			상담을 하는데 필요한 기간은 1일보다 클 수 있기 때문에, 모든 상담을 할 수는 없다. 예를 들어서 1일에 상담을 하게 되면, 2일, 3일에 있는 상담은 할 수 없게 된다. 2일에 있는 상담을 하게 되면, 3, 4, 5, 6일에 잡혀있는 상담은 할 수 없다.
			
			또한, N+1일째에는 회사에 없기 때문에, 6, 7일에 있는 상담을 할 수 없다.
			
			퇴사 전에 할 수 있는 상담의 최대 이익은 1일, 4일, 5일에 있는 상담을 하는 것이며, 이때의 이익은 10+20+15=45이다.
			
			상담을 적절히 했을 때, 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 총 근무 가능 일수
		int N = Integer.parseInt(br.readLine());
		
		int[] T = new int[N];
		int[] P = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			// i번째 상담을 완료하는 데 걸리는 기간
			T[i] = Integer.parseInt(st.nextToken());
			// i번째 상담을 완료했을 때 받을 수 있는 금액
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		// // 1일에 일한 돈은 2일차에 누적되기 때문?
		int[] revenue = new int[N+1];

		for(int i = 0; i < N; i++) {
			
			if(i + T[i] <= N) {
				// max(revenue[i + T[i]], revenue[i] + P[i])는 revenue[i + T[i]]와 revenue[i] + P[i]를 비교하여 더 큰 값을 반환
				revenue[i + T[i]] = Math.max(revenue[i + T[i]], revenue[i] + P[i]);
			}
			
			// i일에 상담을 하지 않는 경우, 최대 수익은 그 전 날까지 얻은 수익과 같으므로 revenue[i+1]에 revenue[i] 값을 갱신합니다.
			revenue[i+1] = Math.max(revenue[i+1], revenue[i]);
		}
		System.out.println(revenue[N]);
    }
}