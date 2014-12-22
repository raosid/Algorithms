import java.util.Scanner;

/**
 * Created by sidrao on 12/22/14.
 */
public class TestingClient {
    public static void main(String[] args) {
        StackOfStrings testStack = new StackOfStrings();
        Scanner console = new Scanner(System.in);

        String line = console.nextLine(); // "-" for pop

        testStack(line, testStack);
    }

    private static void testStack(String line, StackOfStrings test) {
        Scanner lineScanner = new Scanner(line);
        while (lineScanner.hasNext()) {
            String token = lineScanner.next();
            if (token.equals("-")) {
                test.pop();
            } else {
                test.push(token);
            }
            System.out.println(test);
        }
    }

}
