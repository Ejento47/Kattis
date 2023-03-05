import java.io.*;
import java.util.*;

public class Conformity {
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1){
            System.out.println(1);
        }
        //map is an interface of HASHMAP that stores key and values
        HashMap<HashSet,Integer> a = new HashMap<>();

        for(int i = 0; i < n; i++){
            HashSet<Integer> b = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            b.add(Integer.parseInt(st.nextToken()));
            b.add(Integer.parseInt(st.nextToken()));
            b.add(Integer.parseInt(st.nextToken()));
            b.add(Integer.parseInt(st.nextToken()));
            b.add(Integer.parseInt(st.nextToken()));

            if(a.containsKey(b)){
                a.put(b,a.get(b) + 1);
            }
            else{
                a.put(b,1);
            }
            // System.out.println(b.toString());
        }
        // System.out.println(a.keySet());
        // System.out.println(a.values());

        // there could be more than one popular course, so need number of popular course x its freq.
        int num_popular = Collections.max(a.values());
        int freq = Collections.frequency(a.values(),num_popular);
        System.out.println(freq*num_popular);
    }
}
