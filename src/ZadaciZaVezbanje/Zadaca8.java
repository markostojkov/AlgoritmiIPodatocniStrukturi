import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class ExpressionEvaluator {

    public static int evaluateExpression(String expression){
        int result = 0;
        List<Integer> numbersArray = new ArrayList<>();
        List<Character> operationsArray = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder();

        for (char c: expression.toCharArray()) {
            if (c == '+' || c == '*') {
                operationsArray.add(c);
                numbersArray.add(Integer.valueOf(currentNumber.toString()));
                currentNumber = new StringBuilder();
            } else {
                currentNumber.append(c);
            }
        }
        numbersArray.add(Integer.valueOf(currentNumber.toString()));


        for (int i = 0; i < operationsArray.size(); i++) {
            if (operationsArray.get(i) == '*') {
                result = numbersArray.get(i) * numbersArray.get(i + 1);

                numbersArray.set(i, 0);
                numbersArray.set(i + 1, result);
            }
        }

        return numbersArray.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}