import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DelimiterSoup {
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String input = br.readLine();
        String[] arr = input.split("");


        //stack to store open brackets and check the top of stack when there is a closed bracket
        Stack<String> checker = new Stack<String>();
        Integer var = 0;

        for(String chr: arr){

            if (chr.equals(")")){
                if(checker.isEmpty() || !checker.pop().equals("(")){
                    System.out.println(chr + " " + var);
                    br.close();
                    return;
                }
                else{
                    var++;
                    continue;
                }
            }
            if (chr.equals("}")){
                if(checker.isEmpty() || !checker.pop().equals("{")){
                    System.out.println(chr + " " + var);
                    br.close();
                    return;
                }
                else{
                    var++;
                    continue;
                }
            }
            if (chr.equals("]")){
                if(checker.isEmpty() || !checker.pop().equals("[")){
                    System.out.println(chr + " " + var);
                    br.close();
                    return;
                }
                else{
                    var++;
                    continue;
                }
            }
            if(chr.equals(" ")){
                var++;
                continue;
            }
            checker.push(chr);
            var++;
        }
        System.out.println("ok so far");
    }
}
