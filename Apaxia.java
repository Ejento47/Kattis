import java.util.Scanner;

public class Apaxia {
    static String proper(String a){
        String output = a.substring(0,1);
        for(int i = 1; i < a.length(); i++){
            if(a.charAt(i) != a.charAt(i-1)) {
                output += a.charAt(i);
            }
        }
        return output;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        System.out.println(proper(in));
    }
}
