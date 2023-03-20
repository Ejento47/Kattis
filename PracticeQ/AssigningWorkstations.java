import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Researcher {
    public int reachingtime;
    public int leavingtime;

    public Researcher(int reachingtime, int stayingtime) {
        this.reachingtime = reachingtime;
        this.leavingtime = reachingtime + stayingtime;
    }
}
class ResearcherComparator implements Comparator<Researcher> {
    public int compare(Researcher r1, Researcher r2) {
        return Integer.compare(r1.reachingtime, r2.reachingtime);
    }
}

public class AssigningWorkstations{
    public static void main(String[] args) throws IOException {
        ResearcherComparator rc = new ResearcherComparator();
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num_workers = Integer.parseInt(st.nextToken());
        int inactivity = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> workstation = new PriorityQueue<Integer>();

        PriorityQueue<Researcher> researcher = new PriorityQueue<Researcher>(rc);

        for(int i = 0 ; i < num_workers; i++){
            st = new StringTokenizer(br.readLine());
            int reachtime = Integer.parseInt(st.nextToken());
            int staytime  = Integer.parseInt(st.nextToken());
            researcher.add(new Researcher(reachtime,staytime));
        }

        int result = 0;

        for( int i = 0; i < num_workers;i++){
            Researcher temp = researcher.peek();

            while (workstation.size() != 0 && workstation.peek() + inactivity < temp.reachingtime ){
                workstation.poll();
            }
            if( workstation.size() != 0 && workstation.peek() <= researcher.peek().reachingtime && researcher.peek().reachingtime <= workstation.peek() + inactivity ){
                workstation.poll();
                result++;
            }
            workstation.add(researcher.poll().leavingtime);
        }
        System.out.println(result);
        br.close();
    }
}
