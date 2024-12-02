public class Hedgehog extends Animal{

    public Hedgehog(int x, int y) {
        super(x, y);
        this.specie = species.HEDGEHOG;

        this.predators.add(species.FALCON);
        this.predators.add(species.WOLF);
        this.myFood.add(Simulation.food.GRASS);
        this.myFood.add(Simulation.food.BERRIES);
        this.ground.add(grounds.FOREST);
        this.ground.add(grounds.PLAIN);

        this.speed = 1;
        this.camouflage = 2;
        this.calories = 5;
    }
}
