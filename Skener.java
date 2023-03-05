import javax.swing.*;
import java.io.*;
import java.util.*;

public class Skener2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input = br.readLine();
        String[]  integers = input.split(" ");
        int R = Integer.parseInt(integers[0]);
        int C = Integer.parseInt(integers[1]);
        int Zr = Integer.parseInt(integers[2]);
        int Zc = Integer.parseInt(integers[3]);
        String[][] matrix = new String[R][C];

        for (int i = 0; i < R; i++){
            matrix[i] = br.readLine().split("");
            }
        for(int i = 0; i < R; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < C; j++){
                sb.append(matrix[i][j].repeat(Zc));
            }
            for(int k = 0; k < Zr; k++){
                pw.println(sb.toString());
            }
        }
        pw.close();
        br.close();
    }
}
