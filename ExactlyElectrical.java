import java.io.*;
import java.util.*;

public class ExactlyElectrical {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] intial = br.readLine().split(" ");
        String[] finald = br.readLine().split(" ");
        int num = Integer.parseInt(br.readLine());

        num -= Math.abs((Integer.parseInt(finald[0]) - Integer.parseInt(intial[0])));
        num -= Math.abs((Integer.parseInt(finald[1]) - Integer.parseInt(intial[1])));

        if(num > 0 && num  % 2 == 0 )System.out.println('Y') ;
        else if (num == 0) System.out.println('Y');
        else System.out.println('N');
    }
}
