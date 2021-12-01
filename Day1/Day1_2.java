import java.util.Scanner;
import java.util.ArrayList;
public class Day1_2{
    public static void main(String args[]){
        ArrayList<Integer> temp = getInput();
        temp = compress(temp);
        System.out.println(getIncreases(temp));
    }
    public static ArrayList<Integer> compress(ArrayList<Integer> nums){
        ArrayList<Integer> output = new ArrayList<Integer>();
        for(int i = 1; i < nums.size() - 1; i++){
            int tmsw = nums.get(i-1) + nums.get(i) + nums.get(i + 1);
            output.add(tmsw);
        }
        return output;
    }

    public static int getIncreases(ArrayList<Integer> nums){
        int increases = 0;
        for (int i = 1; i < nums.size(); i++){
            if(nums.get(i) > nums.get(i - 1))
                increases++;
        }
        return increases;
    }

    public static ArrayList<Integer> getInput(){    // input -1 at the end of all inputs.
        try(Scanner input = new Scanner(System.in)){
            ArrayList<Integer> depths = new ArrayList<Integer>();
            int in = 0;
            
            System.out.println("Inputs:");
            while(in != -1){
                in = input.nextInt();

                if(in == -1) 
                    return depths;

                depths.add(in);
            }
            return depths;
        }
    }
}