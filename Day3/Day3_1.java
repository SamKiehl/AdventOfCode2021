import java.util.ArrayList;
public class Day3_1{
    public static void main(String[] args){
        ArrayList<String> temp = FileReader.getInputAsArrayList("input.txt");

        String gamma = calculateGamma(get2DArray(temp));
        
        System.out.println("Gamma: " + gamma); // [Line][bit]
        int decimalGamma = Integer.parseInt(gamma, 2);
        System.out.println("Gamma: " + decimalGamma);

        String epsilon = calculateEpsilon(gamma);
        System.out.println("Epsilon: " + epsilon);
        int decimalEpsilon = Integer.parseInt(epsilon, 2);
        System.out.println("Epsilon: " + decimalEpsilon);
        

    }

    public static String calculateGamma(int[][] given){
        String num = "";
        int sum = 0;
        for(int j = 0; j < given[0].length; j++){
            for(int i = 0; i < given.length; i++){
                sum += given[i][j];
            }
            num += (int)Math.round((double)sum / (double)given.length);
            sum = 0;
        }
        return num;
    }

    public static String calculateEpsilon(String gamma){
        String output = "";
        for(int i = 0; i < gamma.length(); i++){
            char c = gamma.charAt(i);
            if(c == '0')
                output += '1';
            else
                output += '0';
        }
        return output;
    }

    public static int[][] get2DArray(ArrayList<String> given){
        int[][] output = new int[given.size()][given.get(0).length()];
        for(int i = 0; i < given.size(); i++){
            for(int j = 0; j < given.get(0).length(); j++){
                output[i][j] = Integer.parseInt(given.get(i).substring(j, j+1));
            }
        }
        return output;
    }
}