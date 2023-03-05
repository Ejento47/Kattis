import java.io.*;
import java.util.*;

public class T9Spelling {
    static HashMap<Character, Integer> teledigits = new HashMap<>();
    static {
        teledigits.put(' ', 0);
        teledigits.put('1', 1);
        teledigits.put('a', 2);
        teledigits.put('b', 22);
        teledigits.put('c', 222);
        teledigits.put('d', 3);
        teledigits.put('e', 33);
        teledigits.put('f', 333);
        teledigits.put('g', 4);
        teledigits.put('h', 44);
        teledigits.put('i', 444);
        teledigits.put('j', 5);
        teledigits.put('k', 55);
        teledigits.put('l', 555);
        teledigits.put('m', 6);
        teledigits.put('n', 66);
        teledigits.put('o', 666);
        teledigits.put('p', 7);
        teledigits.put('q', 77);
        teledigits.put('r', 777);
        teledigits.put('s', 7777);
        teledigits.put('t', 8);
        teledigits.put('u', 88);
        teledigits.put('v', 888);
        teledigits.put('w', 9);
        teledigits.put('x', 99);
        teledigits.put('y', 999);
        teledigits.put('z', 9999);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input = br.readLine();
        int num_cases = Integer.parseInt(input);

        for (int j = 0; j < num_cases; j++){
            StringBuilder output = new StringBuilder();
            String message = br.readLine();
            int previous = 10;
            for(int i = 0; i < message.length(); i++){
                char c = message.charAt(i);
                if( previous == teledigits.get(c)%10){
                    output.append(" ");
                }
                if (teledigits.containsKey(c)){
                    output.append(teledigits.get(c));
                    previous = teledigits.get(c)%10;
                    }
                }
            pw.println("Case " + "#" + (j+1) +": " + output.toString());
            }
        br.close();
        pw.close();
        }

}
