import java.io.*;
import java.util.*;
public class CardTrading{
    public long buy;
    public long sell; //sell
    public long oppcost; //count of a particular card type, will use index to determine card type

    public CardTrading(int a,int b, int freq ) {
        this.buy = (long) (2-freq)*a;
        this.sell = (long) freq*b;
        this.oppcost =(long) freq*b + (long) (2-freq)*a;

    }

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); //Anthony card
        int t = Integer.parseInt(st.nextToken()); // cardtype
        int k = Integer.parseInt(st.nextToken()); // no of combos

        int[] count = new int[t + 1]; // store freq of anthony cards card type
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            count[Integer.parseInt(st.nextToken())]++;
        }


        //store prices and freq
        PriorityQueue<CardTrading> deck = new PriorityQueue<CardTrading>(Comparator.comparingLong(c -> c.oppcost));

        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int buy = Integer.parseInt(st.nextToken());
            int sell = Integer.parseInt(st.nextToken());
            deck.add(new CardTrading(buy, sell, count[i]));
        }

        int combos = 0;
        long profits = 0;
        long cost = 0;

        //calculating total costs
        while(combos < k) {
            cost += deck.poll().buy;
            combos ++;
        }

        //calculating total profits
        while (!deck.isEmpty()) {
            profits += deck.poll().sell;
        }
        pw.println(profits-cost);
        br.close();
        pw.close();
    }
}