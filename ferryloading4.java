import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ferryloading4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int num_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < num_case; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ferry_len = Integer.parseInt(st.nextToken()) * 100;
            int num_cars = Integer.parseInt(st.nextToken());
            boolean isleft = true;
            int cross = 0;

            // create queue to store cars
            Queue<Integer> left = new LinkedList<Integer>();
            Queue<Integer> right = new LinkedList<Integer>();
            for (int j = 0; j < num_cars; j++) {
                st = new StringTokenizer(br.readLine());
                int len = Integer.parseInt(st.nextToken());
                String loc = st.nextToken();

                if (loc.equals("left")) {
                    left.add(len);
                } else {
                    right.add(len);
                }
            }
            while(!left.isEmpty() || !right.isEmpty()){
                int currlen = 0;
                if(isleft){
                    while(!left.isEmpty()){
                        if(currlen + left.peek() >ferry_len) break;
                        else currlen+= left.poll();
                    }
                    cross++;
                    isleft = !isleft;
                }
                else{
                    while(!right.isEmpty()){
                        if(currlen + right.peek() >ferry_len) break;
                        else currlen+= right.poll();
                    }
                    cross++;
                    isleft = !isleft;
                }
            }
            pw.println(cross);
        }
        br.close();
        pw.close();
    }
}
