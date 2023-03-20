import java.io.*;
import java.util.StringTokenizer;

public class ShatteredCake {
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Width = Integer.parseInt(br.readLine());
        int num_cakes =  Integer.parseInt(br.readLine());
        int area = 0;
        for(int i = 0; i < num_cakes; i++){
            StringTokenizer st =  new StringTokenizer(br.readLine()," ");
            area += Integer.parseInt(st.nextToken()) *  Integer.parseInt(st.nextToken());
        }
        System.out.println(area/Width);
    }
}
