import java.util.Scanner;
import java.util.ArrayList;
public class Day1_1{
    public static void main(String[] args){
        ArrayList<Integer> arr = getInput();
        System.out.println(getIncreases(arr));
        
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