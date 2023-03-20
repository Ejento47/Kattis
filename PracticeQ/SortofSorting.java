import java.util.*;

public class SortofSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        List<String> list = null;
        while (i < 500) {

            int num_names = sc.nextInt();
            sc.nextLine();
            if (num_names == 0) break;
            List<String> names = new ArrayList<String>();
            for (int j = 0; j < num_names; j++) {

                String name = sc.nextLine();
                names.add(name);
            }

            Collections.sort(names, (s1, s2) -> s1.substring(0, 2).compareTo(s2.substring(0, 2)));
            for (String outut : names) {
                System.out.println(outut);
            }
        }
    }
}
