import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfAbsoluteDifferences {

    static int solve(int numbers[], int N, int K) {

        int [][]num=new int[N][K];
        int max=0;
        for(int i=0;i<N;i++){
            for(int j=1;j<K;j++){
                for(int n=0;n<i;n++){
                    num[i][j]=Math.max(num[i][j], num[n][j-1]+Math.abs(numbers[i]-numbers[n]));
                    max=Math.max(max,num[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int numbers[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (i=0;i<N;i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int res = solve(numbers, N, K);
        System.out.println(res);

        br.close();

    }

}