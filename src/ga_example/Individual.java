package ga_example;

/**
 * Created by vit on 12/31/2015.
 */
public class Individual {
    static int defaultGeneLength = 64;
    private byte[] genes = new byte[defaultGeneLength];
    //cache
    private int fitness = 0;

    //create random individual
    public void generateIndividual(){
        for (int i = 0; i < size(); i++) {
            byte gene = (byte) Math.round(Math.random());
            genes[i] = gene;
        }
    }

    /*getters and setters*/
    //we use this if we want to create individuals with different gene lengths
    public static void setDefaultGeneLength(int length){
        defaultGeneLength = length;
    }

    public byte getGene(int index){
        return genes[index];
    }

    public void setGene(int index, byte value){
        genes[index] = value;
        fitness = 0;
    }

    /*public methods*/
    public int size(){
        return genes.length;
    }

    public int getFitness(){
        if(fitness == 0){
            fitness = FitnessCalc.getFitness(this);
        }
        return fitness;
    }

    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < size(); i++) {
            geneString += getGene(i);
        }
        return geneString;
    }
}
