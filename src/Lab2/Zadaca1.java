package Lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Array<E> {

    public static void main(String[] args) throws IOException{
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);

        ArrayClass niza = new ArrayClass(N);
        for (int i = 0; i < N; i++) {
            s=stdin.readLine();
            niza.set(i, Integer.parseInt(s));
        }

        System.out.println(niza.brojDoProsek());
    }



}

class ArrayClass {
    private final int arrayLength;
    private final int[] array;
    private int sumaNaArray;

    ArrayClass(int N) {
        this.arrayLength = N;
        this.array = new int[N];
        this.sumaNaArray = 0;
    }

    public void set(int position, int value) {
        if (position < this.arrayLength) {
            this.array[position] = value;
            this.sumaNaArray += value;
        }
    }

    public int min() {
        int min = this.get(0);

        for (int i = 0; i < this.arrayLength; i++) {
            if (min > this.get(i)) {
                min = this.get(i);
            }
        }

        return min;
    }

    public int max() {
        int max = this.get(0);

        for (int i = 0; i < this.arrayLength; i++) {
            if (max < this.get(i)) {
                max = this.get(i);
            }
        }

        return max;
    }

    public int get(int position) {
        return this.array[position];
    }

    public int getByProsekValue(double value) {
        int smallerNumber = this.min();
        int biggerNumber = this.max();

        for (int i = 0; i < this.arrayLength; i++) {
            int currentNumber = this.get(i);

            if ((int)value == currentNumber) {
                return currentNumber;
            }

            if (value > currentNumber && (value - currentNumber < value - smallerNumber)) {
                smallerNumber = currentNumber;
            }

            if (value < currentNumber && (currentNumber - value < biggerNumber - value)) {
                biggerNumber = currentNumber;
            }
        }

        return this.closestToProsek(smallerNumber, biggerNumber, value);
    }

    public int closestToProsek(int smallerNumber, int biggerNumber, double value) {
        double smallerProsek = value - smallerNumber;
        double biggerProsek = biggerNumber - value;

        if (smallerProsek <= biggerProsek) {
            return smallerNumber;
        }

        return biggerNumber;
    }

    public int getArrayLength() {
        return this.arrayLength;
    }

    public double getProsek() {
        return this.sumaNaArray * 1.0 / this.arrayLength;
    }

    public int brojDoProsek() {
        double prosek = this.getProsek();
        return this.getByProsekValue(prosek);
    }
}