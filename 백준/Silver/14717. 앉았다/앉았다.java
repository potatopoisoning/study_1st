import java.io.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DecimalFormat df = new DecimalFormat("0.000");
        
        String[] input = br.readLine().split(" ");
        int first_card = Integer.parseInt(input[0]); // 첫 번째 카드
        int second_card = Integer.parseInt(input[1]); // 두 번째 카드

        // 총 경우의 수 (18C2)
        int cases = 153; 
        // 승리 가능한 경우의 수
        int cnt = 0; 
        // 끗 족보 계산
        int target = (first_card + second_card) % 10; 

        if (first_card == second_card) {
            // 땡인 경우: 상대가 더 높은 땡을 만들 수 없는 경우 계산
            cnt = cases - (10 - first_card);
            System.out.println(df.format(cnt / (cases * 1.0)));
        } else {
            // 끗인 경우: 모든 카드 조합 탐색
            for (int i = 1; i <= 10; i++) {
                for (int j = i + 1; j <= 10; j++) {
                	// 상대방 카드 조합의 합
                    int sum = i + j; 
                    if (sum % 10 < target) { // 족보 비교
                        if (i == first_card || i == second_card || j == first_card || j == second_card) {
                        	// 영학이의 카드가 포함된 경우
                            cnt += 2; 
                        } else {
                        	// 영학이의 카드가 포함되지 않은 경우
                            cnt += 4; 
                        }
                    }
                }
            }
            System.out.println(df.format(cnt / (cases * 1.0)));
        }
    }
}
