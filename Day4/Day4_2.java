import java.util.ArrayList;
public class Day4_2{
    public static void main(String[] args){
        ArrayList<String> temp = FileReader.getInputAsArrayList("input.txt");
        // ArrayList<ArrayList<ArrayList<Integer>>> allBoards = getBoards(temp);
        // ArrayList<ArrayList<Integer>> answers = getOutcomes(allBoards.get(0));
        play(temp);

    }
    

    public static void play(ArrayList<String> arr){
        int[] draws = getDraws(arr);
        ArrayList<ArrayList<ArrayList<Integer>>> allBoards = getBoards(arr);
        ArrayList<Player> players = new ArrayList<Player>();
        for(int i = 0; i < allBoards.size(); i++)
            players.add(new Player(allBoards.get(i), i));
        System.out.println(draws.length);
        for(int d : draws){
            ArrayList<Player> temp = new ArrayList<Player>();
            for(Player p : players)
                if(!p.hasWon)
                    temp.add(p);
            players = temp;
            //System.out.println(players.size());
                    
            for(Player p : players){
                for(ArrayList<Integer> w : p.wins){
                    if(w.contains(d)){
                        w.remove(w.indexOf(d));
                        for(ArrayList<Integer> row : p.b)
                            if(row.contains(d))
                                row.remove(row.indexOf(d));
                    }
                    if(w.size() == 0){
                        //System.out.println(p.id + " : " + p.hasWon);
                        p.hasWon = true;
                        int sum = 0;
                        for(ArrayList<Integer> row : p.b)
                            for(int i : row)
                                if(i != -1)
                                    sum += i;

                        System.out.println("Player " + p.id + " has won! Answer: " + sum * d);
                    }

                }
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> getOutcomes(ArrayList<ArrayList<Integer>> board){
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>(12);
        //Row, Col Major
        for(int i = 0 ; i < 5; i++){
            ArrayList<Integer> colW = new ArrayList<Integer>();
            ArrayList<Integer> rowW = new ArrayList<Integer>();
            rowW = board.get(i);
            output.add(rowW);
            for(int j  = 0; j < 5; j++){
                colW.add(board.get(j).get(i));
            }
            output.add(colW);
        }
        return output;
    }

    public static  ArrayList<ArrayList<ArrayList<Integer>>> getBoards(ArrayList<String> arr){ // Just... don't look at this... 
        arr.remove(arr.get(0)); // Remove Draws
        arr.remove(arr.get(0)); // Remove Blank Line
        ArrayList<ArrayList<String>> sep = new ArrayList<ArrayList<String>>(); // All lines as string arrays
        for(int i = 0; i < arr.size(); i++){
            String temp = arr.get(i);
            if(!temp.equals(" "))
                sep.add(toArrList(temp.split("\s")));
        }

        for(int i = 0; i < sep.size(); i++){ // Hallelujah
            while(sep.get(i).contains(""))
                sep.get(i).remove(sep.get(i).indexOf(""));
        }
        
        ArrayList<ArrayList<Integer>> sepN = new ArrayList<ArrayList<Integer>>(sep.size()); // All lines as int arrays
        for(int i = 0; i < sep.size(); i++){
            ArrayList<Integer> is = new ArrayList<Integer>();
            for(int j = 0; j < sep.get(i).size(); j++){
                is.add(Integer.parseInt(sep.get(i).get(j)));
            }
            if(is.size() > 0)
                sepN.add(is);
        }
        
        ArrayList<ArrayList<ArrayList<Integer>>> output = new ArrayList<ArrayList<ArrayList<Integer>>>(); // ArrList of boards as 2d int ArrLists
        System.out.println(sepN.size());
        for(int i = 0; i < 100; i++){
            ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>(5);
            for(int j = 0; j < 5; j++){
                b.add(sepN.get(0));
                sepN.remove(0);
            }
            output.add(b);
        }
        return output;

    }

    public static int[] getDraws(ArrayList<String> arr){
        String d = arr.get(0);
        String[] ds = d.split(",");
        int[] dis = new int[ds.length];
        for(int i = 0; i < dis.length; i++)
            dis[i] = Integer.parseInt(ds[i]);
    
        return dis;
    }
    public static ArrayList<String> toArrList(String[] arr){
        ArrayList<String> output = new ArrayList<String>();
        for(String s : arr)
            output.add(s.replaceAll("\s", ""));
        return output;
    }
    static class Player{
        public ArrayList<ArrayList<Integer>> b;
        public ArrayList<ArrayList<Integer>> wins;
        public int id;
        public boolean hasWon;

        public Player(ArrayList<ArrayList<Integer>> b, int id){
            this.b = b;
            this.wins = getOutcomes(this.b);
            this.id = id;
            this.hasWon = false;
        }
        public int getId(){return id;}
    }
}