import java.util.ArrayList;
import java.util.Collections;
public class Day5_2{
    public static int[][] board = new int[990][990];
    public static ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args){
        ArrayList<String> input = FileReader.getInputAsArrayList("input.txt");
        ArrayList<ArrayList<Integer>> coords = formatInput(input);
        // for(ArrayList<Integer> a : coords){
        //     System.out.print("[");
        //     for(int i : a){
        //         System.out.print(i + ",");
        //     }
        //     System.out.print("]");
        //     System.out.println();
        // }
        System.out.println("Answer: " + solve(coords));
    }

    public static int solve(ArrayList<ArrayList<Integer>> input){
        for(ArrayList<Integer> a : input){
            int x1 = a.get(0);
            int y1 = a.get(1);
            int x2 = a.get(2);
            int y2 = a.get(3);

            if(x1 == x2){

                for(int i = Integer.min(y1, y2); i <= Integer.max(y1, y2); i++)
                    board[i][x1]++;

            }else if(y1 == y2){

                for(int i = Integer.min(x1, x2); i <= Integer.max(x1, x2); i++)
                    board[y1][i]++;

            }else{ //     \ /  (Only change for part II)
                int dy, dx; // Evil calculus be like
                if(x1 < x2)
                    dx = 1;
                else
                    dx = -1;

                if(y1 < y2)
                    dy = 1;
                else
                    dy = -1;
                
                for(int i = 0; i <= Math.abs(x1 - x2); i++){
                    board[y1 + i * dy][x1 + i * dx]++;
                }
            }
        }
        int output = 0;
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[i].length; j++)
                if(board[i][j] > 1)
                    output++;
        return output;
    }
    public static ArrayList<ArrayList<Integer>> formatInput(ArrayList<String> input){
        ArrayList<ArrayList<String>> strs = new ArrayList<ArrayList<String>>();
        for(String s : input){
            ArrayList<String> temp = new ArrayList<String>();
            Collections.addAll(temp, s.split(",|\s->\s"));
            strs.add(temp);
        }
        
        for(int i = 0; i < strs.size(); i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(String s : strs.get(i)){
                temp.add(Integer.parseInt(s));
            }
            output.add(temp);
        }
        return output;
    }
}