package ga_example;

/**
 * Created by vit on 12/31/2015.
 */
public class FitnessCalc {
    static byte[] solution = new byte[64];

    /*public mathods*/
    //set a candidate solution as a byte array
    public static void setSolution(byte[] newSolution){
        solution = newSolution;
    }

    //to make it easier we can use this method to set our candidate solution
    //with string of 0s and 1s
    static void setSolution(String newSolution){
        solution = new byte[newSolution.length()];
        //loop through each character of our string and save it in our byte
        //array
        for (int i = 0; i < newSolution.length(); i++) {
            String character = newSolution.substring(i, i+1);
            if (character.contains("0") || character.contains("1")){
                solution[i] = Byte.parseByte(character);
            } else {
                solution[i] = 0;
            }
        }
    }

    //calculate individuals fitness by comparing it to our candidate solution
    static int getFitness(Individual individual){
        int fitness = 0;
        //loop through our individuals genes and compare them to our candidates
        for (int i = 0; i < individual.size() && i< solution.length; i++) {
            if (individual.getGene(i) == solution[i]) {
                fitness++;
            }
        }
        return fitness;
    }

    // get optimum fitness
    static int getMaxFitness(){
        int maxFitness = solution.length;
        return maxFitness;
    }
}
