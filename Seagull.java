public class Seagull extends Animal{

    public Seagull(int x, int y) throws BadGroundException {
        super(x, y);
        this.specie = species.SEAGULL;

        this.prews.add(species.CRAB);
        this.prews.add(species.SNAKE);
        this.predators.add(species.FALCON);
        this.predators.add(species.SNAKE);
        this.predators.add(species.SHARK);
        this.myFood.add(TerrainResources.food.FISH);
        this.ground.add(grounds.WATER);
        this.ground.add(grounds.SAND);
        this.ground.add(grounds.PLAIN);

        this.speed = 3;
        this.camouflage = 1;
        this.calories = 4;
    }

    @Override
    protected void reproduce() throws BadGroundException{
        new Seagull(this.x+1, this.y);
    };
}
