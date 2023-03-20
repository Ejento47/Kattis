import java.util.*;
public class Autori {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Autori Woof = new Autori();
        System.out.println(Woof.func(str));
    }
    public String func(String str) {
        String output = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                output = output + (str.charAt(i));
            }
        }
        return output;
    }
}
