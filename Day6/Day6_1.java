import java.util.ArrayList;
public class Day6_1{
    public static ArrayList<Integer> fishes;
    public static void main(String[] args){
        fishes = new ArrayList<Integer>();
        String fishesS = FileReader.getInputAsArrayList("input.txt").get(0);
        for(int i = 0; i < fishesS.length(); i+=2)
            fishes.add(Integer.parseInt(fishesS.substring(i, i+1))); // questionable and stupid
        System.out.println(iterate(80));

    }
    public static int iterate(int times){
        for(int i = 0; i < times; i++){
            int len = fishes.size();
            for(int j = 0; j < len; j++){
                if(fishes.get(j) == 0){
                    fishes.set(j, 6);
                    fishes.add(8);
                }
                else{
                    fishes.set(j, fishes.get(j) - 1);
                }
            }
        }
        return fishes.size();
    }
}