package ga_example;

/**
 * Created by vit on 12/31/2015.
 */
public class Algorithm{
    /*GA parameters*/
    public static final double uniformRate = 0.5;
    public static final double mutationRate = 0.015;
    public static final int tournamentSize = 5;
    public static final boolean elitism = true;

    /*public methods*/
    //evolve a population
    public static Population evolvePopulation(Population pop){
        Population newPopulation = new Population(pop.size(), false);

        //keep our best individual
        if (elitism){
            newPopulation.saveIndividual(0, pop.getFittest());
        }

        //crossover population
        int elitismOffset;
        if (elitism){
            elitismOffset = 1;
        } else {
            elitismOffset = 0;
        }

        //loop over the population size and create new individuals with
        //crossover
        for (int i = elitismOffset; i < pop.size(); i++) {
            Individual indiv1 = tournamentSelection(pop);
            Individual indiv2 = tournamentSelection(pop);
            Individual newIndiv = crossover(indiv1,indiv2);
            newPopulation.saveIndividual(i,newIndiv);
        }

        //mutate population
        for (int i = elitismOffset; i < newPopulation.size(); i++) {
            mutate(newPopulation.getIndividual(i));
        }
        return newPopulation;
    }

    //crossover individuals
    private static Individual crossover(Individual individ1, Individual indiv2){
        Individual newSol = new Individual();
        //loop through genes
        for (int i = 0; i < individ1.size(); i++) {
            //crossover
            if (Math.random() <= uniformRate) {
                newSol.setGene(i, individ1.getGene(i));
            } else {
                newSol.setGene(i, indiv2.getGene(i));
            }
        }
        return newSol;
    }

    //mutate an individual
    private static void mutate(Individual indiv){
        //loop through genes
        for (int i = 0; i < indiv.size(); i++) {
            if (Math.random() <= mutationRate){
                //create random gene
                byte gene = (byte)Math.round(Math.random());
                indiv.setGene(i, gene);
            }
        }
    }

    //select individuals for crossover
    private static Individual tournamentSelection(Population pop){
        //create a tournament population
        Population tournament = new Population(tournamentSize, false);
        //for each place in the tournament get a random individual
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int)(Math.random()*pop.size());
            tournament.saveIndividual(i, pop.getIndividual(randomId));
        }
        //get the fittest
        Individual fittest = tournament.getFittest();
        return fittest;
    }
}
