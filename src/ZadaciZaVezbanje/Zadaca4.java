import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Period;
import java.util.StringTokenizer;

class Range {

    static long proveri(long N, long A, long B) {
        long halfway = (A + B) / 2;

        while( A <= B ){

            long solution = (long) Math.pow(halfway, 2) + sumOfDigits(halfway) + 200 * halfway;

            if ( solution < N ){
                A = halfway + 1;
            }else if ( solution == N ){
                return halfway;
            }else{
                B = halfway - 1;
            }
            halfway = (A + B)/2;
        }

        return -1;
    }

    static long sumOfDigits(long i) {
        long a = 0;

        while (i > 0) {
            a += i % 10;
            i /= 10;
        }

        return a;
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long res = proveri(N, A, B);
        System.out.println(res);

        br.close();

    }

}
