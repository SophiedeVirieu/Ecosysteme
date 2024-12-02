public class Turtle extends Animal {

    public Turtle(int x, int y) {
        super(x, y);
        this.specie = species.TURTLE;

        this.prews.add(species.JELLY_FISH);
        this.predators.add(species.FALCON);
        this.predators.add(species.SHARK);
        this.myFood.add(Simulation.food.ALGAE);
        this.ground.add(grounds.WATER);
        this.ground.add(grounds.SAND);

        this.speed = 1;
        this.camouflage = 1;
        this.calories = 9;
    }
}
