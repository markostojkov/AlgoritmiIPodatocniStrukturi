import java.io.BufferedReader;
import java.io.InputStreamReader;

enum NumberSign {
    Positive, Negative, Zero
}

class ZigZagSequence {

    static int najdiNajdolgaCikCak(int a[]) {
        int longestZigZag = 0;
        int currentZigZag = 0;

        for (int i = 0; i < a.length - 1; i++) {
            NumberSign currentSign = getSign(a[i]);
            NumberSign nextSign = getSign(a[i + 1]);

            if (currentSign != nextSign && (currentSign != NumberSign.Zero && nextSign != NumberSign.Zero)) {
                currentZigZag++;
                if (currentZigZag > longestZigZag) {
                    longestZigZag = currentZigZag;
                }
            } else {
                if (currentZigZag > longestZigZag) {
                    longestZigZag = currentZigZag;
                }
                currentZigZag = 0;
            }
        }

        return longestZigZag + 1;
    }

    public static NumberSign getSign(int a) {
        if (a > 0) {
            return NumberSign.Positive;
        } else if (a < 0) {
            return NumberSign.Negative;
        }
        return NumberSign.Zero;
    }

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        for (i = 0; i < N; i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);

        br.close();

    }

}
