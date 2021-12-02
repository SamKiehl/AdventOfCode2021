import java.util.ArrayList;
import java.util.Scanner;
public class Day2_2{
    public static int x = 0;
    public static int y = 0;
    public static int aim = 0;
    public static void main(String[] args){
        ArrayList<String> temp = getInputs();
        System.out.println(travel(temp));
    }
    public static String travel(ArrayList<String> arr){
        for(int i = 0; i < arr.size(); i++){
            String s = arr.get(i);

            // Value is the number at the end.
            // Dir is the first letter of direction (f, u, d).
            int value = Integer.parseInt(s.substring(s.length() - 1));
            String dir = s.substring(0, 1);

            switch(dir){
                case "f": x += value;
                          y += aim * value;
                    break;
                case "d":
                          aim += value;
                    break;
                case "u":
                          aim -= value;
                    break;
            }
        }
        return "X: " + x + "\tY: " + y + "\tAim: " + aim;
    }
    public static ArrayList<String> getInputs(){ // Enter an empty string ("") at the end of inputs.
        ArrayList<String> output = new ArrayList<String>();
        try(Scanner input = new Scanner(System.in)){
            String in = "...";
            System.out.println("inptus: ");
            while(!in.equals("")){
                in = input.nextLine();
                if(in.equals("")) return output;

                output.add(in);
            }
            return output;
        }
    }
}   