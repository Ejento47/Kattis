import java.io.*;
import java.util.*;


public class CoconutSplat {
        int number;

        int counter;

        public CoconutSplat(int number, int counter) {
            this.number = number;
            this.counter = counter;
        }
        public void decrementcounter(){
            this.counter -= 1;
        }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num_syllables = Integer.parseInt(st.nextToken());
        int num_players = Integer.parseInt(st.nextToken());

        // create array of player
        List<CoconutSplat> player = new ArrayList<CoconutSplat>();
        for(int i = 1; i <= num_players; i++){
            player.add(new CoconutSplat(i,3));
        }
        int index = 0;
        while (player.size()>1){
            index = (index +(num_syllables - 1)) % player.size();

            player.get(index).decrementcounter();

            if(player.get(index).counter == 2) {
                player.add(index, new CoconutSplat(player.get(index).number,2));
            }
            else if(player.get(index).counter == 1){
                index++;
            }
            else if(player.get(index).counter == 0 ){
                player.remove(index);
            }

        }
        pw.println(player.get(0).number);
        br.close();
        pw.close();
    }
}
