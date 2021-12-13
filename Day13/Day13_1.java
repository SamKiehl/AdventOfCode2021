import java.util.ArrayList;
import java.util.Collections;

public class Day13_1{
    public static boolean[][] board = new boolean[1350][1350];
    public static void main(String[] args){
        ArrayList<String> lines = FileReader.getInputAsArrayList("input.txt");
        int[][] folds = new int[12][2];
        int fold = 0;
        for(int i = lines.size() - 12; i < lines.size(); i++){
            folds[fold][0] = lines.get(i).substring(11, 12).equals("y") ? 1 : 0; // y = n : 1; x = n: 1
            folds[fold][1] = Integer.parseInt(lines.get(i).substring(13));
            fold++;
        }
        for(int[] a : folds){
            System.out.println(a[0] + " " + a[1]);
        }
        ArrayList<ArrayList<String>> sCoords = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < lines.size() - 13; i++){
            String[] sCoord = lines.get(i).split(",");
            ArrayList<String> line = new ArrayList<String>();
            Collections.addAll(line, sCoord);
            sCoords.add(line);
        }
        ArrayList<ArrayList<Integer>> iCoords = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < sCoords.size(); i++){
            ArrayList<Integer> iCoord = new ArrayList<Integer>();
            iCoord.add(Integer.parseInt(sCoords.get(i).get(0)));
            iCoord.add(Integer.parseInt(sCoords.get(i).get(1)));
            iCoords.add(iCoord);
        }
        for(ArrayList<Integer> a : iCoords){
            board[a.get(1)][a.get(0)] = true;
        }

        System.out.println(fold(folds));
       
    }

    public static int fold(int[][] folds){
        int[] first = folds[0];
        if(first[0] == 0){ // if y axis
            int dist = 0;
            for(int i = 0; i < board.length; i++){
                for(int j = first[1]; j < board[i].length; j++){
                    if(board[i][j]){
                        dist = j - first[1];
                        board[i][first[1] - dist] = true;
                    }
                }
            }
            int sum = 0;
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < first[1]; j++){
                    if(board[i][j])
                        sum++;
                }
            }
            boolean[][] temp = new boolean[folds.length][first[1]];
            for(int i = 0; i < folds.length; i++){
                for(int j = 0; j < first[1]; j++){
                    board[i][j] = board[i][j];
                }
            }
            board = temp;
            return sum;
        }
        if(first[0] == 1){ // if x axis
            int dist = 0;
            for(int i = first[1]; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(board[i][j]){
                        dist = first[1] - i;
                        board[i - dist][j] = true;
                    }
                }
            }
            int sum = 0;
            for(int i = 0; i < first[1]; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(board[i][j])
                        sum++;
                }
            }
            boolean[][] temp = new boolean[first[1]][folds[0].length];
            for(int i = 0; i < first[1]; i++){
                for(int j = 0; j < first[1]; j++){
                    board[i][j] = board[i][j];
                }
            }
            board = temp;
            return sum;
        }
        return -1;
    }
}