package ga_example;

/**
 * Created by vit on 12/31/2015.
 */
public class GA {
    public static void main(String[] args) {
        String s = "";
        for (int i = 0; i < 64; i++) {
            s += Math.round(Math.random());
        }
        //set candidate solution
        FitnessCalc.setSolution(s);

        //create an initial population
        Population myPop = new Population(50, true);

        //evolve our population until we reach an optimum solution
        int generationCount = 0;
        while (myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()){
            generationCount++;
            System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness());
            myPop = Algorithm.evolvePopulation(myPop);
        }
        System.out.println("Solution found!");
        System.out.println("Generation " + generationCount);
        System.out.println("Genes");
        System.out.println(myPop.getFittest());
    }
}
