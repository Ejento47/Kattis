import java.io.*;
import java.util.*;

public class Teque {
    public static void main( String[] args ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int operations = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();
        int firsthead = 0;
        int firsttail = 1;
        int lasthead = 0;
        int lasttail = 1;

        for (int i = 0; i < operations; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (command.equals("get")) {
                if (num < first.size()) {
                    pw.println(first.get(num + firsthead + 1));
                }
                else {
                    pw.println(last.get(num - first.size() + lasthead + 1));
                }
                continue;
            }

            if (command.equals("push_back")) {
                last.put(lasttail, num);
                lasttail++;
            } else if (command.equals("push_front")) {
                first.put(firsthead, num);
                firsthead--;
            }
            else{
                first.put(firsttail, num);
                firsttail++;
            }

            //organize first and last maps
            if (first.size() < last.size()) {
                first.put(firsttail, last.get(lasthead + 1));
                last.remove(lasthead+1);
                firsttail ++;
                lasthead ++;
            } else if (first.size() - 1 > last.size()) {
                last.put(lasthead, first.get(firsttail - 1));
                first.remove(firsttail-1);
                lasthead--;
                firsttail--;
            }
        }
        br.close();
        pw.close();
    }
}