public class JellyFish extends Animal {

    public JellyFish(int x, int y) throws BadGroundException {
        super(x, y);
        this.specie = species.JELLY_FISH;

        this.predators.add(species.TURTLE);
        this.myFood.add(TerrainResources.food.FISH);
        this.ground.add(grounds.WATER);

        this.speed = 1;
        this.camouflage = 1;
        this.calories = 3;
    }

    @Override
    protected void reproduce() throws BadGroundException{
        new JellyFish(this.x+1, this.y);
    };
}
