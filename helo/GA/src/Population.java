import java.util.ArrayList;
import java.util.Random;

public class Population {

   private  Individual[] individuals;
   private  int populationSize;
   private String current = "";
    /**
     * constructor
     * @param popSize number of individual required in a population
     */
    public Population(int popSize){
        this.populationSize = popSize;
        individuals = new Individual[popSize];
        //initialize the population
        for(int i = 0; i < individuals.length; i++){
            individuals[i] = new Individual("tobeornottobe");
        }
    }

    /**
     * performs roulette wheel selection
     */
    public void reproduce(){
        //calculate the fitness of each individual
       for(int i = 0; i < individuals.length; i++){
           individuals[i].fitness();
       }

       //perform roulette wheel selection
       ArrayList<Individual> matingPool = new ArrayList<>();
       for(int i = 0; i < individuals.length;i++){
           int p = (int)(individuals[i].getFitness()  * 100);
           for(int j = 0; j < p; j++){
               matingPool.add(individuals[i]);
           }
       }

       for(int i = 0; i < individuals.length; i++){
           Random random = new Random();
           int m = random.nextInt(matingPool.size());
           int d = random.nextInt(matingPool.size());

           Individual mom = matingPool.get(m);
           Individual dad = matingPool.get(d);

           Individual child = mom.crossover(dad);
           child.mutate(0.01);

           individuals[i] = child;
           current = child.getPhenotype();
       }



    }

    public Individual[] getIndividuals(){
        return this.individuals;
    }

    public String getCurrent(){
        return this.current;
    }

}
