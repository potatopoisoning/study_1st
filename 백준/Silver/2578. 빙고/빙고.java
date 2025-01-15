import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String args[]) throws IOException {
		/*
			빙고 게임은 다음과 같은 방식으로 이루어진다.
			
			먼저 아래와 같이 25개의 칸으로 이루어진 빙고판에 1부터 25까지 자연수를 한 칸에 하나씩 쓴다.
			
			선이 세 개 이상 그어지는 순간 "빙고"라고 외치는데, 가장 먼저 외치는 사람이 게임의 승자가 된다.
			
			철수는 친구들과 빙고 게임을 하고 있다. 
			철수가 빙고판에 쓴 수들과 사회자가 부르는 수의 순서가 주어질 때, 사회자가 몇 번째 수를 부른 후 철수가 "빙고"를 외치게 되는지를 출력하는 프로그램을 작성하시오.
			
			첫째 줄부터 다섯째 줄까지 빙고판에 쓰여진 수가 가장 위 가로줄부터 차례대로 한 줄에 다섯 개씩 빈 칸을 사이에 두고 주어진다. 
			여섯째 줄부터 열째 줄까지 사회자가 부르는 수가 차례대로 한 줄에 다섯 개씩 빈 칸을 사이에 두고 주어진다. 빙고판에 쓰여진 수와 사회자가 부르는 수는 각각 1부터 25까지의 수가 한 번씩 사용된다.
			
			첫째 줄에 사회자가 몇 번째 수를 부른 후 철수가 "빙고"를 외치게 되는지 출력한다.
		*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[5][5];
        Map<Integer, int[]> numberPosition = new HashMap<>();
        
        // 빙고판 입력과 숫자 위치 저장
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                numberPosition.put(num, new int[]{i, j});
            }
        }

        int[] calledNumbers = new int[25];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                calledNumbers[i * 5 + j] = Integer.parseInt(st.nextToken());
            }
        }

        int bingoCount = 0;
        int result = 0;

        // 부른 숫자 처리
        for (int i = 0; i < 25; i++) {
            int number = calledNumbers[i];
            int[] position = numberPosition.get(number);

            // 해당 숫자를 마크
            board[position[0]][position[1]] = 0;

            // 빙고 개수 체크
            bingoCount = checkBingo(board);
            if (bingoCount >= 3) {
                result = i + 1;
                break;
            }
        }

        System.out.println(result);
    }
    
	public static int checkBingo(int[][] board) {
        int count = 0;

        // 가로, 세로 체크
        for (int i = 0; i < 5; i++) {
            if (isBingoLine(board[i])) count++; // 가로
            if (isBingoLine(new int[]{board[0][i], board[1][i], board[2][i], board[3][i], board[4][i]})) count++; // 세로
        }

        // 대각선 체크
        if (isBingoLine(new int[]{board[0][0], board[1][1], board[2][2], board[3][3], board[4][4]})) count++;
        if (isBingoLine(new int[]{board[0][4], board[1][3], board[2][2], board[3][1], board[4][0]})) count++;

        return count;
    }

    public static boolean isBingoLine(int[] line) {
        for (int num : line) {
            if (num != 0) return false;
        }
        return true;
    }
}