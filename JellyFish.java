public class JellyFish extends Animal {

    public JellyFish(int x, int y) {
        super(x, y);
        this.specie = species.JELLY_FISH;

        this.predators.add(species.TURTLE);
        this.myFood.add(Simulation.food.FISH);
        this.ground.add(grounds.WATER);

        this.speed = 1;
        this.camouflage = 1;
        this.calories = 3;
    }
}
