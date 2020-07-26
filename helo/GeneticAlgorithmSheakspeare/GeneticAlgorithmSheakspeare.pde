import java.util.ArrayList; 
class DNA{

  char[] genes = new char[18];
  String target;
  float fitness; 
  
  DNA(String target){
    //generate random genes
    this.target = target; 
  for(int i = 0; i  < genes.length; i++){
    
    genes[i] = (char)random(32,128);//ascii values for letters
  }
  }
  
  void fitness(){
    int score = 0; 
    for(int i = 0; i < genes.length; i++){
    if(genes[i] == target.charAt(i)){
    score++; 
    }
    }
    fitness = (float)score/target.length(); 
  }
  
  char[] getGenes(){
  return this.genes; 
  }
  
  DNA crossover(DNA partner){
  DNA child = new DNA("to be or not to be"); 

int mid = int(random(child.genes.length)); 

for(int i = 0; i < child.getGenes().length; i++){
if(i > mid) child.genes[i]= genes[i]; 
else child.genes[i] = partner.genes[i]; 
}
return child; 
}

void mutate(float mutationRate){
for(int i = 0; i < genes.length; i++){
if(random(1) < mutationRate){
  genes[i] = (char) random(32,128); 
}
}
}

String phenotype(){
return new String(genes) ;
}


}





DNA[] population = new DNA[100]; 

void mate(){

}

void setup(){
for(int i = 0; i < population.length; i++){
population[i] = new DNA("to be or not to be");
}
}
void draw(){
  //calculate the fitness of each individual 
for(int i = 0; i < population.length; i++){
  population[i].fitness(); 
}
  ArrayList<DNA> matingPool = new ArrayList<DNA>();
for(int i = 0; i < population.length; i++){
int percentage = int(population[i].fitness * 100);
for(int j = 0; j < percentage; j++){
matingPool.add(population[i]);

}
}

for(int i = 0; i < population.length ; i++){
int m= int(random(matingPool.size())); 
int d = int(random(matingPool.size()));

DNA mom = matingPool.get(m); 
DNA dad = matingPool.get(d); 

DNA child = mom.crossover(dad); 
child.mutate(0.1);

population[i] = child; 
println(population[i].phenotype()); 
} 


 
  
  }
  
