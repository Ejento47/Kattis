import java.util.*;
public class Pot {
    static int fix(int num) {
        int pow = num % 10;
        num /= 10;
        return (int) Math.pow(num,pow);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num_addends = sc.nextInt();
        int output =0;

        for (int i = 0; i < num_addends; i++){
            int p = sc.nextInt();
            output += fix(p);
        }
        System.out.println(output);
    }
}
