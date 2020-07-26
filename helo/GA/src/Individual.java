import java.util.Random;

public class Individual {

    private char[] genes = new char[13];
    private String target;
   private  double fitness;

    Random random  =new Random();


    public Individual(String target){
        this.target = target;
        //generate random genes aka variation
        for(int i = 0; i < genes.length; i++){
            genes[i] = (char)(random.nextInt(26) + 'a');
        }
    }

    /**
     * calculates the fitness of an individual
     * compare the genes with the target
     */
    public void fitness(){
        int score = 0;
        for(int i = 0; i < genes.length; i++){
            if(genes[i] == target.charAt(i)){
                score++;
            }
        }
        fitness = (double) score / target.length();
    }


    /**
     * get the String expression of the genes aka phenotype
     * @return the phenotype
     */
    public String getPhenotype(){
        return new String(genes);
    }

    /**
     * performs reproduction by making crossover between two parents
     */
     public Individual crossover(Individual partner){
         Individual child = new Individual("tobeornottobe");

         //choose an arbitrary midpoint
         int midpoint = random.nextInt(child.genes.length);

         for(int i = 0; i < child.genes.length; i++){
             if(i > midpoint){
                 child.genes[i] = genes[i];
             }else{
                 child.genes[i] = partner.genes[i];
             }

         }
         return child;
     }

    /**
     * performs mutation to maintain the principle of variation
     * @param mutationRate is the mutation rate
     */
    public void mutate(double mutationRate){
         for(int i = 0; i < genes.length; i++){
             if(random.nextDouble()  < mutationRate){
                 genes[i] = (char) (random.nextInt(26) + 'a');
             }
         }
     }

     public double getFitness(){
        return this.fitness;
     }
}
