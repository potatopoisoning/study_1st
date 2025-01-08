import java.io.*;

public class Main {

	static int[] tn = new int[45];

    public static void triangular_number(){
        for(int i = 1; i < 45; i++){
        	tn[i] = i * ( i + 1 ) / 2;
        }
    }

    public static int eureka(int N){
        for(int i = 1; i < 45; i++){
            for(int j = 1; j < 45; j++){
                for(int k = 1; k < 45; k++){
                    if(tn[i] + tn[j] + tn[k] == N) {
                    	return 1;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        triangular_number();

        for(int t=0; t<N; t++){
            int num = Integer.parseInt(br.readLine());
            int result = eureka(num);
            System.out.println(result);
        }
    }
}