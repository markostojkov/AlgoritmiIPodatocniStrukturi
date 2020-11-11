import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class CheckXML {

    public static int parseXmlForValidation(String[] rows) {
        int codeIsValid = 1;
        Stack<String> stackOfXmls = new Stack<>();

        for (String row: rows) {
            if (row.substring(0, 2).equalsIgnoreCase("[/")) {
                String xmlCode = stackOfXmls.pop();

                if (!xmlCode.equalsIgnoreCase(row.charAt(0) + row.substring(2))) {
                    return 0;
                }

            } else if (row.charAt(0) == '[') {
                stackOfXmls.push(row);
            }
        }

        return codeIsValid;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String [] redovi = new String[n];

        for(int i=0;i<n;i++)
            redovi[i] = br.readLine();

        System.out.println(parseXmlForValidation(redovi));
        br.close();
    }
}