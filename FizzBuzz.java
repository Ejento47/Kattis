import java.io.*;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input = br.readLine();
        String[] value = input.split(" ");
        int x = Integer.parseInt(value[0]);
        int y = Integer.parseInt(value[1]);
        int N = Integer.parseInt(value[2]);

        for (int i = 1; i <= N; i++) {
            if (i % x == 0 && i % y == 0) {
                pw.println("FizzBuzz");
            } else if (i % x == 0) {
                pw.println("Fizz");
            } else if (i % y == 0) {
                pw.println("Buzz");
            } else {
                pw.println(i);
            }
        }
        br.close();
        pw.close();
    }
}
