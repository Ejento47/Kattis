import java.util.Scanner;
import java.lang.*;

public class DetailedDifferences {
    public String compare(String a, String b) {
        String output = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                output += ".";
            }
            else {
                output += "*";
            }
        }
        return output;
    }
    public static void main(String[] args){
        DetailedDifferences DD = new DetailedDifferences();
        Scanner sc = new Scanner(System.in);
        int num_test = sc.nextInt();
        sc.nextLine();
        for ( int j = 0; j < num_test; j++){
            String first = sc.nextLine();
            String second = sc.nextLine();
            System.out.println(first);
            System.out.println(second);
            System.out.println(DD.compare(first,second));
            System.out.println();
        }

    }
}
