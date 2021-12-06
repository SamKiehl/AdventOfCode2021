import java.util.ArrayList;
import java.util.Collections;
import java.awt.*;
import java.util.Scanner;
public class Day5_2{
    public static int[][] board = new int[990][990];
    public static void main(String[] args){
        ArrayList<String> input = FileReader.getInputAsArrayList("input.txt");
        ArrayList<ArrayList<Integer>> coords = formatInput(input);
        
        System.out.println("Answer: " + solve(coords));


        Visualizer v = new Visualizer(board);

        // (IGNORE) Exit Window Stuff
        Scanner inp = new Scanner(System.in);
        String in = "...";
        while(!in.equals("")){
            System.out.print("Press [Enter] to exit.");
            in = inp.nextLine();
        }
        System.exit(0);
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
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < strs.size(); i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(String s : strs.get(i)){
                temp.add(Integer.parseInt(s));
            }
            output.add(temp);
        }
        return output;
    }
    static class Visualizer extends Canvas{
        private int[][] b;
        public Visualizer(int[][] b){
            this.b = b;
            setBackground(Color.BLACK);
            setSize(990, 990);
            this.setup();
        }
        public void setup(){
            Frame f = new Frame("Visualizer"); 
            f.pack();
            f.add(this);
            f.setLayout(null);    
            f.setSize(990, 990);    
            f.setVisible(true);  
            System.out.println(this);
        }
        public void paint(Graphics g){
            for(int i = 0; i < 990; i++){
                for(int j = 0; j < 990; j++){
                    g.setColor(Color.BLUE);
                    int s = this.b[i][j];
                    if(s > 0){
                        if(s > 1)
                            g.setColor(Color.RED);
                        g.drawOval(j, i, s, s);
                    }
                }
            }
        }
        
    }
}