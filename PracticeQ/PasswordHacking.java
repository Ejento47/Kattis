import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class PasswordHacking {
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_passwords = Integer.parseInt(br.readLine());
        ArrayList<Double> list =  new ArrayList<>();
        for(int i = 0; i < num_passwords; i++){
            StringTokenizer st =  new StringTokenizer(br.readLine());
            st.nextToken();
            list.add(Double.parseDouble(st.nextToken()));
        }
        Collections.sort(list, Collections.reverseOrder());
        int attempts = 1;
        double expected = 0;
        for(Double num:list){
            expected += attempts*num;
            attempts ++;
        }
        System.out.println(expected);
    }
}
