package ga_example;

/**
 * Created by vit on 12/31/2015.
 */
public class Population {
    //array of individuals
    Individual[] individuals;

    /*Constructors*/
    public Population(int populationSize, boolean initialise){
        individuals = new Individual[populationSize];
        //init population
        if(initialise){
            //loop and create individuals
            for (int i = 0; i < size(); i++) {
                Individual newIndividual = new Individual();
                newIndividual.generateIndividual();
                saveIndividual(i, newIndividual);
            }
        }
    }

    /*Getters*/
    public Individual getIndividual(int index){
        return individuals[index];
    }

    public Individual getFittest(){
        Individual fittest = individuals[0];
        //loop through individuals to find fittest
        for (int i = 0; i < size(); i++) {
            if(fittest.getFitness() <= getIndividual(i).getFitness()){
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }

    /*public methods*/
    //get population size
    public int size(){
        return individuals.length;
    }

    //save individual
    public void saveIndividual(int index, Individual indiv){
        individuals[index] = indiv;
    }
}
