import java.util.ArrayList;
public class Day4_1{
    public static void main(String[] args){
        ArrayList<String> temp = FileReader.getInputAsArrayList("input.txt");
        // ArrayList<ArrayList<ArrayList<Integer>>> allBoards = getBoards(temp);
        // ArrayList<ArrayList<Integer>> answers = getOutcomes(allBoards.get(0));
        play(temp);

    }
    

    public static int play(ArrayList<String> arr){
        int[] draws = getDraws(arr);
        ArrayList<ArrayList<ArrayList<Integer>>> allBoards = getBoards(arr);
        ArrayList<Player> players = new ArrayList<Player>();
        for(int i = 0; i < allBoards.size(); i++){
            players.add(new Player(allBoards.get(i), i));
        }
        for(int d : draws){
            for(Player p : players){
                for(int i = 0; i < p.b.size(); i++){
                    if(p.b.get(i).contains(d)){
                        for(ArrayList<Integer> a : p.wins){
                            if(a.contains(d))
                                a.remove(a.indexOf(d));
                            for(int k = 0; k < p.b.size(); k++){
                                if(p.b.get(k).contains(d))
                                    p.b.get(k).set(p.b.get(k).indexOf(d), -1);
                            }
                        }
                    }
                }
                for(int j = 0 ; j < p.wins.size(); j++){
                    if(p.wins.get(j).size() == 0){
                        //System.out.println("Player " + p.getId() + " has won! d: " + d + " answer: " +);
                        int sum = 0;
                        for(ArrayList<Integer> a : p.b){
                            for(int l : a){
                                if(l != -1){
                                    sum += l;
                                }
                            }
                        }
                        System.out.println("Player " + p.getId() + " has won! d: " + d + " answer: " + sum * d);
                        return sum * d;
                    }
                }
            }
        }
        return-1;
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

        for(ArrayList<Integer> i : output){
            for(int ii : i ){
                System.out.print(ii + "\s");
            }
            System.out.println();
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

        public Player(ArrayList<ArrayList<Integer>> b, int id){
            this.b = b;
            this.wins = getOutcomes(this.b);
            this.id = id;
        }
        public int getId(){return id;}
    }
}