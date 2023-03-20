import java.util.*;
import java.io.*;

public class ClassyProblem{
    static class Person implements Comparable<Person> {

        public String name;
        public ArrayList<Integer> rank;

        public Person(String name, String title) {
            this.name = name;
            this.rank = new ArrayList<>();
            String[] ranking = title.split("-");
            for (int i = ranking.length - 1; i >= 0; i--) { //reverse order
                if (ranking[i].equals("upper")) {
                    rank.add(3);
                } else if (ranking[i].equals("middle")) {
                    rank.add(2);
                } else {
                    rank.add(1);
                }
            }
            int val = 0;
            for (int i = 0; i < (10 - ranking.length); i++) {
                rank.add(2);
            }
        }

        public int compareTo(Person o) {
            for (int i = 0; i < 10; i++) {
                if (this.rank.get(i) == o.rank.get(i)) {
                    continue;
                }
                if (this.rank.get(i) > o.rank.get(i)) {
                    return -1;
                }
                if (this.rank.get(i) < o.rank.get(i)) {
                    return 1;
                }
            }
            return this.name.compareTo(o.name);
        }
    }


    public static void main( String[] args ) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
        int num_cases = Integer.parseInt(br.readLine());

        for(int j = 0; j < num_cases; j++){
            int people = Integer.parseInt(br.readLine());
            ArrayList<Person> list = new ArrayList<Person>();

            for(int i = 0; i < people; i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                String name = st.nextToken().replace(":","");
                String class_person = st.nextToken();
                list.add(new Person(name,class_person));
            }

            Collections.sort(list);
            for(Person p : list){
                pr.println(p.name);
            }
            pr.println("==============================");
        }
        br.close();
        pr.close();
    }
}
