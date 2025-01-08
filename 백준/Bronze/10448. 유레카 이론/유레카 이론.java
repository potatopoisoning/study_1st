import java.io.*;

public class Main
{
	static int[] tn = new int[45];

    public static void triangular_number(){
    	
        for(int i = 1; i < 45; i++){
        	tn[i] = i * ( i + 1 ) / 2;
        }
    }

    public static int eureka(int num){
    	
        for(int i = 1; i < 45; i++){
            for(int j = 1; j < 45; j++){
                for(int k = 1; k < 45; k++){
                    if(tn[i] + tn[j] + tn[k] == num) {
                    	return 1;
                    }
                }
            }
        }
        return 0;
    }
	
	public static void main(String[] args) throws Exception
	{
		/*
			삼각수 Tn(n ≥ 1)는 [그림]에서와 같이 기하학적으로 일정한 모양의 규칙을 갖는 점들의 모음으로 표현될 수 있다.
			
			자연수 n에 대해 n ≥ 1의 삼각수 Tn는 명백한 공식이 있다.
			
			Tn = 1 + 2 + 3 + ... + n = n(n+1)/2
			
			1796년, 가우스는 모든 자연수가 최대 3개의 삼각수의 합으로 표현될 수 있다고 증명하였다. 예를 들어,
			
			4 = T1 + T2
			5 = T1 + T1 + T2
			6 = T2 + T2 or 6 = T3
			10 = T1 + T2 + T3 or 10 = T4
			이 결과는 증명을 기념하기 위해 그의 다이어리에 “Eureka! num = Δ + Δ + Δ” 라고 적은것에서 유레카 이론으로 알려졌다. 
			꿍은 몇몇 자연수가 정확히 3개의 삼각수의 합으로 표현될 수 있는지 궁금해졌다. 
			위의 예시에서, 5와 10은 정확히 3개의 삼각수의 합으로 표현될 수 있지만 4와 6은 그렇지 않다.
			
			자연수가 주어졌을 때, 그 정수가 정확히 3개의 삼각수의 합으로 표현될 수 있는지 없는지를 판단해주는 프로그램을 만들어라. 
			단, 3개의 삼각수가 모두 달라야 할 필요는 없다.
		*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        triangular_number();

        for(int t=0; t<N; t++){
            int num = Integer.parseInt(br.readLine());
            int result = eureka(num);
            sb.append(result).append('\n');
        }
        
        System.out.println(sb.toString());
	}
}