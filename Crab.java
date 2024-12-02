public class Crab extends Animal{

    public Crab(int x, int y){
        super(x, y);
        this.specie = species.CRAB;

        this.predators.add(species.SEAGULL);
        this.ground.add(grounds.SAND);
        this.ground.add(grounds.WATER);
        this.myFood.add(Simulation.food.ALGAE);
        this.myFood.add(Simulation.food.FISH);

        this.speed = 2;
        this.camouflage = 3;
        this.calories = 4;

    }
}
