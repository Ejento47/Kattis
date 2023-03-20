import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

public class Akcija {
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < num; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list, Collections.reverseOrder());
        int prices = 0;
        for(int i = 0; i < num;  i++){
            if( (i+1) % 3 != 0 ){
                prices += list.get(i);
            }
        }
        System.out.println(prices);
    }
}
