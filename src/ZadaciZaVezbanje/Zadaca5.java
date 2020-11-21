import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Bus {

    public static MaxAndMinPrice returnMaxAndMin(int vozrasni, int deca) {
        if (deca == 0 || deca == 1) return new MaxAndMinPrice(vozrasni * 100, vozrasni * 100);
        int minSum = 0;
        if (vozrasni >= deca) {
            minSum = vozrasni * 100;
        } else {
            minSum = deca * 100;
        }
        return new MaxAndMinPrice(minSum, (vozrasni + deca - 1) * 100);
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        System.out.println(returnMaxAndMin(N, M).getMin());
        System.out.println(returnMaxAndMin(N, M).getMax());
    }

}

class MaxAndMinPrice {
    private int min;
    private int max;

    public MaxAndMinPrice(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}