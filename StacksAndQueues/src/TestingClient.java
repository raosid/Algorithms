import java.util.Scanner;

/**
 * Created by sidrao on 12/22/14.
 * A simple testing client for StackOfString.
 */
public class TestingClient {
    public static void main(String[] args) {
        ResizingArrayStackOfStrings testStack = new ResizingArrayStackOfStrings();
        Scanner console = new Scanner(System.in);

        String line = console.nextLine(); // "-" for pop

        testStack(line, testStack);
    }

    private static void testStack(String line, ResizingArrayStackOfStrings test) {
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
