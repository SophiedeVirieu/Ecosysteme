public class Crab extends Animal{

    public Crab(int x, int y) throws BadGroundException {
        super(x, y);
        this.specie = species.CRAB;

        this.predators.add(species.SEAGULL);
        this.ground.add(grounds.SAND);
        this.ground.add(grounds.WATER);
        this.myFood.add(TerrainResources.food.ALGAE);
        this.myFood.add(TerrainResources.food.FISH);

        this.speed = 2;
        this.camouflage = 3;
        this.calories = 4;

    }

    @Override
    protected void reproduce() throws BadGroundException{
        new Crab(this.x+1, this.y);
    };
}
