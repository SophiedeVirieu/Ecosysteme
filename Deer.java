public class Deer extends Animal{

    public Deer(int x, int y){
        super(x, y);
        this.specie = species.DEER;

        this.predators.add(species.WOLF);
        this.myFood.add(Simulation.food.GRASS);
        this.myFood.add(Simulation.food.BERRIES);
        this.ground.add(grounds.FOREST);
        this.ground.add(grounds.PLAIN);

        this.speed = 4;
        this.camouflage = 2;
        this.calories = 8;
    }
}
