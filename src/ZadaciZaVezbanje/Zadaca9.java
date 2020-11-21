import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Stack;


class card_trick {
    public static int count(int N) {
        int counter = 0;
        Queue<Integer> cardsQueue = new ArrayDeque<>();
        for (int i = 1; i <= 51; i++) {
            cardsQueue.add(i);
        }

        Stack<Integer> firstSevenElements = new Stack<>();
        while (true) {
            if (cardsQueue.peek() == N) return counter;
            for (int i = 0; i < 7; i++) {
                firstSevenElements.push(cardsQueue.poll());
            }

            for (int i = 0; i < 7; i++) {
                cardsQueue.add(firstSevenElements.pop());
                cardsQueue.add(cardsQueue.poll());
            }
            counter++;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        System.out.println(count(Integer.parseInt(br.readLine())));
    }
}
