import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class PostFixEvaluation {

    public static int calculateExpression(char[] charCalculation) {
        Stack<Integer> stackOfValues = new Stack<>();
        String number = "";

        for (int i = 0; i < charCalculation.length; i++) {

            if (Character.isDigit(charCalculation[i])) {
                number += charCalculation[i];

                if (Character.isDigit(charCalculation[i + 1])) {
                    continue;
                } else {
                    stackOfValues.push(Integer.parseInt(number));
                    number = "";
                }

            } else if (!Character.isSpaceChar(charCalculation[i])) {
                int value1 = stackOfValues.pop();
                int value2 = stackOfValues.pop();

                switch (charCalculation[i]) {
                    case '+':
                        stackOfValues.push(value2 + value1);
                        break;
                    case '-':
                        stackOfValues.push(value2 - value1);
                        break;
                    case '*':
                        stackOfValues.push(value2 * value1);
                        break;
                    case '/':
                        stackOfValues.push(value2 / value1);
                        break;
                }
            }
        }

        return stackOfValues.pop();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        System.out.println(calculateExpression(exp));
        br.close();
    }
}
