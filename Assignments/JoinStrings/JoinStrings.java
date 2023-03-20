import java.io.*;
import java.util.*;



public class JoinStrings {

    public static void mergelist( TailedLinkedList list1, TailedLinkedList list2 ) {
            list1.tail.next = list2.head;
            list1.tail = list2.tail;
            list1.num_nodes += (list2.size()-1);
    }

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        //number of strings
        int num_string = Integer.parseInt(br.readLine());
        //If only 1 name
        if (num_string < 2) {
            pw.println(br.readLine());
            br.close();
            pw.close();
            return;
        }

        //array containing linkedlist
        ArrayList<TailedLinkedList> joined = new ArrayList<TailedLinkedList>();
        //list node for current head;
        ListNode curr = null;


        //Hasmap to store number to name
        for (int i = 1; i <= num_string; i++) {
            //temp TLL
            TailedLinkedList temp = new TailedLinkedList();
            temp.addFront(br.readLine());
            joined.add(temp);
        }
        for (int i = 0; i < num_string - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            mergelist(joined.get(a-1),joined.get(b-1));

            if( i == num_string-2){
                curr = joined.get(a-1).head;
            }
        }

        while( curr != null){
            pw.print(curr.getItem());
            curr = curr.next;
        }
        br.close();
        pw.close();

    }
}

