import java.util.*;
import java.io.*;

public class SumKindofProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int sum1 = (n*(n+1)/2);
            int sum2 = n*n;
            int sum3 = n*(n+1);
            pr.println(k +" "+ sum1 + " " + sum2 + " " + sum3);
        }
        br.close();
        pr.close();

        }

}
