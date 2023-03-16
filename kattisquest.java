import java.io.*;
import java.util.*;

public class kattisquest {
    static class quest {
        long gold;
        long energy;

        public quest( long energy, long gold ) {
            this.energy = energy;
            this.gold = gold;
        }
    }

    static class QuestComparator implements Comparator<quest> {
        @Override
        public int compare( quest q1, quest q2 ) {
            if (q1.energy == q2.energy) {
                return Long.compare(q1.gold, q2.gold);
            } else {
                return Long.compare(q1.energy, q2.energy);
            }
        }
    }

    public static void main( String[] args ) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int num_cases = Integer.parseInt(br.readLine());

        //treeset of quests & total gold
        TreeMap<Long, PriorityQueue<Long>> questTreeMap = new TreeMap<>();


        for(int i = 0; i < num_cases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                long e = Long.parseLong(st.nextToken());
                long g = Long.parseLong(st.nextToken());
                //getOrDefault bascially creates a priority queue in key does not contain or returns the priority queue as value
                // this priority contains a max heap
                PriorityQueue<Long> pq = questTreeMap.getOrDefault(e, new PriorityQueue<>(Comparator.reverseOrder()));
                pq.offer(g); //logn
                questTreeMap.put(e, pq); // log n
            }
            if (command.equals("query")) {
                long remaining_e = Long.parseLong(st.nextToken());
                long total_gold = 0;

                while (!questTreeMap.isEmpty()) {
                    //take note that floor takes in quest class and not int
                    Long curr_e = questTreeMap.floorKey(remaining_e); // log n

                    //check if currquest is false when there are no eneregy < curr_e
                    if (curr_e == null) {break;}
                    remaining_e -= curr_e;
                    total_gold += questTreeMap.get(curr_e).poll(); //logn
                    if(questTreeMap.get(curr_e).isEmpty()){
                        questTreeMap.remove(curr_e);
                    }
                }
                pw.println(total_gold);
            }
        }
        br.close();
        pw.close();
    }
}
