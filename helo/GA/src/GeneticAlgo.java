public class GeneticAlgo {


    public static void main(String[] args) {
        int generation = 0;
        String target = "tobeornottobe";
        Population pop = new Population(100);
        while(!(pop.getCurrent().equals(target))){
            pop.reproduce();
            generation++;
            System.out.println(pop.getCurrent());
        }
        System.out.println("number of generations : " + generation);

    }
}
