import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		/*
			왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 
			일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.
			
			아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 
			뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
			
			아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
		*/

		Scanner sc = new Scanner(System.in);
        
		int[] dwarfs = new int[9];
		int sum = 0;
		int dwarf1 = 0; 
		int dwarf2 = 0;
		
		// 난쟁이들의 키의 합 구하기
		for(int i = 0; i < dwarfs.length; i++) {
			dwarfs[i] = sc.nextInt();
			sum += dwarfs[i];
		}
		
		// 키 오름차순 정렬
		Arrays.sort(dwarfs);
		
		// 가짜 난쟁이 찾기
		for(int i = 0; i < 9; i++) {
			for(int j = i + 1; j < 9; j++) {
				if(sum - dwarfs[i] - dwarfs[j] == 100) {
					dwarf1 = i;
					dwarf2 = j;
					break;
				}
			}
		}
        
		for(int i = 0; i < dwarfs.length; i++) {
			// 가짜 난쟁이는 빼고 출력
			if(i == dwarf1 || i == dwarf2) {
				continue;
			}
			System.out.println(dwarfs[i]);
		}
		
		sc.close();
	}
}