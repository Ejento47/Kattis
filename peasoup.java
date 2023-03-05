import java.util.*;
public class one {
    public static void main(String[] args){
        Scanner input =  new Scanner(System.in);
        String a = input.nextLine();
        int num_restaurant = Integer.parseInt(a);


        for (int i = 0; i < num_restaurant; i++){
            boolean pancake = false;
            boolean peasoup = false;
            String b = input.nextLine();
            int num_menu = Integer.parseInt(b);
            String name = input.nextLine();

            for (int j = 0; j < num_menu; j++){
                String item = input.nextLine();
                if (item.equals("pancakes")){
                    pancake = true;
                }
                if (item.equals("pea soup")){
                    peasoup = true;
                }
            }
            if (pancake && peasoup){
                System.out.print(name);
                return;
            }
        }
        System.out.println("Anywhere is fine I guess");
    }
}
