import java.util.ArrayList;
public class Day3_2 {
    public static int iterations = 0;
    public static void main(String[] args){
        ArrayList<String> temp = FileReader.getInputAsArrayList("input.txt");

        String oxy = filter(temp, true);
        System.out.println("Oxy: " + oxy);
        int oxyD = Integer.parseInt(oxy, 2);
        System.out.println("Oxy: " + oxyD);
        iterations = 0;
        String co2 = filter(temp, false);
        System.out.println("Co2: " + co2);
        int co2D = Integer.parseInt(co2, 2);
        System.out.println("Co2: " + co2D);

    }
    public static String filter(ArrayList<String> given, boolean oxy){
        while(given.size() > 1){
            given = iterate(given, oxy);
            System.out.println(given.size());
        }
        return given.get(0);
    }
    public static ArrayList<String> iterate(ArrayList<String> given, boolean oxy){ // true if iterating for oxygen, false if co2
        ArrayList<String> zeroes = new ArrayList<String>();
        ArrayList<String> ones = new ArrayList<String>();
        for(int i = 0; i < given.size(); i++){
            String s = given.get(i);
            if(s.charAt(iterations) == '0')
                zeroes.add(s);
            else
                ones.add(s);
        }
        iterations++;
        if(oxy)
            return ones.size() >= zeroes.size() ? ones : zeroes;
        else
            return ones.size() >= zeroes.size() ? zeroes : ones;
    }
}
